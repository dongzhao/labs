package com.dzhao.exams.selenium.test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Home on 23/07/2015.
 */
public class FibonacciTest {
    private Selenium selenium;

    @BeforeClass
    public void startSelenium() {
        this.selenium = new DefaultSelenium("localhost", 4444, "*firefox",
                "http://localhost:38080/");
        this.selenium.start();
    }

    @Test
    public void testSequence() throws Exception {
        selenium.open("/selenium-test-web/");
        selenium.type("index", "10");
        selenium.click("//input[@value='Calculate']");
        selenium.waitForPageToLoad("30000");
        assert selenium.isTextPresent("55");
    }

    @AfterClass(alwaysRun = true)
    public void stopSelenium() {
        this.selenium.stop();
    }
}
