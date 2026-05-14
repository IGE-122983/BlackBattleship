package iscteiul.ista.blackbattleship.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import iscteiul.ista.blackbattleship.pages.MatchSetupPage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class US06_PlayVSBot {

    MatchSetupPage page = new MatchSetupPage();

    @Test
    void playVsBot() {

        Configuration.browserSize = "1920x1080";

        open("https://papergames.io/en/battleship");
        acceptCookiesIfPresent();
        page.playVsBot
                .shouldBe(Condition.visible)
                .click();
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