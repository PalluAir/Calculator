package com.trainingapps.forex.currencycalculator.controller;

import com.trainingapps.forex.currencycalculator.entity.Calculator;
import com.trainingapps.forex.currencycalculator.service.CalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/calculator")
@Slf4j
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;


    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @GetMapping("/calculate/from/{from}/to/{to}/amount/{amount}")
    public Calculator calculate(@PathVariable String from, @PathVariable String to, @PathVariable double amount) {
        log.info("Inside calculate method of CalculatorController");
        return calculatorService.calculate(from, to, amount);
    }

//    @GetMapping("/{id}")
//    public ResponseTemplateVO getRatesToCalculate(@PathVariable("id") Long calculatorId){
//        log.info("Inside getRatesToCalculate method of CalculatorController");
//        return calculatorService.getRatesToCalculate(calculatorId);
//
//    }

}
