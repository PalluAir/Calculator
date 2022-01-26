package com.trainingapps.forex.currencycalculator.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Calculator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(message = "Id cannot be Null")
    private Long id;

    @Column(name = "currency_from")
    @NotNull(message = "From cannot be Null")
    private CurrencyEnum from;

    @Column(name = "currency_to")
    @NotNull(message = "To cannot be Null")
    private CurrencyEnum to;

//    @NotNull(message = "Exchange Rate cannot be null")
    private double conversionMultiple;

    @NotNull(message = "Exchange Amount cannot be null")
    private double amountToBeConverted;

    private double totalCalculatedAmount;


    private double transactionFees;

    public Calculator(){

    }


    public Calculator(Long id, CurrencyEnum from, CurrencyEnum to, double conversionMultiple, double amountToBeConverted, double totalCalculatedAmount, double transactionFees) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.amountToBeConverted = amountToBeConverted;
        this.totalCalculatedAmount = totalCalculatedAmount;
        this.transactionFees = transactionFees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CurrencyEnum getFrom() {
        return from;
    }

    public void setFrom(CurrencyEnum from) {
        this.from = from;
    }

    public CurrencyEnum getTo() {
        return to;
    }

    public void setTo(CurrencyEnum to) {
        this.to = to;
    }

    public double getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(double conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public double getAmountToBeConverted() {
        return amountToBeConverted;
    }

    public void setAmountToBeConverted(double amountToBeConverted) {
        this.amountToBeConverted = amountToBeConverted;
    }

    public double getTotalCalculatedAmount() {
        return totalCalculatedAmount;
    }

    public void setTotalCalculatedAmount(double totalCalculatedAmount) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    public double getTransactionFees() {
        return transactionFees;
    }

    public void setTransactionFees(double transactionFees) {
        this.transactionFees = transactionFees;
    }
}
