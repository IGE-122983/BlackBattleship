package iscteiul.ista.blackbattleship.tests;

import com.codeborne.selenide.Configuration;
import iscteiul.ista.blackbattleship.pages.HomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import com.codeborne.selenide.ClickOptions;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/**
 * Teste de aceitação para a US04 usando Selenide.
 * US04: Como utilizador, quero aceder à secção de regras para ler as instruções da Batalha Naval.
 */
public class US04_HowToPlayTest {

    HomePage homePage = new HomePage();

    @Test
    public void openGameGuidesTest() {
        // Garantir ecrã maximizado para o menu lateral não ficar escondido num menu hambúrguer
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;

        // 1. Abrir a página do jogo
        open("https://papergames.io/en/battleship");

        // 2. Tratar do banner de cookies
        acceptCookiesIfPresent();

        // 3. Clicar no botão "Game guides"
        homePage.btnGameGuides.shouldBe(exist).click(ClickOptions.usingJavaScript());

        // DICA TÁTICA: Como a página de documentação tem um design completamente diferente (parece um site à parte),
        // é muito provável que tenha aberto num novo separador do browser.
        // O Selenide precisa de saber que tem de "olhar" para a nova aba (índice 1) antes de fazer a asserção.
        try {
            switchTo().window(1);
        } catch (Exception e) {
            // Se não abriu num novo separador, ignora e continua no mesmo
        }

        // 4. Asserção (Validação)
        // O teste é um sucesso se a frase de boas-vindas da página de guias aparecer no ecrã!
        homePage.textoBoasVindasGuias.shouldBe(visible);
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