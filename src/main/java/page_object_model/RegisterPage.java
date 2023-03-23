package page_object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private final WebDriver webDriver;
    private final By fieldName = By.xpath("//fieldset[1]//div[1]//div[1]");
    private final By fieldNameFocus = By.xpath("//div[@class='input pr-6 pl-6 input_type_text input_size_default input_status_active']//input[@name='name']");
    private final By fieldEmail = By.xpath("//fieldset[2]//div[1]//div[1]");
    private final By fieldEmailFocus = By.xpath("//div[@class='input pr-6 pl-6 input_type_text input_size_default input_status_active']//input[@name='name']");
    private final By fieldPassword = By.xpath("//fieldset[3]//div[1]//div[1]");
    private final By fieldPasswordFocus = By.xpath("//input[@name='Пароль']");
    private final By buttonAssertRegister = By.xpath("//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text()='Зарегистрироваться']");
    private final By buttonLogin = By.className("Auth_link__1fOlj");

    public RegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fillingFieldName(String name) {
        webDriver.findElement(fieldName).click();
        webDriver.findElement(fieldNameFocus).sendKeys(name);
    }

    public void fillingFieldEmail(String email) {
        webDriver.findElement(fieldEmail).click();
        webDriver.findElement(fieldEmailFocus).sendKeys(email);
    }

    public void fillingFieldPassword(String password) {
        webDriver.findElement(fieldPassword).click();
        webDriver.findElement(fieldPasswordFocus).sendKeys(password);
    }

    public void clickButtonRegisterNewUser() {
        webDriver.findElement(buttonAssertRegister).click();
    }

    public void clickButtonLogin() {
        webDriver.findElement(buttonLogin).click();
    }

    public void registerUser(String name, String email, String password) {
        fillingFieldName(name);
        fillingFieldEmail(email);
        fillingFieldPassword(password);
        clickButtonRegisterNewUser();
    }
}
