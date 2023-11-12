package com.biblioteca.bean;

import java.util.ArrayList;

public abstract class User {
    private String name;
    private String password;
    private String ID;
    private boolean isPremium;

    ArrayList<ResourcesLibrary> loan = new ArrayList<ResourcesLibrary>();

    public User(String name, String password, String ID, ArrayList<ResourcesLibrary> loan, boolean isPremium) {
        this.name = name;
        this.password = password;
        this.ID = ID;
        this.loan = loan;
        this.isPremium = isPremium;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public ArrayList<ResourcesLibrary> getLoan() {
        return loan;
    }

    public void setLoan(ArrayList<ResourcesLibrary> loan) {
        this.loan = loan;
    }

    public abstract void borrow(ResourcesLibrary resource, int days, String deliveryBranch);

    public abstract void printLoanList();

    public abstract void login();

    public abstract void register();

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }
}
