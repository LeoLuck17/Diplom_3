package yandex_browser;

import page_object_model.LoginPage;
import page_object_model.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SwitchBetweenPagesTest extends BaseTestYandex{
    private final WebDriver driver = setUp();
    MainPage mainPage = new MainPage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @DisplayName("Переход на вкладку Личный кабинет")
    @Test
    public void switchToProfile() {
        mainPage.clickPersonalAccount();
        loginPage.checkWindowLogin();
        mainPage.clickLogo();
    }

    @DisplayName("Переход на главную страницу из личного кабинета")
    @Test
    public void switchToMainPageFromProfile() {
        mainPage.clickPersonalAccount();
        mainPage.clickLogo();
        mainPage.checkConstructorMenu();
    }

    @DisplayName("Переход на Конструктор из Личного кабинета")
    @Test
    public void switchToConstructorFromProfile() {
        mainPage.clickPersonalAccount();
        mainPage.clickConstructorButton();
        mainPage.checkConstructorMenu();
    }
}
