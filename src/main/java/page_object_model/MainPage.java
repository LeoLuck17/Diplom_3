package page_object_model;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver webDriver;
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    private final By personalAccount = By.xpath("//*[@class='AppHeader_header__linkText__3q_va ml-2' and text()= 'Личный Кабинет']");
    private final By buttonLoginAccount = By.xpath("//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg'] and text()= 'Войти в аккаунт']");
    private final By logo = By.className("AppHeader_header__logo__2D0X2");
    private final By constructorButton = By.xpath("//*[@class='AppHeader_header__linkText__3q_va ml-2' and text()= 'Конструктор']");
    private final By constructorMenu = By.className("BurgerIngredients_ingredients__1N8v2");
    private final By bunInConstructor = By.xpath("//*[@class='text text_type_main-default' and text()='Булки']");
    private final By bunInConstructorFocused = By.xpath("//*[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']//span[text()= 'Булки']");
    private final By sauceInConstructor = By.xpath("//*[@class='text text_type_main-default' and text()='Соусы']");
    private final By sauceInConstructorFocused = By.xpath("//*[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']//span[text()= 'Соусы']");

    private final By fillingsInConstructor = By.xpath("//*[@class='text text_type_main-default' and text()='Начинки']");
    private final By fillingsInConstructorFocused = By.xpath("//*[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']//span[text()= 'Начинки']");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickPersonalAccount() {
        webDriver.findElement(personalAccount).click();

    }

    public void clickLoginAccountButton() {
        webDriver.findElement(buttonLoginAccount).click();
    }

    public void clickLogo() {
        webDriver.findElement(logo).click();
    }

    public void clickConstructorButton() {
        webDriver.findElement(constructorButton).click();
    }

    public void checkConstructorMenu() {
        webDriver.findElement(constructorMenu).isDisplayed();
    }

    public void clickBunInConstructor() {
        webDriver.findElement(bunInConstructor).click();
    }

    public void clickSauceInConstructor() {
        webDriver.findElement(sauceInConstructor).click();
    }

    public void clickFillingsInConstructor() {
        webDriver.findElement(fillingsInConstructor).click();
    }

    public void checkSectionBunInConstructorFocused() {
        webDriver.findElement(bunInConstructorFocused);
    }

    public void checkSectionSauceInConstructor() {
        webDriver.findElement(sauceInConstructorFocused);
    }

    public void checkSectionFillingsInConstructor() {
        webDriver.findElement(fillingsInConstructorFocused);
    }
}