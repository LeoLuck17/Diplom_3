package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private final WebDriver webDriver;
    private final By fieldName = By.xpath("//label[@class='input__placeholder text noselect text_type_main-default' and text()='Имя']");
    private final By fieldNameFocus = By.xpath("/html/body/div/div/main/div/form/fieldset[1]/div/div/input");
    private final By fieldEmail = By.xpath("//label[@class='input__placeholder text noselect text_type_main-default' and text()='Email']");
    private final By fieldEmailFocus = By.xpath("/html/body/div/div/main/div/form/fieldset[2]/div/div/input");
    private final By fieldPassword = By.xpath("//label[@class='input__placeholder text noselect text_type_main-default' and text()='Пароль']");
    private final By fieldPasswordFocus = By.xpath("/html/body/div/div/main/div/form/fieldset[3]/div/div/input");
    private final By buttonAssertRegister = By.xpath("//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
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
