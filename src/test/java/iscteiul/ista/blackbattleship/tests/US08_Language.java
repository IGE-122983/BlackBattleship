package iscteiul.ista.blackbattleship.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import iscteiul.ista.blackbattleship.pages.SettingsPage;

import static com.codeborne.selenide.Selenide.open;

public class US08_Language {

    SettingsPage page = new SettingsPage();

    @Test
    void changeLanguageTest() {

        open("https://papergames.io/en/battleship");

        page.settingsButton.click();

        page.languageOption.shouldBe(Condition.visible).click();
    }
}