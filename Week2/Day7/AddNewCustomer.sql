CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_customerId NUMBER,
    p_name VARCHAR2,
    p_balance NUMBER
)
IS
BEGIN

    INSERT INTO Customers
    VALUES(
        p_customerId,
        p_name,
        p_balance
    );

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
    'Customer Added Successfully'
    );

EXCEPTION

    WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;

        DBMS_OUTPUT.PUT_LINE(
        'Error: Customer already exists'
        );

    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE(
        'Error: ' || SQLERRM
        );

END;
/