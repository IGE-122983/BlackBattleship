package iscteiul.ista.blackbattleship.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selenide.$;

/**
 * Page Object Class para a página principal (Home Page).
 * Centraliza os elementos web para as US01 a US04.
 */
public class HomePage {

    // US01: Elementos para configurar o Nickname
    // O uso de 'contains(., ...)' permite procurar o texto mesmo que esteja escondido num span lá dentro
    // O withText procura o texto em qualquer parte do botão e ignora diferenças de espaços
    // O "$$" procura todos os botões da página, e o "findBy" filtra para encontrar o que tem o texto certo.
    // Assim garantimos que o clique é feito no botão (elemento interativo) e não no span (texto).
    public SelenideElement btnPlayOnline = $$("button").findBy(text("Play online"));
    public SelenideElement inputNickname = $(By.xpath("//input[@type='text' or contains(@placeholder, 'nickname')]"));
    public SelenideElement btnContinue = $(By.xpath("//button[contains(text(),'Continue')]"));

    // US02: Elementos de Login/Sign Up
    public SelenideElement btnLoginSignUp = $(By.xpath("//*[contains(text(),'Login') or contains(text(),'Sign Up')]"));

    // US03: Elemento da Leaderboard
    public SelenideElement btnLeaderboard = $(By.xpath("//*[contains(text(),'Leaderboard')]"));

    // US04: Elemento das regras do jogo (How to Play)
    public SelenideElement btnHowToPlay = $(By.xpath("//*[contains(text(),'How to Play') or contains(text(),'Rules')]"));

    // US05
    public SelenideElement playWithFriend =
            $(By.xpath("//*[contains(text(),'Play with a friend')]"));
    // US06
    public SelenideElement playVsBot =
            $(By.xpath("//*[contains(text(),'Play vs robot')]"));

}