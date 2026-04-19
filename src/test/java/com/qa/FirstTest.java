package com.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void openSettingsTest() {
        By settingsTitle = By.xpath("//*[@text='Settings']");
        Assert.assertTrue(isElementDisplayed(settingsTitle), "Settings screen did not open.");
    }
}
