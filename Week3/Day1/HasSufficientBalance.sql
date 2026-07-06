CREATE OR REPLACE FUNCTION HasSufficientBalance(
    accId NUMBER,
    amount NUMBER
)
RETURN BOOLEAN
IS
    bal NUMBER;
BEGIN

    SELECT Balance
    INTO bal
    FROM Accounts
    WHERE AccountID=accId;

    RETURN bal>=amount;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
    RETURN FALSE;
END;
/