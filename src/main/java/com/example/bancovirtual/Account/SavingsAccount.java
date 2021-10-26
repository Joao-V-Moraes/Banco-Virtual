package com.example.bancovirtual.Account;


public class SavingsAccount extends BaseAccount {
    private float tax;
    public SavingsAccount(String number) {
        super(number,"Poupança");
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }
}
