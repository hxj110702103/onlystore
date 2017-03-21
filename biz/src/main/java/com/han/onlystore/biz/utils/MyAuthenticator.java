package com.han.onlystore.biz.utils;

import javax.mail.Authenticator;

/**
 * Created by Amy on 2017/3/20.
 */
public class MyAuthenticator extends Authenticator {
    private String userName;

    private String password;

    public MyAuthenticator(String password, String userName) {
        this.password = password;
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
