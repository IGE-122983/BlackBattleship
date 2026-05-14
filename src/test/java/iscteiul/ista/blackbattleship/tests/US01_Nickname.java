package iscteiul.ista.blackbattleship.tests;

import com.codeborne.selenide.Configuration;
import iscteiul.ista.blackbattleship.pages.HomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/**
 * Teste de aceitação para a US01 usando Selenide.
 * US01: Como utilizador, quero poder introduzir um "Nickname" na página inicial.
 */
public class US01_Nickname {

    // Instanciação da Page Object Class
    HomePage homePage = new HomePage();

    @Test
    public void insertNicknameTest() {
        // Define o tempo máximo de espera (timeout) global para 10 segundos
        Configuration.timeout = 10000;

        // 1. Abrir a página do jogo
        open("https://papergames.io/en/battleship");

        // 2. Tratar do banner de cookies
        acceptCookiesIfPresent();

        // 3. Executar os passos descritos na US01
        // Clicar no botão para jogar online (esperando que esteja visível)
        // Em vez de .shouldBe(visible), usamos interactable para garantir que nada está a tapar o botão
        homePage.btnPlayOnline.shouldBe(interactable).click();

        // Limpar e preencher o campo do nickname
        homePage.inputNickname.shouldBe(visible).setValue("OdivelasPlayer");

        // Clicar em continuar
        homePage.btnContinue.shouldBe(visible).click();

        // 4. Asserção (Validação)
        // Para validar que o teste foi um sucesso, podemos verificar se o botão "Continue" desapareceu
        // ou se fomos redirecionados para o ecrã seguinte.
        homePage.btnContinue.shouldNotBe(visible);
    }

    /**
     * Método auxiliar para lidar com o pop-up de cookies usando o seletor partilhado.
     */
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