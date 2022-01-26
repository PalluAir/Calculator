package com.trainingapps.forex.currencycalculator.service;


import com.trainingapps.forex.currencycalculator.dto.ExchangeValueResponse;
import com.trainingapps.forex.currencycalculator.entity.Calculator;
import com.trainingapps.forex.currencycalculator.repository.CalculatorRepository;
import com.trainingapps.forex.currencycalculator.utility.CalculatorUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    @Autowired
    private CalculatorUtility calculatorUtility;

    @Autowired
    private CalculatorRepository calculatorRepository;

    public Calculator calculate(String from, String to,double amount) {
        ExchangeValueResponse exchangeValueResponse = calculatorUtility.retrieveExchangeValue(from, to);
        double rate = exchangeValueResponse.getConversionMultiple();
        double fees = amount * rate * 0.002;

        double total = (amount * rate) - fees ;
        Calculator calculator = new Calculator();
        calculator.setConversionMultiple(rate);
        calculator.setTransactionFees(fees);
        calculator.setAmountToBeConverted(amount);
        calculator.setFrom(calculatorUtility.toCurrencyEnum(from));
        calculator.setTo(calculatorUtility.toCurrencyEnum(to));
        calculator.setTotalCalculatedAmount(total);
        calculatorRepository.save(calculator);
        return calculator;
    }


//    public ResponseTemplateVO getRatesToCalculate(Long calculatorId) {
//        return calculatorRepository.findByCalculatorId(calculatorId);
//    }



}
