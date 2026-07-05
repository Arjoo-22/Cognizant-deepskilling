DECLARE
    CURSOR c_loans IS
        SELECT CustomerID, LoanID, DueDate
        FROM Loans
        WHERE DueDate BETWEEN SYSDATE AND SYSDATE + 30;

BEGIN

    FOR loan IN c_loans LOOP
    
        DBMS_OUTPUT.PUT_LINE(
        'Reminder: Customer ' ||
        loan.CustomerID ||
        ' Loan ID: ' ||
        loan.LoanID ||
        ' Due Date: ' ||
        loan.DueDate
        );
        
    END LOOP;

END;