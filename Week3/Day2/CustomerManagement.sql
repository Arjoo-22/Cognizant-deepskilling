-- Create Table
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Balance NUMBER
);

-- Package Specification
CREATE OR REPLACE PACKAGE CustomerManagement AS

    PROCEDURE AddCustomer(
        p_customer_id NUMBER,
        p_name VARCHAR2,
        p_balance NUMBER
    );

    PROCEDURE UpdateCustomer(
        p_customer_id NUMBER,
        p_name VARCHAR2,
        p_balance NUMBER
    );

    FUNCTION GetCustomerBalance(
        p_customer_id NUMBER
    ) RETURN NUMBER;

END CustomerManagement;
/

-- Package Body
CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(
        p_customer_id NUMBER,
        p_name VARCHAR2,
        p_balance NUMBER
    )
    IS
    BEGIN
        INSERT INTO Customers(CustomerID, Name, Balance)
        VALUES (p_customer_id, p_name, p_balance);
    END AddCustomer;

    PROCEDURE UpdateCustomer(
        p_customer_id NUMBER,
        p_name VARCHAR2,
        p_balance NUMBER
    )
    IS
    BEGIN
        UPDATE Customers
        SET Name = p_name,
            Balance = p_balance
        WHERE CustomerID = p_customer_id;
    END UpdateCustomer;

    FUNCTION GetCustomerBalance(
        p_customer_id NUMBER
    )
    RETURN NUMBER
    IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance
        INTO v_balance
        FROM Customers
        WHERE CustomerID = p_customer_id;

        RETURN v_balance;
    END GetCustomerBalance;

END CustomerManagement;
/

-- Example
BEGIN
    CustomerManagement.AddCustomer(101, 'Rahul', 5000);
END;
/

BEGIN
    CustomerManagement.UpdateCustomer(101, 'Rahul Sharma', 8000);
END;
/

SELECT CustomerManagement.GetCustomerBalance(101) AS Balance
FROM dual;