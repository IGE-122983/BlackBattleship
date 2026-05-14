package iscteiul.ista.blackbattleship.tests;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
public class BaseTest {

    @BeforeEach
    public void setup() {
        open("https://papergames.io/en/battleship");
        acceptCookiesIfPresent();
    }

    private void acceptCookiesIfPresent() {
        var cookieButton = $(By.xpath("//*[self::button or self::a][contains(.,'Consent')]"));
        if (cookieButton.exists()) {
            cookieButton.click();
        }
    }
}
