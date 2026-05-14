package iscteiul.ista.blackbattleship.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import iscteiul.ista.blackbattleship.pages.HomePage;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.visible;


public class US06_PlayVSBot extends BaseTest{

    HomePage page = new HomePage();

    @Test
    void playVsBot() {

        Configuration.browserSize = "1920x1080";

        page.playVsBot
                .shouldBe(Condition.visible)
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