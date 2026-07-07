-- Create Table
CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Salary NUMBER
);

-- Package Specification
CREATE OR REPLACE PACKAGE EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_emp_id NUMBER,
        p_name VARCHAR2,
        p_salary NUMBER
    );

    PROCEDURE UpdateEmployee(
        p_emp_id NUMBER,
        p_name VARCHAR2,
        p_salary NUMBER
    );

    FUNCTION CalculateAnnualSalary(
        p_emp_id NUMBER
    ) RETURN NUMBER;

END EmployeeManagement;
/

-- Package Body
CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_emp_id NUMBER,
        p_name VARCHAR2,
        p_salary NUMBER
    )
    IS
    BEGIN
        INSERT INTO Employees(EmployeeID, Name, Salary)
        VALUES (p_emp_id, p_name, p_salary);
    END HireEmployee;

    PROCEDURE UpdateEmployee(
        p_emp_id NUMBER,
        p_name VARCHAR2,
        p_salary NUMBER
    )
    IS
    BEGIN
        UPDATE Employees
        SET Name = p_name,
            Salary = p_salary
        WHERE EmployeeID = p_emp_id;
    END UpdateEmployee;

    FUNCTION CalculateAnnualSalary(
        p_emp_id NUMBER
    )
    RETURN NUMBER
    IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary
        INTO v_salary
        FROM Employees
        WHERE EmployeeID = p_emp_id;

        RETURN v_salary * 12;
    END CalculateAnnualSalary;

END EmployeeManagement;
/

-- Example
BEGIN
    EmployeeManagement.HireEmployee(201, 'Amit', 45000);
END;
/

BEGIN
    EmployeeManagement.UpdateEmployee(201, 'Amit Kumar', 50000);
END;
/

SELECT EmployeeManagement.CalculateAnnualSalary(201) AS Annual_Salary
FROM dual;