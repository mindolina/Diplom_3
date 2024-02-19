package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegisterPage extends BasePage {

    private final By name = By.xpath(".//fieldset[1]//input[contains(@class,'text')]");
    private final By email = By.xpath(".//fieldset[2]//input[contains(@class,'text')]");
    private final By password = By.xpath(".//fieldset[3]//input[contains(@class,'text')]");
    private final By reqisterLink = By.xpath(".//a[contains(text(),'Зарегистрироваться')]");
    private final By reqisterButton = By.xpath(".//button[contains(text(),'Зарегистрироваться')]");
    private final By errorPassword = By.xpath(".//p[contains(text(),'Некорректный пароль')]");
    private final By LoginInAccount = By.xpath(".//a[contains(text(),'Войти')]");


    public RegisterPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Step("Нажать на ссылку Зарегистрироваться")
    public void clickRegisterLink() {
        webDriver.findElement(reqisterLink).click();
    }

    @Step("Заполнить имя")
    public void setName(String userName) {
        webDriver.findElement(name).sendKeys(userName);
    }
    @Step("Заполнить емайл")
    public void setEmail(String userEmail) {
        webDriver.findElement(email).sendKeys(userEmail);
    }
    @Step("Заполнить пасспорт")
    public void setPassword(String userPassword) {
        webDriver.findElement(password).sendKeys(userPassword);
    }
    @Step("Нажать на кнопку Зарегистрироваться")
    public void clickRegisterButton() {
        webDriver.findElement(reqisterButton).click();}
    @Step("Ожидаем появления ссылки на Регистрацию")
    public void waitRegisterLink() {
        new WebDriverWait(webDriver, 3).until(ExpectedConditions.elementToBeClickable(reqisterLink));}
    @Step("Получаем текст ошибки при некорректом пароле")
    public String getTextError() {
        return webDriver.findElement(errorPassword).getText();
    }
    @Step("Переход к форме регистрации")
    public void open() {
        webDriver.get("https://stellarburgers.nomoreparties.site/register");
    }
    @Step("Нажать на Войти")
    public void clickLoginInAccount() {
        webDriver.findElement(LoginInAccount).click();
    }
}
