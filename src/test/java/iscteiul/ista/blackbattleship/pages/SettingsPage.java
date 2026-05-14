package iscteiul.ista.blackbattleship.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SettingsPage {

    public SelenideElement settingsButton =
            $("button[mattooltip='Settings']");

    public SelenideElement volumeSlider =
            $("#settings-sound");

    public SelenideElement languageOption =
            $x("//*[contains(text(),'Language')]");
    public SelenideElement deutschOption = $(By.xpath("//*[contains(text(),'Deutsch')]"));
    public SelenideElement settingsTitle = $(".modal-title, .modal-header h5");
}