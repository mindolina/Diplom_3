package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePage {

    private final By loginInAccountHeader = By.xpath(".//p[contains(text(),'Личный Кабинет')]");
    private final By loginInAccountCentral = By.xpath(".//button[contains(text(),'Войти в аккаунт')]");
    private final By textHead = By.xpath(".//h1[contains(text(),'Соберите бургер')]");
    private final By bun = By.xpath(".//span[contains(text(),'Булки')]");
    private final By sauce = By.xpath(".//span[contains(text(),'Соусы')]");
    private final By filling = By.xpath(".//span[contains(text(),'Начинки')]");
    private final By textSause = By.xpath(".//h2[text()='Соусы']");
    private final By textFilling = By.xpath(".//h2[text()='Начинки']");
    private final By textBun = By.xpath(".//h2[text()='Булки']");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }
    @Step ("Переход на сайт")
    public void open() {
        webDriver.get("https://stellarburgers.nomoreparties.site/");
    }
    @Step ("Нажать на кнопку Личный кабинет")
    public void clickLoginInAccountHeader() {
        webDriver.findElement(loginInAccountHeader).click();
    }
    @Step ("Нажать на кнопку Войти в аккаунт")
    public void clickLoginInAccountCentral() {
        webDriver.findElement(loginInAccountCentral).click();
    }
    @Step ("Проверить что отображается заголовок")
    public String getTextHead() {
        return webDriver.findElement(textHead).getText();}
    @Step ("Нажать на раздел Булки")
    public void clickBun() {
        webDriver.findElement(bun).click();
    }
    @Step ("Нажать на раздел Соусы")
    public void clickSauce() {
        webDriver.findElement(sauce).click();
    }
    @Step ("Нажать на раздел Начинки")
    public void clickFilling() {
        webDriver.findElement(filling).click();
    }
    @Step ("Отображаются Соусы")
    public String waitTextSause() {
        return webDriver.findElement(textSause).getText();}
    @Step ("Отображаются Начинки")
    public String waitTextFilling() {
        return webDriver.findElement(textFilling).getText();
    }
    @Step ("Отображаются Булки")
    public String waitTextBun() {
        return webDriver.findElement(textBun).getText();
    }
    @Step ("Ожидаем переход в раздел Соусы")
    public void waitSause() {
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.attributeToBe(By.xpath(".//span[contains(text(),'Соусы')]/parent::*"), "class", "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect"));
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.attributeToBe(By.xpath(".//span[contains(text(),'Булки')]/parent::*"), "class", "tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect"));
    }
    @Step ("Ожидаем переход в раздел Булки")
    public void waitBun() {
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.attributeToBe(By.xpath(".//span[contains(text(),'Булки')]/parent::*"), "class", "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect"));
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.attributeToBe(By.xpath(".//span[contains(text(),'Начинки')]/parent::*"), "class", "tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect"));
    }
    @Step ("Ожидаем переход в раздел Начинки")
    public void waitFilling() {
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.attributeToBe(By.xpath(".//span[contains(text(),'Начинки')]/parent::*"), "class", "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect"));
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.attributeToBe(By.xpath(".//span[contains(text(),'Соусы')]/parent::*"), "class", "tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect"));
    }
}
