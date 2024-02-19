package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.driver.WebDriverFactory;
import site.nomoreparties.stellarburgers.pages.HomePage;
import site.nomoreparties.stellarburgers.pages.RegisterPage;
import site.nomoreparties.stellarburgers.user.create.CreateUser;

import java.util.concurrent.TimeUnit;

public class RegisterTest {

    protected WebDriver webDriver;
    CreateUser createUser;



    @Before
    public void setUp() {
        webDriver = new WebDriverFactory().getWebDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        createUser=new CreateUser();
    }


    @Test
    @DisplayName("Успешная регистрация")
    public void registerShouldBeCompleted() {

        HomePage homePage = new HomePage(webDriver);
        homePage.open();
        homePage.clickLoginInAccountHeader();
        RegisterPage registerPage = new RegisterPage(webDriver);
        registerPage.clickRegisterLink();
        registerPage.setName(createUser.getName());
        registerPage.setEmail(createUser.getEmail());
        registerPage.setPassword(createUser.getPassword());
        registerPage.clickRegisterButton();
        registerPage.waitRegisterLink();
        Assert.assertEquals("переход на страницу для входа", "https://stellarburgers.nomoreparties.site/login", webDriver.getCurrentUrl());
        createUser.deleteUser();
    }

    @Test
    @DisplayName("Нельзя зарегестироваться, если пароль меньше 6 символов")
    public void registerNotShouldBeCompleted() {

        HomePage homePage = new HomePage(webDriver);
        homePage.open();
        homePage.clickLoginInAccountHeader();
        RegisterPage registerPage = new RegisterPage(webDriver);
        registerPage.clickRegisterLink();
        registerPage.setName(createUser.getName());
        registerPage.setEmail(createUser.getEmail());
        registerPage.setPassword("12345");
        registerPage.clickRegisterButton();
        Assert.assertEquals("должны остаться на странице регистрации", "https://stellarburgers.nomoreparties.site/register", webDriver.getCurrentUrl());
        Assert.assertEquals("должна быть ошибка", "Некорректный пароль", registerPage.getTextError());
    }


    @After
    public void teardown() {
        webDriver.quit();

    }
}
