package chrome_browser;

import api.model.UserCredentials;
import io.qameta.allure.junit4.DisplayName;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object_model.LoginPage;
import page_object_model.MainPage;
import page_object_model.RegisterPage;
import utils.GenerateRandomData;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class RegisterUserTest extends BaseTestChrome{
    private final WebDriver driver = setUp();
    private final String password;
    MainPage mainPage = new MainPage(driver);
    RegisterPage registerPage = new RegisterPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    GenerateRandomData generateRandomData = new GenerateRandomData();
    private final String name = generateRandomData.getName();
    private final String email = generateRandomData.getEmail();

    public RegisterUserTest(String password) {

        this.password = password;
    }

    @Parameterized.Parameters
    public static Object[][] getDataUser() {

        return new Object[][]{
                {"123456"},
                {"12345"},
                {"1234567"},
                {"123"},
                {"12345678910"}
        };
    }

    @DisplayName("Регистрация пользователя")
    @Test
    public void registerNewUser() {
        mainPage.clickPersonalAccount();
        loginPage.clickRegisterButton();
        registerPage.registerUser(name, email, password);
        loginPage.checkWindowLogin();
        UserCredentials userCredentials= new UserCredentials(email, password);
    }
}
