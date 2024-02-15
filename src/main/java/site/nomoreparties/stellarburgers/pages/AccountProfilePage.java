package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountProfilePage extends BasePage {
    private final By accountText = By.xpath(".//p[contains(text(),'В этом разделе вы можете изменить свои персональные данные')]");
    private final By constructor = By.xpath(".//p[contains(text(),'Конструктор')]");
    private final By logo = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    private final By exit = By.xpath(".//button[contains(text(),'Выход')]");


    public AccountProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Проверяем текст личном кабинете")
    public String getAccountText() {
        return webDriver.findElement(accountText).getText();
    }
    @Step("Нажать на Конструктор")
    public void clickConstructor() {
        webDriver.findElement(constructor).click();
    }
    @Step("Нажать на логотип")
    public void clickLogo() {
        webDriver.findElement(logo).click();
    }
    @Step("Нажать на выход в Личном кабинете")
    public void clickExit() {
        webDriver.findElement(exit).click();
    }
}
