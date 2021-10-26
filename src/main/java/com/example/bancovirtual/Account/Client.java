package com.example.bancovirtual.Account;

import java.util.ArrayList;

public class Client extends BaseUser{
    private ArrayList<BaseAccount> accounts = new ArrayList<>();

    public Client(String username, String password,String number) {
        super(username,password, number, "Cliente");
    }

    public ArrayList<BaseAccount> getAccounts() {
        return accounts;
    }
}
