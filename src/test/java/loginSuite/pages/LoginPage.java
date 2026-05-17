package loginSuite.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    public void fillEmail(String email) {
        $x("//input[@type='email']")
                .shouldBe(visible)
                .setValue(email);
    }
    public void fillPassword(String password) {
        $x("//input[@type='password']")
                .shouldBe(visible)
                .setValue(password);
    }

    public void submitLogin() {
        $x("//button[@type='submit']")
                .shouldBe(com.codeborne.selenide.Condition.visible)
                .click();
    }
    public void login(String email, String password) {
        fillEmail(email);
        fillPassword(password);
        submitLogin();
}}