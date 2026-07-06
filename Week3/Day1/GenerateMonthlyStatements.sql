DECLARE

CURSOR GenerateMonthlyStatements IS

SELECT CustomerID,
TransactionID,
Amount
FROM Transactions
WHERE EXTRACT(MONTH FROM TransactionDate)
=
EXTRACT(MONTH FROM SYSDATE);

cid NUMBER;
tid NUMBER;
amt NUMBER;

BEGIN

OPEN GenerateMonthlyStatements;

LOOP

FETCH GenerateMonthlyStatements
INTO cid,tid,amt;

EXIT WHEN GenerateMonthlyStatements%NOTFOUND;

DBMS_OUTPUT.PUT_LINE(
'Customer: '||cid||
' Transaction: '||tid||
' Amount: '||amt
);

END LOOP;

CLOSE GenerateMonthlyStatements;

END;
/