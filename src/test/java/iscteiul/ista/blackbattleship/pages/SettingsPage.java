package iscteiul.ista.blackbattleship.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SettingsPage {

    public SelenideElement settingsButton =
            $("button[mattooltip='Settings']");

    public SelenideElement volumeSlider =
            $("#settings-sound");

    public SelenideElement languageOption =
            $x("//*[contains(text(),'Language')]");
}