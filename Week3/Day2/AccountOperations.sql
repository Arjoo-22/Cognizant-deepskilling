-- Create Table
CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    Balance NUMBER
);

-- Package Specification
CREATE OR REPLACE PACKAGE AccountOperations AS

    PROCEDURE OpenAccount(
        p_account_id NUMBER,
        p_customer_id NUMBER,
        p_balance NUMBER
    );

    PROCEDURE CloseAccount(
        p_account_id NUMBER
    );

    FUNCTION GetTotalBalance(
        p_customer_id NUMBER
    ) RETURN NUMBER;

END AccountOperations;
/

-- Package Body
CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(
        p_account_id NUMBER,
        p_customer_id NUMBER,
        p_balance NUMBER
    )
    IS
    BEGIN
        INSERT INTO Accounts(AccountID, CustomerID, Balance)
        VALUES (p_account_id, p_customer_id, p_balance);
    END OpenAccount;

    PROCEDURE CloseAccount(
        p_account_id NUMBER
    )
    IS
    BEGIN
        DELETE FROM Accounts
        WHERE AccountID = p_account_id;
    END CloseAccount;

    FUNCTION GetTotalBalance(
        p_customer_id NUMBER
    )
    RETURN NUMBER
    IS
        v_total NUMBER;
    BEGIN
        SELECT NVL(SUM(Balance), 0)
        INTO v_total
        FROM Accounts
        WHERE CustomerID = p_customer_id;

        RETURN v_total;
    END GetTotalBalance;

END AccountOperations;
/

-- Example
BEGIN
    AccountOperations.OpenAccount(1001, 101, 20000);
    AccountOperations.OpenAccount(1002, 101, 15000);
END;
/

SELECT AccountOperations.GetTotalBalance(101) AS Total_Balance
FROM dual;