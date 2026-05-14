package iscteiul.ista.blackbattleship.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import iscteiul.ista.blackbattleship.pages.SettingsPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class US08_Language extends BaseTest {

    SettingsPage page = new SettingsPage();

    @Test
    void changeLanguageTest() {

        page.settingsButton.click();

        page.languageOption.shouldBe(Condition.visible).click();
        page.deutschOption.shouldBe(Condition.visible).click();

        $("body").shouldHave(Condition.text("Spiel"), java.time.Duration.ofSeconds(10));
    }
}