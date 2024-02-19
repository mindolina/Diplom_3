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
    String activeTab="tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";


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

    @Step ("Ожидаем переход в раздел Соусы")
    public boolean waitSause() {
        return new WebDriverWait(webDriver, 5).until(ExpectedConditions.attributeToBe(By.xpath(".//span[contains(text(),'Соусы')]/parent::*"), "class", activeTab));
    }
    @Step ("Ожидаем переход в раздел Начинки")
    public boolean waitFilling() {
        return new WebDriverWait(webDriver, 5).until(ExpectedConditions.attributeToBe(By.xpath(".//span[contains(text(),'Начинки')]/parent::*"), "class", activeTab));
    }
    @Step ("Ожидаем переход в раздел Булки")
    public boolean waitBun() {
        return new WebDriverWait(webDriver, 5).until(ExpectedConditions.attributeToBe(By.xpath(".//span[contains(text(),'Булки')]/parent::*"), "class", activeTab));
    }
}
