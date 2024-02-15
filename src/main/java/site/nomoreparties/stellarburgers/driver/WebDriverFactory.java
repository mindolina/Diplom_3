package site.nomoreparties.stellarburgers.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    public WebDriver getWebDriver() {

        switch (System.getProperty("browser", "chrom")) {
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
                return new ChromeDriver();
            case "chrom":
                return new ChromeDriver();
            default:
                return new ChromeDriver();
        }
    }

}