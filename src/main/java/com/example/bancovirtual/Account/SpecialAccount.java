package com.example.bancovirtual.Account;

public class SpecialAccount extends BaseAccount{
    private float limit;

    public SpecialAccount(String number) {
        super(number,"Especial");
    }
}
