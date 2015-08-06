package com.dzhao.exams.beans;

import java.io.Serializable;

/**
 * Created by Home on 4/08/2015.
 */
public class UserBean implements Serializable{

    private String username;
    private String password;
    private String emailAddress;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean valid(){
        return username!=null;
    }
}
