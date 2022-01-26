package com.trainingapps.forex.currencycalculator.utility;

import com.trainingapps.forex.currencycalculator.dto.ExchangeValueResponse;
import com.trainingapps.forex.currencycalculator.entity.CurrencyEnum;
import com.trainingapps.forex.currencycalculator.exception.CurrencyNotAvailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CalculatorUtility {

    @Autowired
    private RestTemplate restTemplate;


    public ExchangeValueResponse retrieveExchangeValue(String from, String to){
        try {
            toCurrencyEnum(from);
            toCurrencyEnum(to);
        }catch(CurrencyNotAvailableException e) {
            throw new CurrencyNotAvailableException("Currency is Invalid / Not Available");
        }
        String url = "http://localhost:8080/exchangerate/currency-exchange/from/"+from+"/to/"+to;
        ExchangeValueResponse exchangeValueResponse = restTemplate.getForObject(url, ExchangeValueResponse.class);
        return exchangeValueResponse;
    }

    public CurrencyEnum toCurrencyEnum(String currencyText) {
        CurrencyEnum[] values = CurrencyEnum.values();
        for (CurrencyEnum type : values) {
            String currencytype = type.name();
            if (currencytype.equalsIgnoreCase(currencyText)) {
                return type;
            }
        }
        throw new CurrencyNotAvailableException("Conversion to '"+currencyText + "' is Invalid / Not Available");

    }
}
