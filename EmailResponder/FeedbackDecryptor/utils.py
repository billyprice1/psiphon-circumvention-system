# Copyright (c) 2012, Psiphon Inc.
# All rights reserved.
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with this program.  If not, see <http://www.gnu.org/licenses/>.


import sys
import types
import re


###########################
# Helpers primarily used in templates
###########################

# To be used to format datetimes
def timestamp_display(timestamp):
    return '{:%Y-%m-%dT%H:%M:%S}.{:03}Z'.format(timestamp,
                                                timestamp.microsecond / 1000)


# Returns a tuple of (diff_float, diff_display_string). Arguments must be
# datetimes. `last_timestamp` may be None.
def get_timestamp_diff(last_timestamp, timestamp):
    timestamp_diff_secs = 0.0
    if last_timestamp:
        timestamp_diff_secs = (timestamp - last_timestamp).total_seconds()
    timestamp_diff_str = '{:.3f}'.format(timestamp_diff_secs)
    return (timestamp_diff_secs, timestamp_diff_str)


###########################

_psinet = None
def convert_psinet_values(config, obj):
    '''
    Converts sensitive or non-human-readable values in the YAML to IDs and
    names. Modifies the YAML directly.
    '''

    global _psinet
    if not _psinet:
        # Load the psinet DB
        sys.path.append(config['psiOpsPath'])
        import psi_ops
        _psinet = psi_ops.PsiphonNetwork.load_from_file(config['psinetFilePath'])

    if isinstance(obj, string_types):
        return

    for path, val in objwalk(obj):
        if path[-1] == 'ipAddress':
            server = _psinet.get_server_by_ip_address(val)
            if not server:
                server = _psinet.get_deleted_server_by_ip_address(val)
                if server:
                    server.id += ' [DELETED]'

            # If the psinet DB is stale, we might not find the IP address, but
            # we still want to redact it.
            assign_value_to_obj_at_path(obj,
                                        path,
                                        server.id if server else '[UNKNOWN]')
        elif path[-1] == 'PROPAGATION_CHANNEL_ID':
            propagation_channel = _psinet.get_propagation_channel_by_id(val)
            if propagation_channel:
                assign_value_to_obj_at_path(obj,
                                            path,
                                            propagation_channel.name)
        elif path[-1] == 'SPONSOR_ID':
            sponsor = _psinet.get_sponsor_by_id(val)
            if sponsor:
                assign_value_to_obj_at_path(obj,
                                            path,
                                            sponsor.name)


def is_diagnostic_info_sane(obj):
    '''
    Returns true if `obj` is a sane-looking diagnostic info object.
    '''
    # TODO: Add better, more comprehensive checks.
    # TODO: Need to implement per-version, per-platform checks.
    # TODO: Having to increase the sane version range every time the version
    #       changes (and per-platform) is going to cause problems.

    if not isinstance(obj, object):
        return False

    exemplar = {
                'Metadata': {
                             'platform': lambda val: val in ['android', 'windows'],
                             'version': lambda val: val in range(1, 2),
                             'id': lambda val: re.match(r'^[a-fA-F0-9]{16}', val) is not None
                             }
                }

    if not _check_exemplar(obj, exemplar):
        return False

    return True


def _check_exemplar(check, exemplar):
    if isinstance(exemplar, types.DictType):
        if not isinstance(check, types.DictType):
            return False

        for k in exemplar.iterkeys():
            if not k in check:
                return False

            if not _check_exemplar(check[k], exemplar[k]):
                return False

        return True

    elif isinstance(exemplar, types.FunctionType):
        return exemplar(check)

    elif exemplar is None:
        return True

    else:
        # We don't support whatever this is
        assert(False)
        return False

    # Should have hit an exit condition above
    assert(False)


###
# From http://code.activestate.com/recipes/577982-recursively-walk-python-objects/
###

from collections import Mapping, Set, Sequence

# dual python 2/3 compatability, inspired by the "six" library
string_types = (str, unicode) if str is bytes else (str, bytes)
iteritems = lambda mapping: getattr(mapping, 'iteritems', mapping.items)()


def objwalk(obj, path=(), memo=None):
    if memo is None:
        memo = set()
    iterator = None
    if isinstance(obj, Mapping):
        iterator = iteritems
    elif isinstance(obj, (Sequence, Set)) and not isinstance(obj, string_types):
        iterator = enumerate
    if iterator:
        if id(obj) not in memo:
            memo.add(id(obj))
            for path_component, value in iterator(obj):
                for result in objwalk(value, path + (path_component,), memo):
                    yield result
            memo.remove(id(obj))
    else:
        yield path, obj


def assign_value_to_obj_at_path(obj, obj_path, value):
    if not obj or not obj_path:
        return

    target = obj
    for k in obj_path[:-1]:
        target = target[k]
    target[obj_path[-1]] = value


def rename_key_in_obj_at_path(obj, obj_path, new_key):
    if not obj or not obj_path:
        return

    target = obj
    for k in obj_path[:-1]:
        target = target[k]

    # Copy the old value to the new key
    target[new_key] = target[obj_path[-1]]
    # Delete the old key
    del target[obj_path[-1]]
