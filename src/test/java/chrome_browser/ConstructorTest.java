package chrome_browser;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page_object_model.MainPage;

public class ConstructorTest extends BaseTestChrome {
    private final WebDriver driver = setUp();
    MainPage mainPage = new MainPage(driver);

    @DisplayName("Переход на вкладку Булки в конструкторе")
    @Test
    public void clickOnBunInConstructor() {
        mainPage.clickFillingsInConstructor();
        mainPage.checkSectionFillingsInConstructor();
        mainPage.clickBunInConstructor();
        mainPage.checkSectionBunInConstructorFocused();
    }

    @DisplayName("Переход на вкладку Соус в конструкторе")
    @Test
    public void clickOnSauceInConstructor() {
        mainPage.clickFillingsInConstructor();
        mainPage.clickSauceInConstructor();
        mainPage.checkSectionSauceInConstructor();
    }

    @DisplayName("Переход на вкладку Начинка в конструкторе")
    @Test
    public void clickOnFillingsInConstructor() {
        mainPage.clickFillingsInConstructor();
        mainPage.checkSectionFillingsInConstructor();
    }
}
