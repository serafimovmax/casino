package com.epam.tc.hw2;

public enum Constants {
    HOME_PAGE("https://jdi-testing.github.io/jdi-light/index.html"),
    TITLE_HOME_PAGE("Home Page"),
    LOGIN("Roman"),
    PASSWORD("Jdi1234"),
    USER_NAME("ROMAN IOVLEV");

    String constant;

    Constants(String constant) {
        this.constant = constant;
    }

    public String get() {
        return constant;
    }
}
