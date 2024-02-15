package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.driver.WebDriverFactory;
import site.nomoreparties.stellarburgers.pages.AccountProfilePage;
import site.nomoreparties.stellarburgers.pages.HomePage;
import site.nomoreparties.stellarburgers.pages.LoginPage;
import site.nomoreparties.stellarburgers.user.create.CreateUser;

import java.util.concurrent.TimeUnit;

public class TrekUserTest {

    protected WebDriver webDriver;
    CreateUser createUser;


    @Before
    public void setUp() {
        webDriver = new WebDriverFactory().getWebDriver();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        createUser = new CreateUser();
        createUser.createUser();

    }

    @Test
    @DisplayName("Переход в личный кабинет")
    public void goToAccountProfile() {
        HomePage homePage = new HomePage(webDriver);
        homePage.open();
        homePage.clickLoginInAccountHeader();
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.setEmail(createUser.getEmail());
        loginPage.setPassord(createUser.getPassword());
        loginPage.clickLogin();
        homePage.clickLoginInAccountHeader();
        AccountProfilePage accountProfile = new AccountProfilePage(webDriver);
        Assert.assertEquals("В этом разделе вы можете изменить свои персональные данные", accountProfile.getAccountText());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    public void goToConstructorFromAccountProfile() {
        HomePage homePage = new HomePage(webDriver);
        homePage.open();
        homePage.clickLoginInAccountHeader();
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.setEmail(createUser.getEmail());
        loginPage.setPassord(createUser.getPassword());
        loginPage.clickLogin();
        homePage.clickLoginInAccountHeader();
        AccountProfilePage accountProfile = new AccountProfilePage(webDriver);
        accountProfile.clickConstructor();
        Assert.assertEquals("Соберите бургер", homePage.getTextHead());
    }

    @Test
    @DisplayName("Переход из личного кабинета при нажатии на логотип Stellar Burgers")
    public void goToLogoFromAccountProfile() {
        HomePage homePage = new HomePage(webDriver);
        homePage.open();
        homePage.clickLoginInAccountHeader();
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.setEmail(createUser.getEmail());
        loginPage.setPassord(createUser.getPassword());
        loginPage.clickLogin();
        homePage.clickLoginInAccountHeader();
        AccountProfilePage accountProfile = new AccountProfilePage(webDriver);
        accountProfile.clickLogo();
        Assert.assertEquals("Соберите бургер", homePage.getTextHead());
    }

    @Test
    @DisplayName("Выход из аккаунта")
    public void logoutFromAccountProfile() {
        HomePage homePage = new HomePage(webDriver);
        homePage.open();
        homePage.clickLoginInAccountHeader();
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.setEmail(createUser.getEmail());
        loginPage.setPassord(createUser.getPassword());
        loginPage.clickLogin();
        homePage.clickLoginInAccountHeader();
        AccountProfilePage accountProfile = new AccountProfilePage(webDriver);
        accountProfile.clickExit();
        Assert.assertEquals("Войти", loginPage.getTextButtonLogin());

    }

    @Test
    @DisplayName("Пользователь прошелся по разделам конструктора")
    public void goToBurgerIngredients() {
        HomePage homePage = new HomePage(webDriver);
        homePage.open();
        homePage.clickLoginInAccountHeader();
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.setEmail(createUser.getEmail());
        loginPage.setPassord(createUser.getPassword());
        loginPage.clickLogin();
        homePage.clickSauce();
        homePage.waitSause();
        Assert.assertEquals("Соусы", homePage.waitTextSause());
        homePage.clickFilling();
        homePage.waitFilling();
        Assert.assertEquals("Начинки", homePage.waitTextFilling());
        homePage.clickBun();
        homePage.waitBun();
        Assert.assertEquals("Булки", homePage.waitTextBun());
    }


    @After
    public void teardown() {
        webDriver.quit();
        createUser.deleteUser();
    }
}
