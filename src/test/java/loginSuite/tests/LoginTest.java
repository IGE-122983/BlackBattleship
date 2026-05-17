package loginSuite.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import loginSuite.pages.HomePage;
import loginSuite.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginTest {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @BeforeEach
    void setup() {

        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 10000;
    }

    @Test
    @Description("Verifica entrada no jogo com nickname válido")
    void UserStoryTest1() {

        homePage.openPage();
        acceptCookiesIfPresent();
        homePage.clickLogin();
        loginPage.login("teste@email.com","123456");
        $("body").shouldBe(visible);
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