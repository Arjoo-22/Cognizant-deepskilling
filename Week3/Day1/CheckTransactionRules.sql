CREATE OR REPLACE TRIGGER CheckTransactionRules

BEFORE INSERT
ON Transactions

FOR EACH ROW

DECLARE
bal NUMBER;

BEGIN

SELECT Balance
INTO bal
FROM Accounts
WHERE AccountID=:NEW.AccountID;

IF :NEW.TransactionType='Withdrawal'
THEN

    IF :NEW.Amount>bal THEN

    RAISE_APPLICATION_ERROR(
    -20001,
    'Insufficient Balance'
    );

    END IF;

END IF;

IF :NEW.TransactionType='Deposit'
THEN

    IF :NEW.Amount<=0 THEN

    RAISE_APPLICATION_ERROR(
    -20002,
    'Deposit amount must be positive'
    );

    END IF;

END IF;

END;
/
