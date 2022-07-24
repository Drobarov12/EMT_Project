package com.example.hotel.domain.valuesOf;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Money {

    @Enumerated(value = EnumType.STRING)
    private final MoneyCurrency currency;

    private final double value;

    protected Money()
    {
        currency = MoneyCurrency.EUR;
        value = 0;
    }

    public Money(MoneyCurrency currency, double value) {
        this.currency = currency;
        this.value = value;
    }

    public Money Add(MoneyCurrency moneyCurrency,double value){
        if(this.currency == moneyCurrency){
            return new Money(currency,this.value+value);
        }
        else{
            throw new IllegalArgumentException("You can Add two different currencies!");
        }
    }

    public Money SubtractPercentage(double percentage)
    {
        return new Money(this.currency,this.value*(percentage/100));
    }

}
