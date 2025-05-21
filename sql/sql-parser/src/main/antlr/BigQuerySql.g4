grammar BigQuerySql;

@header {
package com.calcite_new.sql.parser.antlr;
}

statement
    : dmlStatement
    | ddlStatement
    ;

ddlStatement
    : createTableStatement
    | createViewStatement
    ;

dmlStatement
    : selectStatement
    | insertStatement
    | deleteStatement
    | updateStatement
    | mergeStatement
    ;

createViewStatement
    : CREATE (OR REPLACE)? (TEMPORARY | TEMP)? VIEW
      (IF NOT EXISTS)? tableIdentifier
      (
          (LPAREN columnName (',' columnName)* RPAREN)?
          AS queryExpression
          (OPTIONS LPAREN viewOptionList RPAREN)?
      )
    ;

viewOptionList
    : viewOption (',' viewOption)*
    ;

viewOption
    : optionName '=' optionValue
    ;

createTableStatement
    : CREATE (OR REPLACE)? (TEMPORARY | TEMP)? TABLE
      (IF NOT EXISTS)? tableIdentifier
      (
          LIKE sourceTable=tableIdentifier
          | COPY sourceTable=tableIdentifier
          | AS queryExpression
          | CLONE sourceTable=tableIdentifier
          | LPAREN tableElementList RPAREN
            (PARTITION BY partitionExpression)?
            (CLUSTER BY clusteringColumnList)?
            (OPTIONS LPAREN tableOptionList RPAREN)?
      )
    ;

tableElementList
    : tableElement (',' tableElement)*
    ;

tableElement
    : columnDefinition
    | tableConstraint
    ;

columnDefinition
    : columnName dataType
      (DEFAULT defaultExpression)?
      (NOT NULL)?
      (HIDDEN_COLUMN)?
      (PRIMARY KEY)?
      (REFERENCES tableIdentifier (LPAREN columnName RPAREN)? (ON DELETE referentialAction)? (ON UPDATE referentialAction)?)?
      (OPTIONS LPAREN columnOptionList RPAREN)?
      (AS LPAREN generationExpression RPAREN)?
      (GENERATED ALWAYS AS LPAREN generationExpression RPAREN (STORED | VIRTUAL)?)?
    ;

tableConstraint
    : (CONSTRAINT constraintName)?
      (
          PRIMARY KEY LPAREN columnName (',' columnName)* RPAREN
          | FOREIGN KEY LPAREN columnName (',' columnName)* RPAREN
            REFERENCES tableIdentifier (LPAREN columnName (',' columnName)* RPAREN)?
            (ON DELETE referentialAction)?
            (ON UPDATE referentialAction)?
      )
    ;

referentialAction
    : RESTRICT
    | CASCADE
    | SET NULL
    | NO ACTION
    ;

partitionExpression
    : columnName
    | DATE_TRUNC LPAREN columnName ',' dateUnit RPAREN
    | TIMESTAMP_TRUNC LPAREN columnName ',' dateUnit RPAREN
    | RANGE_BUCKET LPAREN columnName ',' GENERATE_ARRAY LPAREN startExpr ',' endExpr ',' stepExpr RPAREN RPAREN
    | RANGE LPAREN startExpr ',' endExpr (',' stepExpr)? RPAREN
    | expression
    ;

clusteringColumnList
    : columnName (',' columnName)*
    ;

tableOptionList
    : tableOption (',' tableOption)*
    ;

tableOption
    : optionName '=' optionValue
    ;

columnOptionList
    : columnOption (',' columnOption)*
    ;

columnOption
    : optionName '=' optionValue
    ;

optionName
    : identifier (DOT identifier)*
    ;

optionValue
    : literal
    | identifier
    ;

defaultExpression
    : expression
    ;

generationExpression
    : expression
    ;

startExpr
    : expression
    ;

endExpr
    : expression
    ;

stepExpr
    : expression
    ;

columnName
    : identifier
    ;

constraintName
    : identifier
    ;

insertStatement
    : INSERT (INTO)? tableIdentifier (AS? alias=identifier)?
      (LPAREN columnReference (',' columnReference)* RPAREN)?
      (
          VALUES valueRow (',' valueRow)*
          | queryExpression
          | ROW (LPAREN expression (',' expression)* RPAREN)?
      )
    ;

valueRow
    : LPAREN expression (',' expression)* RPAREN
    ;

deleteStatement
    : DELETE (FROM)? tableFactor
      WHERE whereCondition=expression
    ;

updateStatement
    : UPDATE tableIdentifier (AS? alias=identifier)?
      SET updateSetItem (',' updateSetItem)*
      (FROM tableExpression (',' tableExpression)*)?
      (WHERE whereCondition=expression)?
    ;

updateSetItem
    : columnReference '=' expression
    | LPAREN columnReference (',' columnReference)* RPAREN '='
      LPAREN expression (',' expression)* RPAREN
    | LPAREN columnReference (',' columnReference)* RPAREN '='
      LPAREN queryExpression RPAREN
    | columnReference '=' DEFAULT
    ;

mergeStatement
    : MERGE INTO targetTable=tableIdentifier (AS? targetAlias=identifier)?
      USING sourceTable=tableExpression
      ON mergeCondition=expression
      mergeMatchedClause*
      mergeNotMatchedByTargetClause*
      mergeNotMatchedBySourceClause*
    ;

mergeMatchedClause
    : WHEN MATCHED (AND matchCondition=expression)? THEN mergeAction
    ;

mergeNotMatchedByTargetClause
    : WHEN NOT MATCHED (BY TARGET)? (AND matchCondition=expression)? THEN mergeAction
    ;

mergeNotMatchedBySourceClause
    : WHEN NOT MATCHED BY SOURCE (AND matchCondition=expression)? THEN mergeAction
    ;

mergeAction
    : UPDATE SET updateSetItem (',' updateSetItem)*
    | DELETE
    | INSERT (LPAREN columnReference (',' columnReference)* RPAREN)?
      VALUES LPAREN expression (',' expression)* RPAREN
    | INSERT ROW
    | INSERT (LPAREN columnReference (',' columnReference)* RPAREN)?
      (ROW | valueRow)
    ;

selectStatement
    : withClause? queryExpression orderByClause? limitClause?
    ;

withClause
    : WITH withQueryItem (',' withQueryItem)*
    ;

withQueryItem
    : identifier AS LPAREN queryExpression RPAREN
    ;

queryExpression
    : queryTerm
    | queryExpression UNION (ALL | DISTINCT)? queryTerm
    | queryExpression EXCEPT (ALL | DISTINCT)? queryTerm
    | queryExpression INTERSECT (ALL | DISTINCT)? queryTerm
    ;

queryTerm
    : queryPrimary
    ;

queryPrimary
    : simpleQuery
    | LPAREN queryExpression RPAREN
    ;

simpleQuery
    : selectClause
      fromClause?
      whereClause?
      groupByClause?
      havingClause?
      qualifyClause?
      windowClause?
      orderByClause?
      limitClause?
    ;

selectClause
    : SELECT setQuantifier? selectItem (',' selectItem)*
    ;

selectItem
    : expression (AS? identifier)?
    | STAR
    | tableWildcard
    ;

tableWildcard
    : tableIdentifier DOT STAR
    ;

fromClause
    : FROM tableExpression (',' tableExpression)*
    ;

tableExpression
    : /*tableFactor
    | */joinedTable
    ;

tableFactor
    : tableIdentifier tableAlias?
    | LPAREN queryExpression RPAREN tableAlias?
    | LPAREN tableExpression RPAREN tableAlias?
    | UNNEST LPAREN expression RPAREN tableAlias? (WITH OFFSET (AS? identifier)?)?
    | functionCall tableAlias?
    ;

tableAlias
    : AS? identifier columnAlias?
    ;

columnAlias
    : LPAREN identifier (',' identifier)* RPAREN
    ;

joinedTable
    : tableFactor
    | joinedTable joinType? JOIN tableExpression joinSpecification?
    ;

joinType
    : INNER
    | CROSS
    | FULL (OUTER)?
    | LEFT (OUTER)?
    | RIGHT (OUTER)?
    ;

joinSpecification
    : ON expression
    | USING LPAREN identifier (',' identifier)* RPAREN
    ;

whereClause
    : WHERE expression
    ;

groupByClause
    : GROUP BY setQuantifier? groupingElement (',' groupingElement)*
    ;

groupingElement
    : expression
    | ROLLUP LPAREN expression (',' expression)* RPAREN
    | CUBE LPAREN expression (',' expression)* RPAREN
    | GROUPING SETS LPAREN groupingSet (',' groupingSet)* RPAREN
    ;

groupingSet
    : LPAREN (expression (',' expression)*)? RPAREN
    ;

havingClause
    : HAVING expression
    ;

qualifyClause
    : QUALIFY expression
    ;

windowClause
    : WINDOW namedWindow (',' namedWindow)*
    ;

namedWindow
    : identifier AS windowSpecification
    ;

windowSpecification
    : LPAREN
      windowName?
      partitionClause?
      orderByClause?
      frameClause?
      RPAREN
    ;

windowName
    : identifier
    ;

partitionClause
    : PARTITION BY expression (',' expression)*
    ;

orderByClause
    : ORDER BY orderingItem (',' orderingItem)*
    ;

orderingItem
    : expression (ASC | DESC)? (NULLS (FIRST | LAST))?
    ;

frameClause
    : frameUnits frameExtent
    ;

frameUnits
    : ROWS
    | RANGE
    ;

frameExtent
    : frameStart
    | BETWEEN frameStart AND frameEnd
    ;

frameStart
    : UNBOUNDED PRECEDING
    | expression PRECEDING
    | CURRENT ROW
    | expression FOLLOWING
    | UNBOUNDED FOLLOWING
    ;

frameEnd
    : UNBOUNDED PRECEDING
    | expression PRECEDING
    | CURRENT ROW
    | expression FOLLOWING
    | UNBOUNDED FOLLOWING
    ;

limitClause
    : LIMIT expression
    ;

setQuantifier
    : ALL
    | DISTINCT
    ;

// Expression syntax
expression
    : logicalOrExpression
    ;

// Logical OR has the lowest precedence
logicalOrExpression
    : logicalAndExpression (OR logicalAndExpression)*
    ;

logicalAndExpression
    : equalityExpression (AND equalityExpression)*
    ;

equalityExpression
    : comparisonExpression ((EQ | NEQ | NE) comparisonExpression)*
    ;

comparisonExpression
    : rangeExpression ((LT | GT | LTE | GTE) rangeExpression)*
    ;

rangeExpression
    : additiveExpression (BETWEEN additiveExpression AND additiveExpression)?
    | additiveExpression (NOT? IN inExpressionList)?
    | additiveExpression (NOT? LIKE additiveExpression (ESCAPE additiveExpression)?)?
    ;

inExpressionList
    : LPAREN queryExpression RPAREN
    | LPAREN (expression (',' expression)*)? RPAREN
    | UNNEST LPAREN expression RPAREN
    ;

additiveExpression
    : multiplicativeExpression ((PLUS | MINUS | CONCAT) multiplicativeExpression)*
    ;

multiplicativeExpression
    : unaryExpression ((STAR | DIVIDE | DIV | MOD) unaryExpression)*
    ;

unaryExpression
    : (NOT | PLUS | MINUS) unaryExpression
    | isExpression
    ;

isExpression
    : primaryExpression (IS NOT? (NULL | NAN | TRUE | FALSE))?
    ;

primaryExpression
    : literalValue                                                                  # literalPE
    | caseExpression                                                                # casePE
    | castExpression                                                                # castPE
    | extractExpression                                                             # extractPE
    | functionCall                                                                  # functionCallPE
    | columnReference                                                               # columnReferencePE
    | arrayExpression                                                               # arrayPE
    | structExpression                                                              # structPE
//    | subquery
    | queryExpression                                                               # queryPE
    | ifExpression                                                                  # ifPE
    | primaryExpression LBRACKET expression RBRACKET                                # arrayElementAccess
    | primaryExpression LBRACKET expression ':' expression RBRACKET                 # arraySlice
    | primaryExpression LBRACKET 'OFFSET' LPAREN expression RPAREN RBRACKET         # arrayOffset
    | primaryExpression LBRACKET 'SAFE_OFFSET' LPAREN expression RPAREN RBRACKET    # arraySafeOffset
    | primaryExpression LBRACKET 'ORDINAL' LPAREN expression RPAREN RBRACKET        # arrayOrdinal
    | primaryExpression LBRACKET 'SAFE_ORDINAL' LPAREN expression RPAREN RBRACKET   # arraySafeOrdinal
//    | primaryExpression DOT identifier
    | LPAREN expression RPAREN                                                      # parenthesisedPE
    ;

ifExpression
    : IF LPAREN expression ',' expression ',' expression RPAREN
    ;

extractExpression
    : EXTRACT LPAREN extractField FROM expression RPAREN
    ;

extractField
    : MICROSECOND
    | MILLISECOND
    | SECOND
    | MINUTE
    | HOUR
    | DAY
    | DAYOFWEEK
    | DAYOFYEAR
    | WEEK
    | MONTH
    | QUARTER
    | YEAR
    | DATE
    | TIME
    | DATETIME
    | identifier
    ;

//subquery
//    : LPAREN SELECT expression RPAREN
//    ;

literalValue
    : NUMERIC_LITERAL      // Numbers (integer, float)
    | STRING_LITERAL       // String literals
    | BYTES_LITERAL        // Bytes literals
    | DATE_LITERAL         // Date literals
    | TIMESTAMP_LITERAL    // Timestamp literals
    | BOOL_LITERAL         // Boolean literals (true/false)
    | NULL                 // NULL value
    ;

caseExpression
    : simpleCaseExpression
    | searchedCaseExpression
    ;

simpleCaseExpression
    : CASE expression (WHEN expression THEN expression)+ (ELSE expression)? END
    ;

searchedCaseExpression
    : CASE (WHEN expression THEN expression)+ (ELSE expression)? END
    ;

castExpression
    : CAST LPAREN expression AS dataType RPAREN
    | SAFE_CAST LPAREN expression AS dataType RPAREN
    ;

arrayExpression
    : LBRACKET (expression (',' expression)*)? RBRACKET
    | ARRAY '<' dataType '>' LBRACKET (expression (',' expression)*)? RBRACKET
    | ARRAY (SELECT selectItem FROM tableExpression whereClause?)
    ;

structExpression
    : STRUCT (LPAREN structField (',' structField)* RPAREN)?
    | STRUCT '<' identifier dataType (',' identifier dataType)* '>'
    ;

structField
    : expression (AS identifier)?
    ;

functionCall
    : (COUNT | SUM | AVG | MIN | MAX) LPAREN (DISTINCT | ALL)? (expression | '*') RPAREN
    | (identifier LPAREN (DISTINCT | ALL)? (expression (',' expression)*)? RPAREN | (ROW_NUMBER | RANK) LPAREN RPAREN) (OVER windowSpecification)?
    | identifier LPAREN '*' RPAREN
    | EXTRACT LPAREN identifier FROM expression RPAREN
    | DATE_ADD LPAREN expression ',' INTERVAL expression dateUnit RPAREN
    | DATE_SUB LPAREN expression ',' INTERVAL expression dateUnit RPAREN
    | DATE_DIFF LPAREN expression ',' expression ',' dateUnit RPAREN
    | TIMESTAMP_ADD LPAREN expression ',' INTERVAL expression dateUnit RPAREN
    | TIMESTAMP_SUB LPAREN expression ',' INTERVAL expression dateUnit RPAREN
    | TIMESTAMP_DIFF LPAREN expression ',' expression ',' dateUnit RPAREN
    | DATE_TRUNC LPAREN expression ',' dateUnit RPAREN
    | TIMESTAMP_TRUNC LPAREN expression ',' dateUnit RPAREN
    | JSON_EXTRACT LPAREN expression ',' expression RPAREN
    | JSON_EXTRACT_SCALAR LPAREN expression ',' expression RPAREN
    | JSON_QUERY LPAREN expression ',' expression RPAREN
    | JSON_VALUE LPAREN expression ',' expression RPAREN
    | TO_JSON_STRING LPAREN expression RPAREN
    | PARSE_JSON LPAREN expression RPAREN
    | ARRAY_AGG LPAREN (DISTINCT | ALL)? expression (ORDER BY orderingItem (',' orderingItem)*)? (LIMIT expression)? RPAREN
    | GENERATE_ARRAY LPAREN expression ',' expression (',' expression)? RPAREN
    | GENERATE_DATE_ARRAY LPAREN expression ',' expression (',' expression)? RPAREN
    ;

comparisonOperator
    : '='
    | '<'
    | '>'
    | '<='
    | '>='
    | '<>'
    | '!='
    ;

// It could refer nested struct field as well
//columnReference
//    : identifier
//    | tableIdentifier DOT identifier
//    | tableIdentifier DOT tableIdentifier DOT identifier
//    ;

columnReference
    : identifier (DOT identifier)*                                           //#simpleColumnReference
//    | tableIdentifier DOT identifier                       //#qualifiedColumnReference
//    | tableIdentifier DOT tableIdentifier DOT identifier   //#fullyQualifiedColumnReference
//    | identifier (DOT identifier)+                         //#structFieldAccess
//    | tableIdentifier DOT identifier (DOT identifier)+     //#qualifiedStructFieldAccess
//    | primaryExpression '[' expression ']'                 #arrayElementAccess
//    | primaryExpression '.' identifier                     #structFieldReferenceAccess
    ;

tableIdentifier
    : identifier (DOT identifier)*
    ;

dataType
    : INT64
    | FLOAT64
    | NUMERIC
    | BIGNUMERIC
    | BOOL
    | BOOLEAN
    | STRING (LPAREN INTEGER_LITERAL RPAREN)?
    | BYTES (LPAREN INTEGER_LITERAL RPAREN)?
    | DATE
    | DATETIME
    | TIME
    | TIMESTAMP
    | INTERVAL
    | GEOGRAPHY
    | JSON
    | ARRAY '<' dataType '>'
    | STRUCT '<' structTypeElement (',' structTypeElement)* '>'
    ;

structTypeElement
    : identifier dataType
    ;

dateUnit
    : YEAR | QUARTER | MONTH | WEEK | DAY | HOUR | MINUTE | SECOND | MILLISECOND | MICROSECOND | NANOSECOND
    ;

literal
    : STRING_LITERAL
    | INTEGER_LITERAL
    | FLOAT_LITERAL
    | TRUE
    | FALSE
    | NULL
    | DATE STRING_LITERAL
    | TIME STRING_LITERAL
    | TIMESTAMP STRING_LITERAL
    | DATETIME STRING_LITERAL
    ;

identifier
    : IDENTIFIER
    | BACKTICK_IDENTIFIER
    | QUOTED_IDENTIFIER
    | nonReservedKeyword
    ;

nonReservedKeyword
    : ALL
    | AND
    | ANY
    | ARRAY
    | AS
    | ASC
    | BETWEEN
    | BY
    | CASE
    | CAST
    | COLLATE
    | CROSS
    | CURRENT
    | DESC
    | DISTINCT
    | ELSE
    | END
    | EXISTS
    | EXTRACT
    | FALSE
    | FIRST
    | FOLLOWING
    | FROM
    | FULL
    | GROUP
    | GROUPING
    | HAVING
    | IN
    | INNER
    | INTERSECT
    | IS
    | JOIN
    | LAST
    | LEFT
    | LIKE
    | LIMIT
    | MONTH
    | NOT
    | NULL
    | NULLS
    | ON
    | OR
    | ORDER
    | OUTER
    | OVER
    | PARTITION
    | PRECEDING
    | QUALIFY
    | RANGE
    | RIGHT
    | ROLLUP
    | ROW
    | ROWS
    | SELECT
    | SETS
    | SOME
    | STRUCT
    | TRUE
    | UNBOUNDED
    | UNION
    | USING
    | WHEN
    | WHERE
    | WINDOW
    | WITH
    | YEAR
    | QUARTER
    ;

// Lexer Rules
ARRAY_AGG               : [Aa] [Rr] [Rr] [Aa] [Yy] [_] [Aa] [Gg] [Gg] ;
ALL                     : [Aa] [Ll] [Ll] ;
AND                     : [Aa] [Nn] [Dd] ;
ANY                     : [Aa] [Nn] [Yy] ;
ARRAY                   : [Aa] [Rr] [Rr] [Aa] [Yy] ;
AS                      : [Aa] [Ss] ;
INTO                   : [Ii] [Nn] [Tt] [Oo] ;
SET                    : [Ss] [Ee] [Tt] ;
ASC                     : [Aa] [Ss] [Cc] ;
AVG                     : [Aa] [Vv] [Gg] ;
BETWEEN                 : [Bb] [Ee] [Tt] [Ww] [Ee] [Ee] [Nn] ;
BY                      : [Bb] [Yy] ;
CASE                    : [Cc] [Aa] [Ss] [Ee] ;
CAST                    : [Cc] [Aa] [Ss] [Tt] ;
COLLATE                 : [Cc] [Oo] [Ll] [Ll] [Aa] [Tt] [Ee] ;
COUNT                   : [Cc] [Oo] [Uu] [Nn] [Tt] ;
CROSS                   : [Cc] [Rr] [Oo] [Ss] [Ss] ;
CUBE                    : [Cc] [Uu] [Bb] [Ee] ;
CURRENT                 : [Cc] [Uu] [Rr] [Rr] [Ee] [Nn] [Tt] ;
DATE                    : [Dd] [Aa] [Tt] [Ee] ;
DATE_ADD                : [Dd] [Aa] [Tt] [Ee] [_] [Aa] [Dd] [Dd] ;
DATE_DIFF               : [Dd] [Aa] [Tt] [Ee] [_] [Dd] [Ii] [Ff] [Ff] ;
DATE_SUB                : [Dd] [Aa] [Tt] [Ee] [_] [Ss] [Uu] [Bb] ;
DATE_TRUNC              : [Dd] [Aa] [Tt] [Ee] [_] [Tt] [Rr] [Uu] [Nn] [Cc] ;
DATETIME                : [Dd] [Aa] [Tt] [Ee] [Tt] [Ii] [Mm] [Ee] ;
TIMESTAMP_ADD           : [Tt] [Ii] [Mm] [Ee] [Ss] [Tt] [Aa] [Mm] [Pp] [_] [Aa] [Dd] [Dd] ;
TIMESTAMP_SUB           : [Tt] [Ii] [Mm] [Ee] [Ss] [Tt] [Aa] [Mm] [Pp] [_] [Ss] [Uu] [Bb] ;
TIMESTAMP_DIFF          : [Tt] [Ii] [Mm] [Ee] [Ss] [Tt] [Aa] [Mm] [Pp] [_] [Dd] [Ii] [Ff] [Ff] ;
TIMESTAMP_TRUNC         : [Tt] [Ii] [Mm] [Ee] [Ss] [Tt] [Aa] [Mm] [Pp] [_] [Tt] [Rr] [Uu] [Nn] [Cc] ;
TO_JSON_STRING          : [Tt] [Oo] [_] [Jj] [Ss] [Oo] [Nn] [_] [Ss] [Tt] [Rr] [Ii] [Nn] [Gg] ;
TIME                    : [Tt] [Ii] [Mm] [Ee] ;
TIMESTAMP               : [Tt] [Ii] [Mm] [Ee] [Ss] [Tt] [Aa] [Mm] [Pp] ;
DESC                    : [Dd] [Ee] [Ss] [Cc] ;
DISTINCT                : [Dd] [Ii] [Ss] [Tt] [Ii] [Nn] [Cc] [Tt] ;
ELSE                    : [Ee] [Ll] [Ss] [Ee] ;
END                     : [Ee] [Nn] [Dd] ;
EXCEPT                  : [Ee] [Xx] [Cc] [Ee] [Pp] [Tt] ;
EXISTS                  : [Ee] [Xx] [Ii] [Ss] [Tt] [Ss] ;
EXTRACT                 : [Ee] [Xx] [Tt] [Rr] [Aa] [Cc] [Tt] ;
FIRST                   : [Ff] [Ii] [Rr] [Ss] [Tt] ;
FOLLOWING               : [Ff] [Oo] [Ll] [Ll] [Oo] [Ww] [Ii] [Nn] [Gg] ;
CREATE                  : [Cc] [Rr] [Ee] [Aa] [Tt] [Ee] ;
REPLACE                 : [Rr] [Ee] [Pp] [Ll] [Aa] [Cc] [Ee] ;
TEMPORARY               : [Tt] [Ee] [Mm] [Pp] [Oo] [Rr] [Aa] [Rr] [Yy] ;
TEMP                    : [Tt] [Ee] [Mm] [Pp] ;
TABLE                   : [Tt] [Aa] [Bb] [Ll] [Ee] ;
VIEW                    : [Vv] [Ii] [Ee] [Ww] ;
IF                      : [Ii] [Ff] ;
COPY                    : [Cc] [Oo] [Pp] [Yy] ;
CLONE                   : [Cc] [Ll] [Oo] [Nn] [Ee] ;
CLUSTER                 : [Cc] [Ll] [Uu] [Ss] [Tt] [Ee] [Rr] ;
OPTIONS                 : [Oo] [Pp] [Tt] [Ii] [Oo] [Nn] [Ss] ;
INSERT                  : [Ii] [Nn] [Ss] [Ee] [Rr] [Tt] ;
DELETE                  : [Dd] [Ee] [Ll] [Ee] [Tt] [Ee] ;
UPDATE                  : [Uu] [Pp] [Dd] [Aa] [Tt] [Ee] ;
MERGE                   : [Mm] [Ee] [Rr] [Gg] [Ee] ;
FROM                    : [Ff] [Rr] [Oo] [Mm] ;
FULL                    : [Ff] [Uu] [Ll] [Ll] ;
GENERATE_ARRAY          : [Gg] [Ee] [Nn] [Ee] [Rr] [Aa] [Tt] [Ee] [_] [Aa] [Rr] [Rr] [Aa] [Yy] ;
GENERATE_DATE_ARRAY     : [Gg] [Ee] [Nn] [Ee] [Rr] [Aa] [Tt] [Ee] [_] [Dd] [Aa] [Tt] [Ee] [_] [Aa] [Rr] [Rr] [Aa] [Yy] ;
GROUP                   : [Gg] [Rr] [Oo] [Uu] [Pp] ;
GROUPING                : [Gg] [Rr] [Oo] [Uu] [Pp] [Ii] [Nn] [Gg] ;
HAVING                  : [Hh] [Aa] [Vv] [Ii] [Nn] [Gg] ;
IN                      : [Ii] [Nn] ;
INNER                   : [Ii] [Nn] [Nn] [Ee] [Rr] ;
INTERSECT               : [Ii] [Nn] [Tt] [Ee] [Rr] [Ss] [Ee] [Cc] [Tt] ;
INTERVAL                : [Ii] [Nn] [Tt] [Ee] [Rr] [Vv] [Aa] [Ll] ;
IS                      : [Ii] [Ss] ;
JOIN                    : [Jj] [Oo] [Ii] [Nn] ;
JSON_EXTRACT            : [Jj] [Ss] [Oo] [Nn] [_] [Ee] [Xx] [Tt] [Rr] [Aa] [Cc] [Tt] ;
JSON_EXTRACT_SCALAR     : [Jj] [Ss] [Oo] [Nn] [_] [Ee] [Xx] [Tt] [Rr] [Aa] [Cc] [Tt] [_] [Ss] [Cc] [Aa] [Ll] [Aa] [Rr] ;
JSON_QUERY              : [Jj] [Ss] [Oo] [Nn] [_] [Qq] [Uu] [Ee] [Rr] [Yy] ;
JSON_VALUE              : [Jj] [Ss] [Oo] [Nn] [_] [Vv] [Aa] [Ll] [Uu] [Ee] ;
LAST                    : [Ll] [Aa] [Ss] [Tt] ;
LEFT                    : [Ll] [Ee] [Ff] [Tt] ;
LIKE                    : [Ll] [Ii] [Kk] [Ee] ;
ESCAPE                 : [Ee] [Ss] [Cc] [Aa] [Pp] [Ee] ;
LIMIT                   : [Ll] [Ii] [Mm] [Ii] [Tt] ;
MAX                     : [Mm] [Aa] [Xx] ;
ROW_NUMBER              : [Rr] [Oo] [Ww] [_] [Nn] [Uu] [Mm] [Bb] [Ee] [Rr] ;
RANK                    : [Rr] [Aa] [Nn] [Kk] ;
MIN                     : [Mm] [Ii] [Nn] ;
NOT                     : [Nn] [Oo] [Tt] ;
HIDDEN_COLUMN           : [Hh] [Ii] [Dd] [Dd] [Ee] [Nn] ;
PRIMARY                 : [Pp] [Rr] [Ii] [Mm] [Aa] [Rr] [Yy] ;
FOREIGN                 : [Ff] [Oo] [Rr] [Ee] [Ii] [Gg] [Nn] ;
RESTRICT                : [Rr] [Ee] [Ss] [Tt] [Rr] [Ii] [Cc] [Tt] ;
CASCADE                 : [Cc] [Aa] [Ss] [Cc] [Aa] [Dd] [Ee] ;
ACTION                  : [Aa] [Cc] [Tt] [Ii] [Oo] [Nn] ;
RANGE_BUCKET           : [Rr] [Aa] [Nn] [Gg] [Ee] [_] [Bb] [Uu] [Cc] [Kk] [Ee] [Tt] ;
NO                      : [Nn] [Oo] ;
KEY                     : [Kk] [Ee] [Yy] ;
REFERENCES              : [Rr] [Ee] [Ff] [Ee] [Rr] [Ee] [Nn] [Cc] [Ee] [Ss] ;
GENERATED               : [Gg] [Ee] [Nn] [Ee] [Rr] [Aa] [Tt] [Ee] [Dd] ;
ALWAYS                  : [Aa] [Ll] [Ww] [Aa] [Yy] [Ss] ;
STORED                  : [Ss] [Tt] [Oo] [Rr] [Ee] [Dd] ;
VIRTUAL                 : [Vv] [Ii] [Rr] [Tt] [Uu] [Aa] [Ll] ;
CONSTRAINT              : [Cc] [Oo] [Nn] [Ss] [Tt] [Rr] [Aa] [Ii] [Nn] [Tt] ;
NULLS                   : [Nn] [Uu] [Ll] [Ll] [Ss] ;
OFFSET                  : [Oo] [Ff] [Ff] [Ss] [Ee] [Tt] ;
ON                      : [Oo] [Nn] ;
OR                      : [Oo] [Rr] ;
ORDER                   : [Oo] [Rr] [Dd] [Ee] [Rr] ;
OUTER                   : [Oo] [Uu] [Tt] [Ee] [Rr] ;
OVER                    : [Oo] [Vv] [Ee] [Rr] ;
PARSE_JSON              : [Pp] [Aa] [Rr] [Ss] [Ee] [_] [Jj] [Ss] [Oo] [Nn] ;
PARTITION               : [Pp] [Aa] [Rr] [Tt] [Ii] [Tt] [Ii] [Oo] [Nn] ;
PRECEDING               : [Pp] [Rr] [Ee] [Cc] [Ee] [Dd] [Ii] [Nn] [Gg] ;
QUALIFY                 : [Qq] [Uu] [Aa] [Ll] [Ii] [Ff] [Yy] ;
RANGE                   : [Rr] [Aa] [Nn] [Gg] [Ee] ;
RIGHT                   : [Rr] [Ii] [Gg] [Hh] [Tt] ;
ROLLUP                  : [Rr] [Oo] [Ll] [Ll] [Uu] [Pp] ;
VALUES                  : [Vv] [Aa] [Ll] [Uu] [Ee] [Ss] ;
ROW                     : [Rr] [Oo] [Ww] ;
ROWS                    : [Rr] [Oo] [Ww] [Ss] ;
SAFE_CAST               : [Ss] [Aa] [Ff] [Ee] [_] [Cc] [Aa] [Ss] [Tt] ;
SELECT                  : [Ss] [Ee] [Ll] [Ee] [Cc] [Tt] ;
STRING                  : [Ss] [Tt] [Rr] [Ii] [Nn] [Gg] ;
BYTES                   : [Bb] [Yy] [Tt] [Ee] [Ss] ;
BOOL                    : [Bb] [Oo] [Oo] [Ll] ;
BOOLEAN                 : [Bb] [Oo] [Oo] [Ll] [Ee] [Aa] [Nn] ;
NUMERIC                 : [Nn] [Uu] [Mm] [Ee] [Rr] [Ii] [Cc] ;
BIGNUMERIC              : [Bb] [Ii] [Gg] [Nn] [Uu] [Mm] [Ee] [Rr] [Ii] [Cc] ;
GEOGRAPHY               : [Gg] [Ee] [Oo] [Gg] [Rr] [Aa] [Pp] [Hh] [Yy] ;
DEFAULT                 : [Dd] [Ee] [Ff] [Aa] [Uu] [Ll] [Tt] ;
YEAR         : [Yy] [Ee] [Aa] [Rr] ;
QUARTER      : [Qq] [Uu] [Aa] [Rr] [Tt] [Ee] [Rr] ;
MONTH        : [Mm] [Oo] [Nn] [Tt] [Hh] ;
WEEK         : [Ww] [Ee] [Ee] [Kk] ;
DAY          : [Dd] [Aa] [Yy] ;
DAYOFWEEK       : [Dd] [Aa] [Yy] [Oo] [Ff] [Ww] [Ee] [Ee] [Kk] ;
DAYOFYEAR       : [Dd] [Aa] [Yy] [Oo] [Ff] [Yy] [Ee] [Aa] [Rr] ;
HOUR         : [Hh] [Oo] [Uu] [Rr] ;
MINUTE       : [Mm] [Ii] [Nn] [Uu] [Tt] [Ee] ;
SECOND       : [Ss] [Ee] [Cc] [Oo] [Nn] [Dd] ;
MILLISECOND  : [Mm] [Ii] [Ll] [Ll] [Ii] [Ss] [Ee] [Cc] [Oo] [Nn] [Dd] ;
MICROSECOND  : [Mm] [Ii] [Cc] [Rr] [Oo] [Ss] [Ee] [Cc] [Oo] [Nn] [Dd] ;
NANOSECOND   : [Nn] [Aa] [Nn] [Oo] [Ss] [Ee] [Cc] [Oo] [Nn] [Dd] ;
TRUE  : [Tt] [Rr] [Uu] [Ee] ;
NAN   : [Nn] [Aa] [Nn] ;
FALSE : [Ff] [Aa] [Ll] [Ss] [Ee] ;
NULL  : [Nn] [Uu] [Ll] [Ll] ;
WITH                    : [Ww] [Ii] [Tt] [Hh] ;
UNION                   : [Uu] [Nn] [Ii] [Oo] [Nn] ;
UNNEST                  : [Uu] [Nn] [Nn] [Ee] [Ss] [Tt] ;
USING                   : [Uu] [Ss] [Ii] [Nn] [Gg] ;
WHERE                   : [Ww] [Hh] [Ee] [Rr] [Ee] ;
SETS                    : [Ss] [Ee] [Tt] [Ss] ;
WINDOW                  : [Ww] [Ii] [Nn] [Dd] [Oo] [Ww] ;
UNBOUNDED               : [Uu] [Nn] [Bb] [Oo] [Uu] [Nn] [Dd] [Ee] [Dd] ;
WHEN                    : [Ww] [Hh] [Ee] [Nn] ;
MATCHED                 : [Mm] [Aa] [Tt] [Cc] [Hh] [Ee] [Dd] ;
SOURCE                  : [Ss] [Oo] [Uu] [Rr] [Cc] [Ee] ;
TARGET                  : [Tt] [Aa] [Rr] [Gg] [Ee] [Tt] ;
THEN                    : [Tt] [Hh] [Ee] [Nn] ;
STRUCT                  : [Ss] [Tt] [Rr] [Uu] [Cc] [Tt] ;
SUM                     : [Ss] [Uu] [Mm] ;
SOME                    : [Ss] [Oo] [Mm] [Ee] ;
INT64                   : [Ii] [Nn] [Tt] '64' ;
FLOAT64                 : [Ff] [Ll] [Oo] [Aa] [Tt] '64' ;
JSON                    : [Jj] [Ss] [Oo] [Nn] ;
LPAREN                  : '(' ;
RPAREN                  : ')' ;
LBRACKET                : '[' ;
RBRACKET                : ']' ;
EQ                      : '=';
NEQ                     : '!=';
NE                      : '<>';
LT                      : '<';
GT                      : '>';
LTE                     : '<=';
GTE                     : '>=';
PLUS                    : '+';
MINUS                   : '-';
STAR                    : '*';
DIVIDE                  : '/';
DIV                     : 'DIV';
MOD                     : 'MOD';
CONCAT                  : '||';
DOT                     : '.';



IDENTIFIER
    : [a-zA-Z_] [a-zA-Z0-9_]*
    ;

BACKTICK_IDENTIFIER
    : '`' ( ~'`' | '``' )* '`'
    ;

QUOTED_IDENTIFIER
    : '"' ( ~'"' | '""' )* '"'
    ;

NUMERIC_LITERAL
    : DIGIT+ (DOT DIGIT*)? (('E'|'e') ('+'|'-')? DIGIT+)?
    ;

STRING_LITERAL
    : '\'' ( ~'\'' | '\'\'' )* '\''
    ;

BYTES_LITERAL
    : 'b' STRING_LITERAL
    | 'rb' STRING_LITERAL
    ;

DATE_LITERAL
    : 'DATE' STRING_LITERAL
    ;

TIMESTAMP_LITERAL
    : 'TIMESTAMP' STRING_LITERAL
    ;

BOOL_LITERAL
    : TRUE | FALSE
    ;

INTEGER_LITERAL
    : DIGIT+
    ;

FLOAT_LITERAL
    : DIGIT+ DOT DIGIT* EXPONENT?
    | DOT DIGIT+ EXPONENT?
    | DIGIT+ EXPONENT
    ;

fragment DIGIT
    : [0-9]
    ;

fragment EXPONENT
    : [eE] [+\-]? DIGIT+
    ;

WS
    : [ \t\r\n]+ -> skip
    ;

COMMENT
    : '--' ~[\r\n]* -> skip
    ;

MULTILINE_COMMENT
    : '/*' .*? '*/' -> skip
    ;