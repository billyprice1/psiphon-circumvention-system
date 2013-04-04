<?php


/*

DON'T EDIT THIS FILE!

This file was automatically generated by the Lime parser generator.
The real source code you should be looking at is in one or more
grammar files in the Lime format.

THE ONLY REASON TO LOOK AT THIS FILE is to see where in the grammar
file that your error happened, because there are enough comments to
help you debug your grammar.

If you ignore this warning, you're shooting yourself in the brain,
not the foot.

*/

class ProtoParser extends lime_parser {
var $qi = 0;
var $i = array (
  0 => 
  array (
    'directives' => 's 1',
    'directive' => 's 30',
    'include' => 's 33',
    'file' => 's 35',
    '\'start\'' => 'a \'start\'',
    'message' => 'r 1',
  ),
  1 => 
  array (
    'messages' => 's 2',
    'msgspec' => 's 3',
    'message' => 's 5',
  ),
  2 => 
  array (
    '#' => 'r 0',
  ),
  3 => 
  array (
    'msgspec' => 's 3',
    'messages' => 's 4',
    'message' => 's 5',
    '#' => 'r 4',
  ),
  4 => 
  array (
    '#' => 'r 5',
  ),
  5 => 
  array (
    'name' => 's 6',
  ),
  6 => 
  array (
    'spar' => 's 7',
  ),
  7 => 
  array (
    'entries' => 's 8',
    'entry' => 's 11',
    'cardinality' => 's 13',
    'repeated' => 's 26',
    'optional' => 's 27',
    'required' => 's 28',
  ),
  8 => 
  array (
    'epar' => 's 9',
  ),
  9 => 
  array (
    'semicolon' => 's 10',
  ),
  10 => 
  array (
    'message' => 'r 6',
    '#' => 'r 6',
  ),
  11 => 
  array (
    'entry' => 's 11',
    'entries' => 's 12',
    'cardinality' => 's 13',
    'repeated' => 's 26',
    'optional' => 's 27',
    'required' => 's 28',
    'epar' => 'r 7',
  ),
  12 => 
  array (
    'epar' => 'r 8',
  ),
  13 => 
  array (
    'type' => 's 14',
    'uint' => 's 19',
    'data' => 's 20',
    'message' => 's 24',
  ),
  14 => 
  array (
    'name' => 's 15',
  ),
  15 => 
  array (
    'equals' => 's 16',
  ),
  16 => 
  array (
    'number' => 's 17',
  ),
  17 => 
  array (
    'semicolon' => 's 18',
  ),
  18 => 
  array (
    'repeated' => 'r 9',
    'optional' => 'r 9',
    'required' => 'r 9',
    'epar' => 'r 9',
  ),
  19 => 
  array (
    'name' => 'r 14',
  ),
  20 => 
  array (
    'srpar' => 's 21',
    'name' => 'r 15',
  ),
  21 => 
  array (
    'string' => 's 22',
  ),
  22 => 
  array (
    'erpar' => 's 23',
  ),
  23 => 
  array (
    'name' => 'r 16',
  ),
  24 => 
  array (
    'name' => 's 25',
  ),
  25 => 
  array (
    'name' => 'r 17',
  ),
  26 => 
  array (
    'uint' => 'r 10',
    'data' => 'r 10',
    'message' => 'r 10',
  ),
  27 => 
  array (
    'uint' => 'r 11',
    'data' => 'r 11',
    'message' => 'r 11',
  ),
  28 => 
  array (
    'repeated' => 's 29',
    'uint' => 'r 12',
    'data' => 'r 12',
    'message' => 'r 12',
  ),
  29 => 
  array (
    'uint' => 'r 13',
    'data' => 'r 13',
    'message' => 'r 13',
  ),
  30 => 
  array (
    'semicolon' => 's 31',
  ),
  31 => 
  array (
    'directive' => 's 30',
    'directives' => 's 32',
    'include' => 's 33',
    'message' => 'r 1',
  ),
  32 => 
  array (
    'message' => 'r 2',
  ),
  33 => 
  array (
    'string' => 's 34',
  ),
  34 => 
  array (
    'semicolon' => 'r 3',
  ),
  35 => 
  array (
    '#' => 'r 18',
  ),
);
function reduce_0_file_1($tokens, &$result) {
#
# (0) file :=  directives  messages
#
$result = reset($tokens);

    $result = array(
        "directives" => $tokens[0],
        "messages" => $tokens[1]
    );

}

function reduce_1_directives_1($tokens, &$result) {
#
# (1) directives :=
#
$result = reset($tokens);

        $result = array();
    
}

function reduce_2_directives_2($tokens, &$result) {
#
# (2) directives :=  directive  semicolon  directives
#
$result = reset($tokens);

        $result = array_merge(array($tokens[0]), $tokens[2]);
    
}

function reduce_3_directive_1($tokens, &$result) {
#
# (3) directive :=  include  string
#
$result = reset($tokens);

        $result = array(
            "type" => "include",
            "file" => $tokens[1]
        );
    
}

function reduce_4_messages_1($tokens, &$result) {
#
# (4) messages :=  msgspec
#
$result = reset($tokens);

        $result = array($tokens[0]);
    
}

function reduce_5_messages_2($tokens, &$result) {
#
# (5) messages :=  msgspec  messages
#
$result = reset($tokens);

        $result = array_merge(array($tokens[0]), $tokens[1]);
    
}

function reduce_6_msgspec_1($tokens, &$result) {
#
# (6) msgspec :=  message  name  spar  entries  epar  semicolon
#
$result = reset($tokens);

    $result = array(
        "name" => $tokens[1],
        "entries" => $tokens[3]
    );

}

function reduce_7_entries_1($tokens, &$result) {
#
# (7) entries :=  entry
#
$result = reset($tokens);

        $result = array($tokens[0]);
    
}

function reduce_8_entries_2($tokens, &$result) {
#
# (8) entries :=  entry  entries
#
$result = reset($tokens);

        $result = array_merge(array($tokens[0]), $tokens[1]);
    
}

function reduce_9_entry_1($tokens, &$result) {
#
# (9) entry :=  cardinality  type  name  equals  number  semicolon
#
$result = reset($tokens);

        $result = array(
            "cardinality" => $tokens[0],
            "type" => $tokens[1],
            "name" => $tokens[2],
            "id" => $tokens[4]
        );
    
}

function reduce_10_cardinality_1($tokens, &$result) {
#
# (10) cardinality :=  repeated
#
$result = reset($tokens);

        $result = "repeated";
    
}

function reduce_11_cardinality_2($tokens, &$result) {
#
# (11) cardinality :=  optional
#
$result = reset($tokens);

        $result = "optional";
    
}

function reduce_12_cardinality_3($tokens, &$result) {
#
# (12) cardinality :=  required
#
$result = reset($tokens);

        $result = "required";
    
}

function reduce_13_cardinality_4($tokens, &$result) {
#
# (13) cardinality :=  required  repeated
#
$result = reset($tokens);

        $result = "required repeated";
    
}

function reduce_14_type_1($tokens, &$result) {
#
# (14) type :=  uint
#
$result = reset($tokens);

        $result = array(
            "type" => "uint",
            "size" => $tokens[0]
        );
    
}

function reduce_15_type_2($tokens, &$result) {
#
# (15) type :=  data
#
$result = reset($tokens);

        $result = array(
            "type" => "data"
        );
    
}

function reduce_16_type_3($tokens, &$result) {
#
# (16) type :=  data  srpar  string  erpar
#
$result = reset($tokens);

        $result = array(
            "type" => "constdata",
            "size" => $tokens[2]
        );
    
}

function reduce_17_type_4($tokens, &$result) {
#
# (17) type :=  message  name
#
$result = reset($tokens);

        $result = array(
            "type" => "message",
            "message" => $tokens[1]
        );
    
}

function reduce_18_start_1($tokens, &$result) {
#
# (18) 'start' :=  file
#
$result = reset($tokens);

}

var $method = array (
  0 => 'reduce_0_file_1',
  1 => 'reduce_1_directives_1',
  2 => 'reduce_2_directives_2',
  3 => 'reduce_3_directive_1',
  4 => 'reduce_4_messages_1',
  5 => 'reduce_5_messages_2',
  6 => 'reduce_6_msgspec_1',
  7 => 'reduce_7_entries_1',
  8 => 'reduce_8_entries_2',
  9 => 'reduce_9_entry_1',
  10 => 'reduce_10_cardinality_1',
  11 => 'reduce_11_cardinality_2',
  12 => 'reduce_12_cardinality_3',
  13 => 'reduce_13_cardinality_4',
  14 => 'reduce_14_type_1',
  15 => 'reduce_15_type_2',
  16 => 'reduce_16_type_3',
  17 => 'reduce_17_type_4',
  18 => 'reduce_18_start_1',
);
var $a = array (
  0 => 
  array (
    'symbol' => 'file',
    'len' => 2,
    'replace' => true,
  ),
  1 => 
  array (
    'symbol' => 'directives',
    'len' => 0,
    'replace' => true,
  ),
  2 => 
  array (
    'symbol' => 'directives',
    'len' => 3,
    'replace' => true,
  ),
  3 => 
  array (
    'symbol' => 'directive',
    'len' => 2,
    'replace' => true,
  ),
  4 => 
  array (
    'symbol' => 'messages',
    'len' => 1,
    'replace' => true,
  ),
  5 => 
  array (
    'symbol' => 'messages',
    'len' => 2,
    'replace' => true,
  ),
  6 => 
  array (
    'symbol' => 'msgspec',
    'len' => 6,
    'replace' => true,
  ),
  7 => 
  array (
    'symbol' => 'entries',
    'len' => 1,
    'replace' => true,
  ),
  8 => 
  array (
    'symbol' => 'entries',
    'len' => 2,
    'replace' => true,
  ),
  9 => 
  array (
    'symbol' => 'entry',
    'len' => 6,
    'replace' => true,
  ),
  10 => 
  array (
    'symbol' => 'cardinality',
    'len' => 1,
    'replace' => true,
  ),
  11 => 
  array (
    'symbol' => 'cardinality',
    'len' => 1,
    'replace' => true,
  ),
  12 => 
  array (
    'symbol' => 'cardinality',
    'len' => 1,
    'replace' => true,
  ),
  13 => 
  array (
    'symbol' => 'cardinality',
    'len' => 2,
    'replace' => true,
  ),
  14 => 
  array (
    'symbol' => 'type',
    'len' => 1,
    'replace' => true,
  ),
  15 => 
  array (
    'symbol' => 'type',
    'len' => 1,
    'replace' => true,
  ),
  16 => 
  array (
    'symbol' => 'type',
    'len' => 4,
    'replace' => true,
  ),
  17 => 
  array (
    'symbol' => 'type',
    'len' => 2,
    'replace' => true,
  ),
  18 => 
  array (
    'symbol' => '\'start\'',
    'len' => 1,
    'replace' => true,
  ),
);
}
