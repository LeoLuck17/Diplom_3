package yandex_browser;

import api.client.UserClient;
import api.model.UserCredentials;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page_object_model.MainPage;

import java.util.concurrent.TimeUnit;

public class BaseTestYandex {
    UserClient userClient;
    UserCredentials userCredentials;
    String accessToken;
    WebDriver driver;
    public WebDriver setUp() {

        System.setProperty("webdriver.chrome.driver", "C:/Users/LeoYa/Diplom3/src/main/resources/chromedriver108.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:/Users/LeoYa/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(MainPage.BASE_URL);
        return driver;
    }
    @After
    public void clearUp() {
        driver.quit();
        if(userCredentials != null){
            ValidatableResponse responseLogin = userClient.loginUser(userCredentials);
            accessToken = responseLogin.extract().path("accessToken");
            accessToken = accessToken.substring(7);
            userClient.deleteUser(accessToken);
        }

    }
}
