grammar SnowflakeSql;

@header {
package com.calcite_new.sql.parser.antlr;
}

// Parser Rules
selectStatement
    : withClause? selectCore orderByClause? limitClause?
    ;

withClause
    : WITH RECURSIVE? commonTableExpression (',' commonTableExpression)*
    ;

commonTableExpression
    : identifier ('(' columnName (',' columnName)* ')')? AS '(' selectStatement ')'
    ;

selectCore
    : SELECT setQuantifier? selectList
      fromClause?
      whereClause?
      groupByClause?
      havingClause?
      qualifyClause?
      windowClause?
    ;

setQuantifier
    : DISTINCT | ALL
    ;

selectList
    : selectItem (',' selectItem)*
    ;

selectItem
    : '*'
    | (tableName '.')? '*'
    | expression (AS? columnAlias)?
    ;

fromClause
    : FROM tableExpression (',' tableExpression)*
    ;

tableExpression
    : tablePrimary joinClause*
    ;

tablePrimary
    : tableName (AS? tableAlias)? ('(' columnAlias (',' columnAlias)* ')')?
    | '(' selectStatement ')' (AS? tableAlias)? ('(' columnAlias (',' columnAlias)* ')')?
    | LATERAL? ('(' selectStatement ')') (AS? tableAlias)? ('(' columnAlias (',' columnAlias)* ')')?
    | LATERAL? tableFunctionCall (AS? tableAlias)? ('(' columnAlias (',' columnAlias)* ')')?
    | '(' tableExpression ')' (AS? tableAlias)?
    ;

tableFunctionCall
    : identifier '(' functionArgument? (',' functionArgument)* ')'
    ;

functionArgument
    : expression
    ;

joinClause
    : joinType? JOIN tableExpression (ON expression | USING '(' columnName (',' columnName)* ')')?
    | NATURAL joinType? JOIN tableExpression
    | ',' tableExpression  // Comma join is equivalent to CROSS JOIN
    ;

joinType
    : INNER
    | (LEFT | RIGHT | FULL) OUTER?
    | CROSS
    ;

whereClause
    : WHERE expression
    ;

groupByClause
    : GROUP BY groupByItem (',' groupByItem)*
    ;

groupByItem
    : expression
    | ROLLUP '(' expression (',' expression)* ')'
    | CUBE '(' expression (',' expression)* ')'
    | GROUPING SETS '(' groupingSetItem (',' groupingSetItem)* ')'
    ;

groupingSetItem
    : expression
    | '(' expression (',' expression)* ')'
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
    : '(' identifier? partitionByClause? orderByClause? frameClause? ')'
    ;

partitionByClause
    : PARTITION BY expression (',' expression)*
    ;

orderByClause
    : ORDER BY orderByItem (',' orderByItem)*
    ;

orderByItem
    : expression (ASC | DESC)? (NULLS (FIRST | LAST))?
    ;

frameClause
    : (ROWS | RANGE) (frameStart | BETWEEN frameStart AND frameEnd)
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
    : LIMIT expression (OFFSET expression)?
    ;

// Expression grammar
expression
    : literal
    | columnReference
    | functionCall
    | caseExpression
    | '(' expression ')'
    | expression binaryOperator expression
    | unaryOperator expression
    | expression IS NOT? NULL
    | expression NOT? BETWEEN expression AND expression
    | expression NOT? IN ('(' (expression (',' expression)*)? ')' | selectStatement | tableName)
    | expression NOT? LIKE expression (ESCAPE expression)?
    | EXISTS '(' selectStatement ')'
    | CAST '(' expression AS dataType ')'
    | TRY_CAST '(' expression AS dataType ')'
    | expression COLLATE collationName
    | expression '::' dataType
    | expression SIMILAR TO expression (ESCAPE expression)?
    | expression NOT? ILIKE expression (ESCAPE expression)?
    | expression RLIKE expression
    | expression AT (TIME ZONE | TIMESTAMP) expression
    | expression OVER (windowName | windowSpecification)
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

functionCall
    : aggregateFunction
    | regularFunction
    | specialFunction
    ;

aggregateFunction
    : (COUNT | SUM | AVG | MIN | MAX | STDDEV | VARIANCE) '(' (DISTINCT | ALL)? (expression | '*') ')'
    | COUNT '(' DISTINCT expression (',' expression)* ')'
    | LISTAGG '(' expression (',' STRING_LITERAL)? ')' withinGroup?
    | ARRAY_AGG '(' expression ')' withinGroup?
    | OBJECT_AGG '(' expression ',' expression ')'
    ;

withinGroup
    : WITHIN GROUP '(' orderByClause ')'
    ;

regularFunction
    : identifier '(' functionArgument? (',' functionArgument)* ')'
    ;

specialFunction
    : CURRENT_DATE ('(' ')')?
    | CURRENT_TIME ('(' expression? ')')?
    | CURRENT_TIMESTAMP ('(' expression? ')')?
    | CURRENT_USER ('(' ')')?
    | SUBSTRING '(' expression FROM expression (FOR expression)? ')'
    | EXTRACT '(' identifier FROM expression ')'
    | POSITION '(' expression IN expression ')'
    | DATEADD '(' identifier ',' expression ',' expression ')'
    | DATEDIFF '(' identifier ',' expression ',' expression ')'
    | TRIM '(' (LEADING | TRAILING | BOTH)? expression? FROM expression ')'
    | CONVERT_TIMEZONE '(' expression ',' expression (',' expression)? ')'
    ;

columnReference
    : (tableName '.')? columnName
    ;

tableName
    : (schemaName '.')? identifier
    ;

schemaName
    : (databaseName '.')? identifier
    ;

databaseName
    : identifier
    ;

columnName
    : identifier
    ;

columnAlias
    : identifier
    | STRING_LITERAL
    ;

tableAlias
    : identifier
    | STRING_LITERAL
    ;

windowName
    : identifier
    ;

collationName
    : identifier
    ;

literal
    : NULL
    | INTEGER_LITERAL
    | DECIMAL_LITERAL
    | STRING_LITERAL
    | BINARY_LITERAL
    | BOOLEAN_LITERAL
    | DATE_LITERAL
    | TIME_LITERAL
    | TIMESTAMP_LITERAL
    | INTERVAL_LITERAL
    | arrayLiteral
    | objectLiteral
    | VARIANT_LITERAL
    ;

arrayLiteral
    : 'ARRAY' WS? '[' (expression (',' expression)*)? ']'
    | '[' (expression (',' expression)*)? ']'
    ;

objectLiteral
    : 'OBJECT' WS? '{' (objectField (',' objectField)*)? '}'
    | '{' (objectField (',' objectField)*)? '}'
    ;

objectField
    : (STRING_LITERAL | IDENTIFIER) ':' expression
    ;

dataType
    : 'NUMBER' ('(' INTEGER_LITERAL (',' INTEGER_LITERAL)? ')')?
    | 'INT' | 'INTEGER' | 'BIGINT' | 'SMALLINT'
    | 'FLOAT' | 'FLOAT4' | 'FLOAT8'
    | 'DOUBLE' | 'DOUBLE PRECISION' | 'REAL'
    | 'DECIMAL' ('(' INTEGER_LITERAL (',' INTEGER_LITERAL)? ')')?
    | 'NUMERIC' ('(' INTEGER_LITERAL (',' INTEGER_LITERAL)? ')')?
    | 'VARCHAR' ('(' INTEGER_LITERAL ')')?
    | 'CHAR' ('(' INTEGER_LITERAL ')')?
    | 'CHARACTER' ('(' INTEGER_LITERAL ')')?
    | 'STRING' ('(' INTEGER_LITERAL ')')?
    | 'TEXT'
    | 'BINARY' ('(' INTEGER_LITERAL ')')?
    | 'VARBINARY' ('(' INTEGER_LITERAL ')')?
    | 'BOOLEAN'
    | 'DATE'
    | 'TIME' ('(' INTEGER_LITERAL ')')?
    | 'TIMESTAMP' ('(' INTEGER_LITERAL ')')?
    | 'TIMESTAMP_LTZ' ('(' INTEGER_LITERAL ')')?
    | 'TIMESTAMP_NTZ' ('(' INTEGER_LITERAL ')')?
    | 'TIMESTAMP_TZ' ('(' INTEGER_LITERAL ')')?
    | 'VARIANT'
    | 'OBJECT'
    | 'ARRAY'
    | 'GEOGRAPHY'
    | 'GEOMETRY'
    ;

unaryOperator
    : '-' | '+' | '~' | NOT
    ;

binaryOperator
    : '||' | '*' | '/' | '%' | '+' | '-' | '&' | '|' | '^'
    | '=' | '==' | '!=' | '<>' | '<' | '<=' | '>' | '>='
    | AND | OR
    ;

identifier
    : IDENTIFIER
    | QUOTED_IDENTIFIER
    | nonReservedKeyword
    ;

nonReservedKeyword
    : ABS | ACOS | ACOSH | ALL | AND | ANY | APPROXIMATE | AS | ASC | ASIN
    | ASINH | AT | ATAN | ATAN2 | ATANH | AVG | BETWEEN | BOTH | BY | CASE | CAST
    | CEIL | CEILING | COALESCE | COLLATE | CONVERT_TIMEZONE | COS | COSH | COUNT
    | CUBE | CURRENT | CURRENT_DATE | CURRENT_TIME | CURRENT_TIMESTAMP | CURRENT_USER
    | DATEADD | DATEDIFF | DESC | DISTINCT | ELSE | END | ESCAPE | EXCEPT | EXCLUDE
    | EXISTS | EXTRACT | FIRST | FLATTEN | FLOOR | FOLLOWING | FOR | FROM | FULL
    | GROUP | GROUPING | HAVING | IF | ILIKE | IN | INNER | INTERSECT
    | INTERVAL | IS | JOIN | LAST | LATERAL | LEFT | LIKE | LIMIT | LOCALTIME
    | LOCALTIMESTAMP | LOG | MAX | MIN | MOD | NATURAL | NOT | NULL
    | NULLS | OFFSET | ON | OR | ORDER | OUTER | OVER | PARTITION | PERCENT
    | PRECEDING | QUALIFY | RANGE | REGEXP | RIGHT | RLIKE | ROLLUP | ROW
    | ROWS | SELECT | SIMILAR | SOME | STDDEV | SUBSTRING | SUM | TABLE | THEN
    | TIME | TIMESTAMP | TO | TRIM | TRY_CAST | UNBOUNDED | UNION | USING | VARIANCE
    | WHEN | WHERE | WINDOW | WITH | WITHIN
    ;

// Lexer Rules
ABS: 'ABS';
ACOS: 'ACOS';
ACOSH: 'ACOSH';
ALL: 'ALL';
AND: 'AND';
ANY: 'ANY';
APPROXIMATE: 'APPROXIMATE';
AS: 'AS';
ASC: 'ASC';
ASIN: 'ASIN';
ASINH: 'ASINH';
AT: 'AT';
ATAN: 'ATAN';
ATAN2: 'ATAN2';
ATANH: 'ATANH';
AVG: 'AVG';
BETWEEN: 'BETWEEN';
BOTH: 'BOTH';
BY: 'BY';
CASE: 'CASE';
CAST: 'CAST';
CEIL: 'CEIL';
CEILING: 'CEILING';
COALESCE: 'COALESCE';
COLLATE: 'COLLATE';
CONVERT_TIMEZONE: 'CONVERT_TIMEZONE';
COS: 'COS';
COSH: 'COSH';
COUNT: 'COUNT';
CROSS: 'CROSS';
CUBE: 'CUBE';
CURRENT: 'CURRENT';
CURRENT_DATE: 'CURRENT_DATE';
CURRENT_TIME: 'CURRENT_TIME';
CURRENT_TIMESTAMP: 'CURRENT_TIMESTAMP';
CURRENT_USER: 'CURRENT_USER';
DATEADD: 'DATEADD';
DATEDIFF: 'DATEDIFF';
DESC: 'DESC';
DISTINCT: 'DISTINCT';
ELSE: 'ELSE';
END: 'END';
ESCAPE: 'ESCAPE';
EXCEPT: 'EXCEPT';
EXCLUDE: 'EXCLUDE';
EXISTS: 'EXISTS';
EXTRACT: 'EXTRACT';
FIRST: 'FIRST';
FLATTEN: 'FLATTEN';
FLOOR: 'FLOOR';
FOLLOWING: 'FOLLOWING';
FOR: 'FOR';
FROM: 'FROM';
FULL: 'FULL';
GROUP: 'GROUP';
GROUPING: 'GROUPING';
HAVING: 'HAVING';
IF: 'IF';
ILIKE: 'ILIKE';
IN: 'IN';
INNER: 'INNER';
INTERSECT: 'INTERSECT';
INTERVAL: 'INTERVAL';
IS: 'IS';
JOIN: 'JOIN';
LAST: 'LAST';
LATERAL: 'LATERAL';
LEADING: 'LEADING';
LEFT: 'LEFT';
LIKE: 'LIKE';
LIMIT: 'LIMIT';
LISTAGG: 'LISTAGG';
LOCALTIME: 'LOCALTIME';
LOCALTIMESTAMP: 'LOCALTIMESTAMP';
LOG: 'LOG';
MAX: 'MAX';
MIN: 'MIN';
MOD: 'MOD';
NATURAL: 'NATURAL';
NOT: 'NOT';
NULL: 'NULL';
NULLS: 'NULLS';
OBJECT_AGG: 'OBJECT_AGG';
OFFSET: 'OFFSET';
ON: 'ON';
OR: 'OR';
ORDER: 'ORDER';
OUTER: 'OUTER';
OVER: 'OVER';
PARTITION: 'PARTITION';
PERCENT: 'PERCENT';
POSITION: 'POSITION';
PRECEDING: 'PRECEDING';
QUALIFY: 'QUALIFY';
RANGE: 'RANGE';
RECURSIVE: 'RECURSIVE';
REGEXP: 'REGEXP';
RIGHT: 'RIGHT';
RLIKE: 'RLIKE';
ROLLUP: 'ROLLUP';
ROW: 'ROW';
ROWS: 'ROWS';
SELECT: 'SELECT';
SETS: 'SETS';
SIMILAR: 'SIMILAR';
SOME: 'SOME';
STDDEV: 'STDDEV';
SUBSTRING: 'SUBSTRING';
SUM: 'SUM';
TABLE: 'TABLE';
THEN: 'THEN';
TIME: 'TIME';
TIMESTAMP: 'TIMESTAMP';
TO: 'TO';
TRAILING: 'TRAILING';
TRIM: 'TRIM';
TRY_CAST: 'TRY_CAST';
UNBOUNDED: 'UNBOUNDED';
UNION: 'UNION';
USING: 'USING';
VARIANCE: 'VARIANCE';
WHEN: 'WHEN';
WHERE: 'WHERE';
WINDOW: 'WINDOW';
WITH: 'WITH';
WITHIN: 'WITHIN';
ZONE: 'ZONE';
ARRAY_AGG: 'ARRAY_AGG';

// Lexer rules for literals and identifiers
IDENTIFIER
    : [a-zA-Z_] [a-zA-Z0-9_]*
    ;

QUOTED_IDENTIFIER
    : '"' ( ~'"' | '""' )* '"'
    ;

INTEGER_LITERAL
    : DIGIT+
    ;

DECIMAL_LITERAL
    : DIGIT+ '.' DIGIT* EXPONENT?
    | '.' DIGIT+ EXPONENT?
    | DIGIT+ EXPONENT
    ;

STRING_LITERAL
    : '\'' ( ~'\'' | '\'\'' )* '\''
    ;

BINARY_LITERAL
    : 'X\'' [0-9A-Fa-f]+ '\''
    | '0X' [0-9A-Fa-f]+
    ;

BOOLEAN_LITERAL
    : 'TRUE' | 'FALSE'
    ;

DATE_LITERAL
    : 'DATE' WS? '\'' DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT '\''
    ;

TIME_LITERAL
    : 'TIME' WS? '\'' DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ('.' DIGIT+)? '\''
    ;

TIMESTAMP_LITERAL
    : 'TIMESTAMP' WS? '\'' DIGIT DIGIT DIGIT DIGIT '-' DIGIT DIGIT '-' DIGIT DIGIT
      (' ' | 'T') DIGIT DIGIT ':' DIGIT DIGIT ':' DIGIT DIGIT ('.' DIGIT+)?
      ((' ' | '+' | '-') DIGIT DIGIT (':' DIGIT DIGIT)?)? '\''
    ;

INTERVAL_LITERAL
    : 'INTERVAL' WS? '\'' ('+' | '-')? DIGIT+ WS?
      ('YEAR' | 'YEARS' | 'MONTH' | 'MONTHS' | 'DAY' | 'DAYS' | 'HOUR' | 'HOURS'
       | 'MINUTE' | 'MINUTES' | 'SECOND' | 'SECONDS') '\''
    ;

VARIANT_LITERAL
    : 'PARSE_JSON' '(' STRING_LITERAL ')'
    ;

fragment EXPONENT
    : [Ee] [+-]? DIGIT+
    ;

fragment DIGIT
    : [0-9]
    ;

// Skip whitespace and comments
WS
    : [ \t\r\n\u000C]+ -> skip
    ;

LINE_COMMENT
    : '--' ~[\r\n]* -> skip
    ;

BLOCK_COMMENT
    : '/*' .*? '*/' -> skip
    ;