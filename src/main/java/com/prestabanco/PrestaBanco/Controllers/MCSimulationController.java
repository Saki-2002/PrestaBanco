package com.prestabanco.PrestaBanco.Controllers;

import com.prestabanco.PrestaBanco.Services.MCSimulationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/simulate")
@CrossOrigin("*")
public class MCSimulationController {

    @Autowired
    MCSimulationService mcSimulationService;

    @PostMapping("/")
    public ResponseEntity<Double> simulateMortgageCredit(@RequestBody Map<String, Object> requestData){
        int loanAmount = (Integer) requestData.get("loanAmount");
        double annualInterestRate = (Double) requestData.get("annualInterestRate");
        int loanTerm = (Integer) requestData.get("loanTerm");
        double result = mcSimulationService.simulateMortgageCredit(loanAmount,loanTerm,annualInterestRate);
        return ResponseEntity.ok(result);
    }

}
