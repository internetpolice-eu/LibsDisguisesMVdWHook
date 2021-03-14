package com.cdejong.config;

public interface Config {

    String getTrueAsText();

    String getFalseAsText();

    String getNotDisguisedValue();

    void loadConfig();

}
