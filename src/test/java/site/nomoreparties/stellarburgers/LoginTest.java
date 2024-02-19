package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.driver.WebDriverFactory;
import site.nomoreparties.stellarburgers.pages.ForgotPasswordPage;
import site.nomoreparties.stellarburgers.pages.HomePage;
import site.nomoreparties.stellarburgers.pages.LoginPage;
import site.nomoreparties.stellarburgers.pages.RegisterPage;
import site.nomoreparties.stellarburgers.user.create.CreateUser;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    protected WebDriver webDriver;
    CreateUser createUser;


    @Before
    public void setUp() {
        webDriver = new WebDriverFactory().getWebDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        createUser=new CreateUser();
        createUser.createUser();

    }

    @Test
    @DisplayName("Вход через кнопку Личный кабинет")
    public void loginInAccountHeader() {
        HomePage homePage = new HomePage(webDriver);
        homePage.open();
        homePage.clickLoginInAccountHeader();
       LoginPage loginPage=new LoginPage(webDriver);
       loginPage.setEmail(createUser.getEmail());
       loginPage.setPassord(createUser.getPassword());
       loginPage.clickLogin();
       Assert.assertEquals("Оформить заказ",loginPage.getTextButton());
    }

    @Test
    @DisplayName("Вход по кнопке Войти в аккаунт на главной")
    public void loginInAccountCentral(){
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        HomePage homePage=new HomePage(webDriver);
        homePage.open();
        homePage.clickLoginInAccountCentral();
        LoginPage loginPage=new LoginPage(webDriver);
        loginPage.setEmail(createUser.getEmail());
        loginPage.setPassord(createUser.getPassword());
        loginPage.clickLogin();
        Assert.assertEquals("Оформить заказ",loginPage.getTextButton());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginInAccountInRegisterPage(){
        RegisterPage registerPage=new RegisterPage(webDriver);
        registerPage.open();
        registerPage.clickLoginInAccount();
        LoginPage loginPage=new LoginPage(webDriver);
        loginPage.setEmail(createUser.getEmail());
        loginPage.setPassord(createUser.getPassword());
        loginPage.clickLogin();
        Assert.assertEquals("Оформить заказ",loginPage.getTextButton());

    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginInAccountInForgotPage(){
        ForgotPasswordPage forgotPasswordPage=new ForgotPasswordPage(webDriver);
        forgotPasswordPage.open();
        forgotPasswordPage.clickLoginInAccount();
        LoginPage loginPage=new LoginPage(webDriver);
        loginPage.setEmail(createUser.getEmail());
        loginPage.setPassord(createUser.getPassword());
        loginPage.clickLogin();
        Assert.assertEquals("Оформить заказ",loginPage.getTextButton());
    }

    @After
    public void teardown() {
        webDriver.quit();
        createUser.deleteUser();
    }
}
