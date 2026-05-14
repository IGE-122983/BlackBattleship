package iscteiul.ista.blackbattleship.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import iscteiul.ista.blackbattleship.pages.SettingsPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class US07_SettingsVolume extends BaseTest {

    SettingsPage page = new SettingsPage();

    @Test
    void changeVolumeTest() {

        page.settingsButton.click();

        page.volumeSlider.shouldBe(Condition.visible);
    }

}