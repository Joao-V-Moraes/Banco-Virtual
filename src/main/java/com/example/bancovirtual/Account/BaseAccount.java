package com.example.bancovirtual.Account;

public abstract class BaseAccount {
    private String number;
    private float balance;
    private final String accountType;

    protected BaseAccount(String number, String accountType) {
        this.number = number;
        this.accountType = accountType;
    }

    public String getNumber() {
        return number;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }
}
