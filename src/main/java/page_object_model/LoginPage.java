package page_object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver webDriver;
    private final By registerButtonNewUser = By.className("Auth_link__1fOlj");
    private final By windowLogin = By.xpath("//h2[text()='Вход']");
    private final By fieldEmail = By.xpath("//label[@class='input__placeholder text noselect text_type_main-default' and text()='Email']");
    private final By fieldEmailFocus = By.xpath("//input[@name='name']");
    private final By fieldPassword = By.xpath("//label[@class='input__placeholder text noselect text_type_main-default' and text()='Пароль']");
    private final By fieldPasswordFocus = By.xpath("//input[@name='Пароль']");
    private final By loginButton = By.xpath("//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text()='Войти']");
    private final By passwordRecoveryButton = By.xpath("//a[@class='Auth_link__1fOlj' and text()='Восстановить пароль']");
    private final By enterButtonFromPasswordRecoveryPage = By.xpath("//a[@class='Auth_link__1fOlj' and text()='Войти']");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickRegisterButton() {
        webDriver.findElement(registerButtonNewUser).click();
    }

    public void checkWindowLogin() {
        webDriver.findElement(windowLogin).isDisplayed();
    }

    public void fillingFieldEmail(String email) {
        webDriver.findElement(fieldEmail).click();
        webDriver.findElement(fieldEmailFocus).sendKeys(email);
    }

    public void fillingFieldPassword(String password) {
        webDriver.findElement(fieldPassword).click();
        webDriver.findElement(fieldPasswordFocus).sendKeys(password);
    }

    public void clickLoginButton() {
        webDriver.findElement(loginButton).click();
    }

    public void clickPasswordRecoveryButton() {
        webDriver.findElement(passwordRecoveryButton).click();
    }

    public void clickEnterButtonFromPasswordRecoveryPage() {
        webDriver.findElement(enterButtonFromPasswordRecoveryPage).click();
    }

    public void loginUser(String email, String password) {
        fillingFieldEmail(email);
        fillingFieldPassword(password);
        clickLoginButton();
    }
}
