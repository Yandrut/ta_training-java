package com.epam.training.student_mykola_koltutskyi.drivers;
import org.openqa.selenium.WebDriver;


import java.time.Duration;
import java.util.Objects;

public class DriverProvider {
    private static WebDriver driver;

    private DriverProvider() {
    }

    public static WebDriver getInstance() {
        if (Objects.isNull(driver)) {
            driver = DriverFactory.getDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public static void quit() {
        if (Objects.nonNull(driver)) {
            driver.quit();
            driver = null;
        }
    }
}