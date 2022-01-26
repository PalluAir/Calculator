package com.trainingapps.forex.currencycalculator.exception;

import com.trainingapps.forex.currencycalculator.entity.CurrencyEnum;

public class CurrencyNotAvailableException extends RuntimeException {
    public CurrencyNotAvailableException(String s) {
    }

    public CurrencyEnum toCurrencyEnum(String currencyText) throws CurrencyNotAvailableException {
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
