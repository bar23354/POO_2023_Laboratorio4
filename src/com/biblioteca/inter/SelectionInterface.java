package com.biblioteca.inter;

import com.biblioteca.bean.User;

public interface SelectionInterface {


    void addResource(String typeResource);

    void clearResource();

    void loanMode(User user);

}
