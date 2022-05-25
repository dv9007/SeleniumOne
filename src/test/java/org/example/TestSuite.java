package org.example;

public class TestSuite {

    protected static TestSuit driver;

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");

    }
}
