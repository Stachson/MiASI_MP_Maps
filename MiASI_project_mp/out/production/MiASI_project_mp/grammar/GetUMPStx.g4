/**
 * Syntax of MP format
 */
parser grammar GetUMPStx;

options {
  tokenVocab=GetUMPLex;
}


file :
 	section*
 	EOF
 ;
 
section:
    polylineSection //TODO dodać sekcje
    | polygonSection
    | poiSection
    | SECTstart kvEq* SECTend
    ;

polylineSection:
    POLYLINE SECTstart kvEq* SECTend
    ;

polygonSection:
    POLYGON SECTstart kvEq* SECTend
    ;

poiSection:
    POI SECTstart kvEq* SECTend
    ;

kvEq:
    key=(ID | LabI | TypeI | EndLevelI | DataI | MiastoI | CityIdxI | PlikI | HouseNumberI | StreetDescI | TypI) EQ V
    | ID NUM EQ V
    ;
