package iscteiul.ista.blackbattleship.tests;

import com.codeborne.selenide.Configuration;
import iscteiul.ista.blackbattleship.pages.HomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import com.codeborne.selenide.ClickOptions;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/**
 * Teste de aceitação para a US03 usando Selenide.
 * US03: Como utilizador, quero ter um botão "Leaderboard" (See all) para poder visualizar o ranking.
 */
public class US03_LeaderboardTest {

    HomePage homePage = new HomePage();

    @Test
    public void openLeaderboardTest() {
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080"; // Garante que a barra lateral está bem visível
        // 1. Abrir a página do jogo
        open("https://papergames.io/en/battleship");

        // 2. Tratar do banner de cookies
        acceptCookiesIfPresent();

        // 3. Clicar no link "See all" usando JavaScript para contornar anúncios que apareçam por cima
        homePage.btnSeeAll.scrollIntoView(true).click(ClickOptions.usingJavaScript());

        // 4. Asserção (Validação)
        // O teste é um sucesso se o cabeçalho das estatísticas (W/L/D) ficar visível
        homePage.cabecalhoWLD.shouldBe(visible);
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