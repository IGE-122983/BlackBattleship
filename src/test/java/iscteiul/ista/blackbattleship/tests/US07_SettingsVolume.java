package iscteiul.ista.blackbattleship.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import iscteiul.ista.blackbattleship.pages.SettingsPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class US07_SettingsVolume {

    SettingsPage page = new SettingsPage();

    @Test
    void changeVolumeTest() {

        open("https://papergames.io/en/battleship");
        acceptCookiesIfPresent();

        page.settingsButton.click();

        page.volumeSlider.shouldBe(Condition.visible);
    }
    private void acceptCookiesIfPresent() {
        try {
            $(By.xpath("//*[self::button or self::a][contains(.,'Consent')]"))
                    .shouldBe(visible)
                    .click();
        } catch (Exception e) {
            System.out.println("Cookie popup não apareceu ou já foi fechado.");
        }
    }
}