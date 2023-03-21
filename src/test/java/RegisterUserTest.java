import PageObjectModel.LoginPage;
import PageObjectModel.MainPage;
import PageObjectModel.RegisterPage;
import Utils.GenerateRandomData;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class RegisterUserTest {
    private static final WebDriver DRIVER = new ChromeDriver();
    private final String password;
    MainPage mainPage = new MainPage(DRIVER);
    RegisterPage registerPage = new RegisterPage(DRIVER);
    LoginPage loginPage = new LoginPage(DRIVER);
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

    @Before
    public void setUp() {
        DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        DRIVER.get("https://stellarburgers.nomoreparties.site/");
    }
    @DisplayName("Регистрация пользователя")
    @Test
    public void registerNewUser() {
        mainPage.clickPersonalAccount();
        loginPage.clickRegisterButton();
        registerPage.registerUser(name, email, password);
        loginPage.checkWindowLogin();
    }

    @AfterClass
    public static void tearDown() {
        DRIVER.quit();
    }
}
