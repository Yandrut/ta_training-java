package com.epam.training.student_mykola_koltutskyi.drivers;

import org.openqa.selenium.WebDriver;
import com.epam.training.student_mykola_koltutskyi.drivers.managers.ChromeManager;
import com.epam.training.student_mykola_koltutskyi.drivers.managers.EdgeManager;
import com.epam.training.student_mykola_koltutskyi.drivers.managers.FirefoxManager;

public class DriverFactory {

    static WebDriver driver;

    private DriverFactory() {}

    private static final String browserType = System.getProperty("browser", "CHROME").toUpperCase();

    public static WebDriver getDriver() {
        switch (browserType) {
            case "CHROME":
                driver = ChromeManager.getDriver();
                break;
            case "FIREFOX":
                driver = FirefoxManager.getDriver();
                break;
            case "EDGE":
                driver = EdgeManager.getDriver();
                break;
            default:
                throw new RuntimeException("Invalid name of the browser");
        }
        return driver;
    }
}