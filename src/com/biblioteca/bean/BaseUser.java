package com.biblioteca.bean;

import java.util.ArrayList;

public class BaseUser extends User {

    public BaseUser(String name, String password, String ID, ArrayList<ResourcesLibrary> loan) {
        super(name, password, ID, loan, false);
    }

    @Override
    public void login() {

    }

    @Override
    public void register() {

    }

    //Rojo grrrr >;(
    @Override
    public void borrow(ResourcesLibrary resource, int days, String deliveryBranch) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrow'");
    }

    @Override
    public void printLoanList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printLoanList'");
    }
}
