package iscteiul.ista.blackbattleship.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
// US03: Link "See all" para abrir a Leaderboard completa
import static com.codeborne.selenide.Selectors.withText; // Garante que este import existe

import static com.codeborne.selenide.Selectors.withText;
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

    // O botão de Login/Sign Up
    public SelenideElement btnLoginSignUp = $$("button").findBy(text("Login"));

    // Novo elemento para a Asserção: procura especificamente por um campo de input de email ou texto
    public SelenideElement inputEmail = $(By.xpath("//input[@type='email' or contains(@placeholder, 'Email') or contains(@placeholder, 'Username')]"));
    public SelenideElement btnSeeAll = $(withText("See all"));

    // Asserção: Elemento exclusivo da página de Leaderboard/Torneio que mostra Vitórias/Derrotas/Empates
    public SelenideElement cabecalhoWLD = $(withText("W/L/D"));
    // US04: Botão "Game guides" no menu lateral
    public SelenideElement btnGameGuides = $(withText("Game guides"));

    // Asserção: Texto de boas-vindas exclusivo da página de guias
    public SelenideElement textoBoasVindasGuias = $(withText("Welcome to our game guide hub!"));
}