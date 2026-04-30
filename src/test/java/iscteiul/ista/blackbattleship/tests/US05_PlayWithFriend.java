package iscteiul.ista.blackbattleship.tests;

import com.codeborne.selenide.Configuration;
import iscteiul.ista.blackbattleship.pages.MatchSetupPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class US05_PlayWithFriend {
    MatchSetupPage page = new MatchSetupPage();
    @Test
    public void playWithFriendTest() {

        Configuration.timeout = 10000;

        open("https://papergames.io/en/battleship");

        acceptCookiesIfPresent();

        page.playWithFriend.shouldBe(visible)
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