package com.epam.tc.hw3.service;

import com.epam.tc.hw3.Constants;
import com.epam.tc.hw3.model.User;

public class UserCreator {
    public static final String LOGIN = Constants.LOGIN.get();
    public static final String USER_PASSWORD = Constants.PASSWORD.get();

    public static User withCredentialsFromProperty() {
        return new User(LOGIN, USER_PASSWORD);
    }



}
