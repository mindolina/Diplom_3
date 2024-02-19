package site.nomoreparties.stellarburgers;


import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.driver.WebDriverFactory;
import site.nomoreparties.stellarburgers.pages.HomePage;

public class ConstructorTest {
    protected WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = new WebDriverFactory().getWebDriver();
    }

    @Test
    @DisplayName("Пользователь перешел к разделу Начинки")
    public void goToFillings() {
        HomePage homePage = new HomePage(webDriver);
        homePage.open();
        homePage.clickFilling();
        Assert.assertTrue(homePage.waitFilling());
    }

    @Test
    @DisplayName("Пользователь перешел к разделу Соусы")
    public void goToSause() {
        HomePage homePage = new HomePage(webDriver);
        homePage.open();
        homePage.clickFilling();
        homePage.clickSauce();
        Assert.assertTrue(homePage.waitSause());
    }

    @Test
    @DisplayName("Пользователь перешел к разделу Булки")
    public void goToBun() {
        HomePage homePage = new HomePage(webDriver);
        homePage.open();
        homePage.clickFilling();
        homePage.clickBun();
        Assert.assertTrue(homePage.waitBun());
    }

    @After
    public void teardown() {
        webDriver.quit();
    }

}
