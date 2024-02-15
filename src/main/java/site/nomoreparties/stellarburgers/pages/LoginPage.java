package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

    private final By email = By.xpath(".//fieldset[1]//input[contains(@class,'text')]");
    private final By password = By.xpath(".//fieldset[2]//input[contains(@class,'text')]");
    private final By login = By.xpath(".//button[contains(text(),'Войти')]");
    private final By createOrder = By.xpath(".//button[contains(text(),'Оформить заказ')]");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Step("Заполнить емайл")
    public void setEmail(String userEmail) {
        webDriver.findElement(email).sendKeys(userEmail);
    }
    @Step("Заполнить паспорт")
    public void setPassord(String passord) {
        webDriver.findElement(password).sendKeys(passord);
    }
    @Step("Нажать на кнопку Войти")
    public void clickLogin() {
        webDriver.findElement(login).click();}
    @Step("Проверили что появилась кнопка Оформить заказ")
    public String getTextButton() {
        return webDriver.findElement(createOrder).getText();
    }
    @Step("Проверили что появилась кнопка Войти")
    public String getTextButtonLogin() {
        return webDriver.findElement(login).getText();
    }
}
