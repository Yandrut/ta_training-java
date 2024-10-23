package com.epam.training.student_mykola_koltutskyi;

import com.epam.training.student_mykola_koltutskyi.drivers.DriverProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    @BeforeAll
    static void openBrowser() {
        WebDriver driver = DriverProvider.getInstance();
    }

    @AfterAll()
    static void quitBrowser() {
        DriverProvider.quit();
    }
}