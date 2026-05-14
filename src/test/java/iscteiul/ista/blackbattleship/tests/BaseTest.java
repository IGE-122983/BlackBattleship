package iscteiul.ista.blackbattleship.tests;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
public class BaseTest {

    @BeforeEach
    public void setup() {
        open("https://papergames.io/en/battleship");
        acceptCookiesIfPresent();
    }
    @AfterEach
    public void tearDown() {
        // Mantém o browser aberto por uns segundos após o teste para veres o resultado final
        sleep(3000);
    }

    public void acceptCookiesIfPresent() {
        if ($(".qc-cmp2-summary-buttons").exists()) { // Seletor comum de cookies
            $(By.xpath("//button[contains(.,'Agree')]")).click();
        }
    }
}
