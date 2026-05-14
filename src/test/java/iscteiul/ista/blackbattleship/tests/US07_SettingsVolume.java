package iscteiul.ista.blackbattleship.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import iscteiul.ista.blackbattleship.pages.SettingsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class US07_SettingsVolume extends BaseTest {

    SettingsPage page = new SettingsPage();

    @Test
    void changeVolumeTest() {

        page.settingsButton.click();

        page.volumeSlider.shouldBe(Condition.visible);
        // obter valor inicial
        Long initialValue = executeJavaScript(
                "return arguments[0].value;",
                page.volumeSlider
        );

        // alterar slider
        executeJavaScript(
                "arguments[0].value = 80;" +
                        "arguments[0].dispatchEvent(new Event('input'));",
                page.volumeSlider
        );


        // obter novo valor
        Long newValue = executeJavaScript(
                "return arguments[0].value;",
                page.volumeSlider
        );

        // verificar mudança
        assertNotEquals(initialValue, newValue);
    }

}