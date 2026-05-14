package iscteiul.ista.blackbattleship.tests;

import com.codeborne.selenide.Configuration;
import iscteiul.ista.blackbattleship.pages.MatchSetupPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class US05_PlayWithFriend extends BaseTest {
    MatchSetupPage page = new MatchSetupPage();
    @Test
    public void playWithFriendTest() {

        page.playWithFriend.shouldBe(visible)
                .click();
    }
}