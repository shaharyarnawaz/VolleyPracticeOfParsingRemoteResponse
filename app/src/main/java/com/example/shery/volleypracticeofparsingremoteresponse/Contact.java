package com.example.shery.volleypracticeofparsingremoteresponse;

/**
 * Created by SHERY on 10/4/2017.
 */

public class Contact {
    private String name;
    private String email;


    public Contact(String name,String email)
    {
        this.setName(name);
        this.setEmail(email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
