import PageObjectModel.MainPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ConstructorTest {
    private static final WebDriver DRIVER = new ChromeDriver();
    MainPage mainPage = new MainPage(DRIVER);


    @Before
    public void setUp() {
        DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        DRIVER.get("https://stellarburgers.nomoreparties.site/");
    }

    @DisplayName("Переход на вкладку Булки в конструкторе")
    @Test
    public void clickOnBunInConstructor() {
        mainPage.clickSauceInConstructor();
        mainPage.checkSectionSauceInConstructor();
        mainPage.clickBunInConstructor();
        mainPage.checkSectionBunInConstructor();
    }

    @DisplayName("Переход на вкладку Соус в конструкторе")
    @Test
    public void clickOnSauceInConstructor() {
        mainPage.clickSauceInConstructor();
        mainPage.checkSectionSauceInConstructor();
    }

    @DisplayName("Переход на вкладку Начинка в конструкторе")
    @Test
    public void clickOnFillingsInConstructor() {
        mainPage.clickFillingsInConstructor();
        mainPage.checkSectionFillingsInConstructor();
    }

    @AfterClass
    public static void tearDown() {
        DRIVER.quit();
    }
}
