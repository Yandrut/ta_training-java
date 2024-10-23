package com.epam.training.student_mykola_koltutskyi.task1;
import com.epam.training.student_mykola_koltutskyi.BaseTest;
import com.epam.training.student_mykola_koltutskyi.drivers.DriverProvider;
import com.epam.training.student_mykola_koltutskyi.pages.task1.CreatePastePage;
import com.epam.training.student_mykola_koltutskyi.pages.task1.PastePage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.Suite;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Suite
public class PasteTestSuite extends BaseTest {

    private static final String SERVICE_URL = "https://pastebin.com/";
    private static final String EXPECTED_PAGE_TITLE = "Pastebin.com - #1 paste tool since 2002!";
    public static final String CODE_SEQUENCE = "Hello from WebDriver";
    public static final String DROPDOWN_ELEMENT_NAME = "10 Minutes";
    public static final String PASTE_TITLE = "helloweb";

    private final CreatePastePage page = new CreatePastePage(DriverProvider.getInstance());
    private PastePage pastePage;
    @Test
    void allowsToNavigateToPastePage() {
        var actual = page.openPage(SERVICE_URL)
                .getPageTitle();
        assertEquals(EXPECTED_PAGE_TITLE, actual);
    }

    @Test
    void allowsToCreateNewPaste() {
        SoftAssertions softAssert = new SoftAssertions();

        String expirationTime = page.sendCodeSequence(CODE_SEQUENCE)
                .clickOnPageExpiration()
                .selectFromDropdownList(DROPDOWN_ELEMENT_NAME)
                .getExpirationTime();

        softAssert.assertThat(expirationTime).isEqualTo(DROPDOWN_ELEMENT_NAME);

                pastePage = page.setPasteTitle(PASTE_TITLE)
                .createNewPaste();

        softAssert.assertAll();
    }

    void pasteDataMatchesWithProvided() {
        SoftAssertions softAssert = new SoftAssertions();
        var actualCodeSequence = pastePage.getPasteCode();
        softAssert.assertThat(actualCodeSequence).isEqualTo(CODE_SEQUENCE);
        var actualPasteName = pastePage.getPasteTitle();
        softAssert.assertThat(actualPasteName).isEqualTo(PASTE_TITLE);
        softAssert.assertAll();
    }
}