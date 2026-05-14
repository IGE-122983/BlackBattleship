package iscteiul.ista.blackbattleship.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MatchSetupPage {

    public SelenideElement playWithFriend =
            $(By.xpath("//*[contains(text(),'Play with a friend')]"));

    public SelenideElement playVsBot =
            $(By.xpath("//*[contains(text(),'Play vs robot')]"));
}