DECLARE

CURSOR ApplyAnnualFee IS
SELECT AccountID
FROM Accounts;

accid NUMBER;

fee NUMBER:=500;

BEGIN

OPEN ApplyAnnualFee;

LOOP

FETCH ApplyAnnualFee
INTO accid;

EXIT WHEN ApplyAnnualFee%NOTFOUND;

UPDATE Accounts
SET Balance=Balance-fee
WHERE AccountID=accid;

END LOOP;

CLOSE ApplyAnnualFee;

COMMIT;

END;
/
