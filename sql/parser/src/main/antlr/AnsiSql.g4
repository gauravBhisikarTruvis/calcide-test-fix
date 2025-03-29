grammar AnsiSql;

@header {
package com.calcite.sql.parser.antlr;
}

//options { caseInsensitive = true; }

statement
    : selectStatement
    | insertStatement
    | updateStatement
    | deleteStatement
    | mergeStatement
    | dropStatement
    | alterStatement
    | createTableStatement
    | createViewStatement
    | renameStatement
    ;

// Existing SELECT statement rules (unchanged)
selectStatement
    : SELECT distinct? selectList
      fromClause?
      whereClause?
      groupByClause?
      havingClause?
      orderByClause?
      limitClause?
    ;

// New DML and DDL rules
insertStatement
    : INSERT INTO tableName ('(' columnList ')')? (VALUES '(' expr (',' expr)* ')' | selectStatement)
    ;

updateStatement
    : UPDATE tableName SET assignment (',' assignment)* whereClause?
    ;

deleteStatement
    : DELETE FROM tableName whereClause?
    ;

mergeStatement
    : MERGE INTO tableName (AS? alias)? USING tableSource ON expr (WHEN MATCHED THEN UPDATE SET assignment (',' assignment)*)? (WHEN NOT MATCHED THEN INSERT ('(' columnList ')')? VALUES '(' expr (',' expr)* ')')?
    ;

dropStatement
    : DROP (TABLE | VIEW) tableName
    ;

alterStatement
    : ALTER TABLE tableName (RENAME TO tableName | alterAction)
    ;
alterAction
    : ADD COLUMN columnName dataType
    | DROP COLUMN columnName
    | RENAME COLUMN columnName TO columnName
    ;

createTableStatement
    : CREATE TABLE tableName '(' columnDefinition (',' columnDefinition)* ')'
    ;
columnDefinition
    : columnName dataType (PRIMARY KEY | NOT NULL | UNIQUE)*
    ;

createViewStatement
    : CREATE VIEW tableName AS selectStatement
    ;

renameStatement
    : RENAME TABLE tableName TO tableName
    ;

// Supporting rules
dataType
    : ID ('(' NUMBER (',' NUMBER)? ')')?
    ;
assignment
    : columnName '=' expr
    ;

// Existing rules (unchanged, except additions below)
distinct      : DISTINCT | ALL;
selectList    : selectElement (',' selectElement)*;
selectElement : expr (AS? alias)? | '*';
fromClause    : FROM tableSource (',' tableSource)*;
tableSource   : primaryTableSource (joinPart)*;
primaryTableSource
    : tableName (AS? alias)?
    | '(' selectStatement ')' AS? alias
    | '(' tableSource ')'
    ;
joinPart      : joinType 'JOIN' primaryTableSource (ON expr | USING '(' columnList ')')?;
joinType      : NATURAL? (INNER | (LEFT | RIGHT | FULL) OUTER? | CROSS)?;
columnList    : columnName (',' columnName)*;
whereClause   : WHERE expr;
groupByClause : GROUP BY expr (',' expr)* (WITH ROLLUP)?;
havingClause  : HAVING expr;
orderByClause : ORDER BY orderByElement (',' orderByElement)*;
orderByElement: expr (ASC | DESC)?;
limitClause   : LIMIT expr (OFFSET expr)?;

expr
    : '(' expr ')'                                  # parenExpr
    | literal                                       # literalExpr
    | columnRef                                     # columnRefExpr
    | functionCall                                  # functionExpr
    | caseExpr                                      # caseExprs
    | subquery                                      # subqueryExpr
    | expr op=('*'|'/'|'%') expr                    # binaryExpr
    | expr op=('+'|'-') expr                        # binaryExpr
    | expr op=('='|'<>'|'!='|'<'|'>'|'<='|'>=') expr # binaryExpr
    | expr NOT? LIKE expr                           # likeExpr
    | expr IS NOT? NULL                             # isNullExpr
    | expr (NOT)? IN '(' selectStatement ')'        # inSubqueryExpr
    | EXISTS '(' selectStatement ')'                # existsExpr
    ;

subquery      : '(' selectStatement ')';
caseExpr      : CASE expr? (WHEN expr THEN expr)+ (ELSE expr)? END;
functionCall  : functionName '(' star ')' | functionName '(' (expr (',' expr)*)? ')';
columnRef     : (tableName '.')? columnName;
literal       : STRING_LITERAL | NUMBER | NULL;
alias         : ID;
tableName     : ID;
columnName    : ID;
functionName  : ID;
star          : STAR;

// Lexer rules (updated with new keywords)
SELECT: 'SELECT'; FROM: 'FROM'; WHERE: 'WHERE'; GROUP: 'GROUP'; BY: 'BY';
HAVING: 'HAVING'; ORDER: 'ORDER'; LIMIT: 'LIMIT'; AS: 'AS'; JOIN: 'JOIN';
INNER: 'INNER'; LEFT: 'LEFT'; RIGHT: 'RIGHT'; FULL: 'FULL'; OUTER: 'OUTER';
CROSS: 'CROSS'; NATURAL: 'NATURAL'; ON: 'ON'; USING: 'USING'; DISTINCT: 'DISTINCT';
ALL: 'ALL'; WITH: 'WITH'; ROLLUP: 'ROLLUP'; ASC: 'ASC'; DESC: 'DESC'; OFFSET: 'OFFSET';
LIKE: 'LIKE'; IS: 'IS'; NULL: 'NULL'; IN: 'IN'; EXISTS: 'EXISTS'; CASE: 'CASE';
WHEN: 'WHEN'; THEN: 'THEN'; ELSE: 'ELSE'; END: 'END'; MATCHED: 'MATCHED';

// New keywords for DML/DDL
INSERT: 'INSERT'; INTO: 'INTO'; VALUES: 'VALUES';
UPDATE: 'UPDATE'; SET: 'SET'; DELETE: 'DELETE';
MERGE: 'MERGE'; DROP: 'DROP'; ALTER: 'ALTER';
CREATE: 'CREATE'; TABLE: 'TABLE'; VIEW: 'VIEW';
RENAME: 'RENAME'; TO: 'TO'; COLUMN: 'COLUMN';
ADD: 'ADD'; PRIMARY: 'PRIMARY'; KEY: 'KEY';
NOT: 'NOT'; UNIQUE: 'UNIQUE';

// Existing lexer rules (order preserved)
STAR          : '*';
ID            : [a-zA-Z_][a-zA-Z0-9_]*;
STRING_LITERAL: '\'' (~'\'' | '\'\'')* '\'';
NUMBER        : [0-9]+ ('.' [0-9]*)?;
WS            : [ \t\n\r]+ -> skip;

EQ  : '=';
NEQ : '<>' | '!=';
LT  : '<';
GT  : '>';
LEQ : '<=';
GEQ : '>=';