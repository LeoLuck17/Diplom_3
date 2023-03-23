package chrome_browser;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page_object_model.LoginPage;
import page_object_model.MainPage;

public class SwitchBetweenPagesTest extends BaseTestChrome{
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
