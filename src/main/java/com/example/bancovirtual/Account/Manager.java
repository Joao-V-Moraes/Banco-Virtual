package com.example.bancovirtual.Account;

import java.util.ArrayList;

public  class Manager extends BaseUser{
    private ArrayList<BaseAccount> accounts = new ArrayList<>();

    public Manager(String username, String password,String number) {
        super(username,password, number, "Gerente");
    }


    public ArrayList<BaseAccount> getAccounts() {
        return accounts;
    }
}
