package iscteiul.ista.blackbattleship.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import iscteiul.ista.blackbattleship.pages.SettingsPage;

public class US08_Language extends BaseTest {

    SettingsPage page = new SettingsPage();

    @Test
    void changeLanguageTest() {

        page.settingsButton.click();

        page.languageOption.shouldBe(Condition.visible).click();
    }
}