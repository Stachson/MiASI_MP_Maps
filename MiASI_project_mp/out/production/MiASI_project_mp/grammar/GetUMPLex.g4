/**
 * Lexer for UMP importer
 */
lexer grammar GetUMPLex;


SECTstart :  '[' .*? ']' -> pushMode(SECTION);

COMMENT
:
    ';' .*? '\n' -> skip
;

WS : [ \t\r\n]+ -> skip ; // skip newlines

//ID_d : [A-Za-z]+ ;

POLYLINE : '[POLYLINE]' ;
POLYGON : '[POLYGON]' ;
POI : '[POI]' ;

mode SECTION;

EQ : '=' ->pushMode(VALUE);

NL : [\r\n]+ -> skip ; // skip newlines

IntComment : '"' .*? '\n' -> skip;

SECTend: '[' ('END'|'End'|'end') ('-' .*?)? ']' -> popMode;

LabI: 'Label' [23];
TypeI: 'Type';
EndLevelI: 'EndLevel';
DataI: 'Data' NUM?;
MiastoI: 'Miasto';
CityIdxI: 'CityIdx';
PlikI: 'Plik';
HouseNumberI: 'HouseNumber';
StreetDescI: 'StreetDesc';
TypI: 'Typ';

ID : [A-Za-z:_]+ ;

NUM : [0-9]+;

mode VALUE;

V : ~[\r\n]* '\n' -> popMode; 
