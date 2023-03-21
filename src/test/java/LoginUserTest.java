import PageObjectModel.LoginPage;
import PageObjectModel.MainPage;
import PageObjectModel.PersonalAccount;
import PageObjectModel.RegisterPage;
import Utils.GenerateRandomData;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginUserTest {
    private static final WebDriver DRIVER = new ChromeDriver();
    MainPage mainPage = new MainPage(DRIVER);
    RegisterPage registerPage = new RegisterPage(DRIVER);
    LoginPage loginPage = new LoginPage(DRIVER);
    PersonalAccount personalAccount = new PersonalAccount(DRIVER);
    GenerateRandomData generateRandomData = new GenerateRandomData();
    String name = generateRandomData.getName();
    String email = generateRandomData.getEmail();
    String password = generateRandomData.getPassword();
    @Step("Проверка успешной авторизации пользователя")
    public void checkSuccessfulLogin() {
        mainPage.clickPersonalAccount();
        personalAccount.checkProfileMenu();
    }
    @Step("Выход из личного кабинета и переход на главную страницу")
    public void logoutAndSwitchMainPage() {
        personalAccount.logout();
        mainPage.clickLogo();
    }

    @Before
    public void setUp() {
        DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        DRIVER.get("https://stellarburgers.nomoreparties.site/");
        //регистрация пользователя
        mainPage.clickPersonalAccount();
        loginPage.clickRegisterButton();
        registerPage.registerUser(name, email, password);
        loginPage.checkWindowLogin();
        DRIVER.get("https://stellarburgers.nomoreparties.site/");
    }
    @DisplayName("Авторизация пользователя с кнопки Войти в аккаунт на главной странице")
    @Test
    public void enterFromMainPageButton() {
        mainPage.clickLoginAccountButton();
        loginPage.loginUser(email, password);
        checkSuccessfulLogin();
        logoutAndSwitchMainPage();
    }
    @DisplayName("Авторизация пользователя из личного кабинета")
    @Test
    public void enterFromPersonalAccount() {
        mainPage.clickPersonalAccount();
        loginPage.loginUser(email, password);
        checkSuccessfulLogin();
        logoutAndSwitchMainPage();
    }
    @DisplayName("Авторизация пользователя из страницы восстановления пароля")
    @Test
    public void enterFromFormRecoveryPassword() {
        mainPage.clickPersonalAccount();
        loginPage.clickPasswordRecoveryButton();
        loginPage.clickEnterButtonFromPasswordRecoveryPage();
        loginPage.loginUser(email, password);
        checkSuccessfulLogin();
        logoutAndSwitchMainPage();
    }
    @DisplayName("Авторизация пользователя из формы регистрации")
    @Test
    public void enterFromRegisterForm() {
        mainPage.clickPersonalAccount();
        loginPage.clickRegisterButton();
        registerPage.clickButtonLogin();
        loginPage.loginUser(email, password);
        checkSuccessfulLogin();
        logoutAndSwitchMainPage();
    }
    @DisplayName("Успешный выход пользователя из системы")
    @Test
    public void logoutAfterCorrectLogin() {
        mainPage.clickPersonalAccount();
        loginPage.loginUser(email, password);
        checkSuccessfulLogin();
        logoutAndSwitchMainPage();
    }
    @AfterClass
    public static void tearDown(){
        DRIVER.quit();
    }
}
