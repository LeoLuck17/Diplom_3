package yandex_browser;

import api.model.UserCredentials;
import page_object_model.LoginPage;
import page_object_model.MainPage;
import page_object_model.PersonalAccount;
import page_object_model.RegisterPage;
import utils.GenerateRandomData;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class LoginUserTest extends BaseTestYandex{
    private final WebDriver driver = setUp();
    MainPage mainPage = new MainPage(driver);
    RegisterPage registerPage = new RegisterPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    PersonalAccount personalAccount = new PersonalAccount(driver);
    GenerateRandomData generateRandomData = new GenerateRandomData();
    String name = generateRandomData.getName();
    String email = generateRandomData.getEmail();
    String password = generateRandomData.getPassword();
    UserCredentials userCredentials= new UserCredentials(email, password);
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
    public void createNewUser() {
        mainPage.clickPersonalAccount();
        loginPage.clickRegisterButton();
        registerPage.registerUser(name, email, password);
        loginPage.checkWindowLogin();
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
}
