package iscteiul.ista.blackbattleship.tests;

import iscteiul.ista.blackbattleship.pages.HomePage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;

public class US05_PlayWithFriend extends BaseTest {
    HomePage page = new HomePage();
    @Test
    public void playWithFriendTest() {

        page.playWithFriend.shouldBe(visible)
                .click();

        // Limpar e preencher o campo do nickname
        page.inputNickname.shouldBe(visible).setValue("OdivelasPlayer");

        // Clicar em continuar
        page.btnContinue.shouldBe(visible).click();

        // 4. Asserção (Validação)
        // Para validar que o teste foi um sucesso, podemos verificar se o botão "Continue" desapareceu
        // ou se fomos redirecionados para o ecrã seguinte.
        page.btnContinue.shouldNotBe(visible);
    }
}