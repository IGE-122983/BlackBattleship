package iscteiul.ista.blackbattleship.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class BattleShipPage {

    private final SelenideElement playVsBotButton =
            $x("//button[contains(.,'Bot') or contains(.,'Computer') or contains(.,'Play')] " +
                    "| //a[contains(.,'Bot') or contains(.,'Computer') or contains(.,'Play')]");

    private final SelenideElement randomizeButton =
            $x("//button[contains(.,'Randomize') or contains(.,'Random')] " +
                    "| //a[contains(.,'Randomize') or contains(.,'Random')]");

    private final SelenideElement readyButton =
            $x("//button[contains(.,'Ready')] | //a[contains(.,'Ready')]");

    private final ElementsCollection gameArea =
            $$("canvas, [class*='board'], [class*='grid'], [class*='cell'], [class*='square'], [class*='tile'], [class*='game']");

    private final SelenideElement turnTimer =
            $("[class*='timer']");

    private final SelenideElement leaveButton =
            $x("//button[contains(.,'Leave') or contains(.,'Surrender')] " +
                    "| //a[contains(.,'Leave') or contains(.,'Surrender')]");

    private final SelenideElement rematchButton =
            $x("//button[contains(.,'Rematch')] | //a[contains(.,'Rematch')]");

    public void openPage() {
        open("https://papergames.io/en/battleship");
    }

    public void startBotGame() {
        playVsBotButton.shouldBe(visible).click();

        sleep(2000);

        if (randomizeButton.exists() && randomizeButton.isDisplayed()) {
            randomizeButton.click();
        }

        sleep(1000);

        if (readyButton.exists() && readyButton.isDisplayed()) {
            readyButton.click();
        }

        sleep(3000);
    }

    public void shootFirstOpponentCell() {
        gameArea
                .filterBy(visible)
                .first()
                .shouldBe(visible)
                .click();
    }

    public void verifyFirstOpponentCellWasShot() {
        gameArea
                .filterBy(visible)
                .first()
                .shouldBe(visible);
    }

    public void verifyTimerVisible() {
        gameArea
                .filterBy(visible)
                .first()
                .shouldBe(visible);
    }

    public void surrenderGame() {
        leaveButton.shouldBe(visible).click();
    }

    public void verifyGameEnded() {
        $x("//*[contains(.,'Defeat') or contains(.,'Game Over')]")
                .shouldBe(visible);
    }

    public void requestRematch() {
        rematchButton.shouldBe(visible).click();
    }

    public void verifyWaitingForRematch() {
        $x("//*[contains(.,'Waiting')]")
                .shouldBe(visible);
    }
}