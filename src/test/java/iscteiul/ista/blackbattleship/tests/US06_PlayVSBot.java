package iscteiul.ista.blackbattleship.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import iscteiul.ista.blackbattleship.pages.MatchSetupPage;

public class US06_PlayVSBot extends BaseTest{

    MatchSetupPage page = new MatchSetupPage();

    @Test
    void playVsBot() {

        Configuration.browserSize = "1920x1080";

        page.playVsBot
                .shouldBe(Condition.visible)
                .click();
    }


}