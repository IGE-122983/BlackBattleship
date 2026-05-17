package loginSuite.pages;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class HomePage {

    public void openPage() {
        open("https://papergames.io/en/battleship");
    }
    public void clickLogin() {
        $x("//button[contains(., 'Login')]")
                .shouldBe(visible)
                .click(); }

}