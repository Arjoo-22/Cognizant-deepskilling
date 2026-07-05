DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, Age
        FROM Customers;
BEGIN
    FOR cust IN c_customers LOOP
    
        IF cust.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = cust.CustomerID;
        END IF;
        
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Discount applied successfully');

END;
/