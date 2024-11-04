package com.prestabanco.PrestaBanco.Services;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

@Service
public class MCSimulationService {

    public double simulateMortgageCredit(int loanAmount, int loanTerm, double annualInterestRate){

        double r = (annualInterestRate/12)/100;
        int n = loanTerm*12;
        double aux=Math.pow((1+r),n);
        double M = (loanAmount*((r*aux)/(aux-1)));

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#.##", symbols);
        return Double.parseDouble(df.format(M));
    }

}
