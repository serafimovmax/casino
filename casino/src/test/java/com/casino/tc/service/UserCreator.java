package com.casino.tc.service;

import com.casino.tc.model.User;

public class UserCreator {
    public static final String USER_LOGIN = DataProvider.getLoginData("userLogin");
    public static final String USER_PASSWORD = DataProvider.getLoginData("userPassword");

    public static User withCredentialsFromProperty() {
        return new User(USER_LOGIN, USER_PASSWORD);
    }

    public static User withEmptyLogin() {
        return new User("", USER_PASSWORD);
    }

    public static User withEmptyPassword() {
        return new User(USER_LOGIN, "");
    }


}
