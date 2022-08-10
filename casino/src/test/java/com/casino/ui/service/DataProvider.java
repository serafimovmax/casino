package com.casino.ui.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataProvider {
    public static String getLoginData(String needed) {
        String data = null;
        try (InputStream loginData = new FileInputStream("src/test/resources/test.properties")) {
            Properties forLogin = new Properties();
            forLogin.load(loginData);
            data = forLogin.getProperty(needed);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return data;
    }
}
