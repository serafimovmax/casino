package com.epam.tc.hw2;

public enum Constants {
    HOME_PAGE("https://jdi-testing.github.io/jdi-light/index.html"),
    TITLE_HOME_PAGE("Home Page"),
    LOGIN("Roman"),
    PASSWORD("Jdi1234"),
    USER_NAME("ROMAN IOVLEV"),
    BUTTON_HOME("Home"),
    BUTTON_CONTACT_FORM("Contact form"),
    BUTTON_SERVICE("Service"),
    BUTTON_METALS_COLORS("Metals & Colors"),
    BUTTON_ELEMENTS_PACK("Elements packs");

    String constant;

    Constants(String constant) {
        this.constant = constant;
    }

    public String get() {
        return constant;
    }
}
