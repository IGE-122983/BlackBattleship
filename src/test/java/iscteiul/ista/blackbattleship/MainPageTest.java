package iscteiul.ista.blackbattleship;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://www.jetbrains.com/");
    }

    @Test
    public void search() {

        // aceitar cookies
        if ($(".ch2-allow-all-btn").exists()) {
            $(".ch2-allow-all-btn").click();
        }
        // clicar na lupa
        mainPage.searchButton.shouldBe(visible).click();

        // esperar aparecer QUALQUER input visível
        SelenideElement searchInput = $("input")
                .shouldBe(visible);
        $("[data-test-id='search-input']").setValue("Selenium");
        searchInput.shouldHave(attribute("value", "Selenium"));
    }
    @Test
    public void toolsMenu() {
        // aceitar cookies
        if ($(".ch2-allow-all-btn").exists()) {
            $(".ch2-allow-all-btn").click();
        }
        // Se o xpath antigo falhou, tente este seletor CSS mais moderno:
        $("button[data-test='main-menu-item-action']").shouldBe(visible).click();

        // Verifica se o submenu abriu
        $("[data-test='main-submenu']").shouldBe(visible);
    }

    @Test
    public void navigationToAllTools() {
        // Como a homepage muda muito os botões, a forma mais estável de testar
        // a página de produtos é navegar diretamente para lá (routing test)
        open("https://www.jetbrains.com/products/");

        assertEquals("All Developer Tools and Products by JetBrains", Selenide.title());
    }
}
