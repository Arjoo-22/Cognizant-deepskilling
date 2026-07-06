DECLARE

CURSOR UpdateLoanInterestRates IS

SELECT LoanID,
InterestRate
FROM Loans;

lid NUMBER;
rate NUMBER;

BEGIN

OPEN UpdateLoanInterestRates;

LOOP

FETCH UpdateLoanInterestRates
INTO lid,rate;

EXIT WHEN UpdateLoanInterestRates%NOTFOUND;

UPDATE Loans
SET InterestRate=rate+1
WHERE LoanID=lid;

END LOOP;

CLOSE UpdateLoanInterestRates;

COMMIT;

END;
/