package com.dzhao.exams.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Home on 22/07/2015.
 */
public class SeleniumTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SeleniumTest.class);

    @Test(invocationCount = 1, threadPoolSize = 5)
    public void can_load_this_website(){

        LOGGER.debug("[START] Thread Id: {} is started!", Thread.currentThread().getId());
        String url = "http://www.seek.com.au/";
        WebDriver driver = null;
        final long start = System.currentTimeMillis();
        try{
            driver = (WebDriver)new FirefoxDriver();
            driver.get(url);
            final String title = driver.getTitle();
            LOGGER.debug("Page Title is {}", title);
            Assert.assertTrue(title.startsWith("SEEK"));
        }catch(final WebDriverException ex){
            LOGGER.warn("WebDriverException:{}",ex);
        }catch(final Exception ex){
            LOGGER.warn("Exception:{}",ex);
        }
        finally {
            final long elapsed = System.currentTimeMillis() - start;
            LOGGER.debug("[END] Thread Id: {}, elapsed={}", Thread.currentThread().getId(), elapsed);
            if (driver != null) {
                driver.quit();
            }
        }
    }

}
