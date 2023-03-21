import PageObjectModel.LoginPage;
import PageObjectModel.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SwitchBetweenPagesTest {
    private static final WebDriver DRIVER = new ChromeDriver();
    MainPage mainPage = new MainPage(DRIVER);
    LoginPage loginPage = new LoginPage(DRIVER);

    @Before
    public void setUp() {
        DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        DRIVER.get("https://stellarburgers.nomoreparties.site/");
    }

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

    @AfterClass
    public static void tearDown() {
        DRIVER.quit();
    }
}
