package iscteiul.ista.blackbattleship.tests;

import com.codeborne.selenide.Configuration;
import iscteiul.ista.blackbattleship.pages.BattleShipPage;
import org.junit.jupiter.api.*;

public class US14_CheckTimer {

    BattleShipPage page = new BattleShipPage();

    @BeforeAll
    static void setup() {
        Configuration.browserSize = "1280x800";
        Configuration.timeout = 10000;
    }

    @BeforeEach
    void openGame() {
        page.openPage();
        page.startBotGame();
    }

    @Test
    void checkTimer() {
        page.verifyTimerVisible();
    }
}