package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ForgotPasswordPage extends BasePage {

    private final By loginInAccount = By.xpath(".//a[contains(text(),'Войти')]");

    public ForgotPasswordPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Step("Перешли в форму восстановления пароля")
    public void open() {
        webDriver.get("https://stellarburgers.nomoreparties.site/forgot-password");
    }
    @Step("Нажать на кнопку Войти")
    public void clickLoginInAccount() {
        webDriver.findElement(loginInAccount).click();
    }
}
