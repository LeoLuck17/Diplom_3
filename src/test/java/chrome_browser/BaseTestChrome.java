package chrome_browser;

import api.client.UserClient;
import api.model.UserCredentials;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object_model.MainPage;

import java.util.concurrent.TimeUnit;

public class BaseTestChrome {
    UserClient userClient;
    UserCredentials userCredentials;
    String accessToken;
    WebDriver driver = new ChromeDriver();

    public WebDriver setUp() {

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
