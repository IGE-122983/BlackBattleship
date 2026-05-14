package iscteiul.ista.blackbattleship.tests;

import com.codeborne.selenide.Configuration;
import iscteiul.ista.blackbattleship.pages.HomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/**
 * Teste de aceitação para a US02 usando Selenide.
 * US02: Como utilizador, quero ter a opção de clicar em "Login / Sign Up".
 */
public class US02_LoginSignUpTest {

    HomePage homePage = new HomePage();

    @Test
    public void openLoginModalTest() {
        Configuration.timeout = 10000;

        // 1. Abrir a página do jogo
        open("https://papergames.io/en/battleship");

        // 2. Tratar do banner de cookies
        acceptCookiesIfPresent();

        // 3. Clicar no botão de Login / Sign Up
        homePage.btnLoginSignUp.shouldBe(interactable).click();

        // 4. Asserção (Validação)
        // O teste passa com sucesso se o campo para preencher o email/username ficar visível!
        homePage.inputEmail.shouldBe(visible);
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