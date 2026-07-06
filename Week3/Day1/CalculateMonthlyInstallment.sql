CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    loanAmount NUMBER,
    interestRate NUMBER,
    years NUMBER
)
RETURN NUMBER
IS
    monthlyRate NUMBER;
    months NUMBER;
    emi NUMBER;
BEGIN
    monthlyRate := (interestRate/12/100);

    months := years*12;

    emi := loanAmount *
          (monthlyRate*POWER((1+monthlyRate),months))
          /(POWER((1+monthlyRate),months)-1);

    RETURN ROUND(emi,2);

END;
/