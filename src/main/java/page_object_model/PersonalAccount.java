package page_object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccount {
    private final WebDriver webDriver;
    private final By profileMenu = By.xpath("//a[@class='Account_link__2ETsJ text text_type_main-medium text_color_inactive Account_link_active__2opc9' and text()='Профиль']");
    private final By exitButton = By.xpath("//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive' and text()='Выход']");

    public PersonalAccount(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void checkProfileMenu() {
        webDriver.findElement(profileMenu).isDisplayed();
    }

    public void logout() {
        webDriver.findElement(exitButton).click();
    }
}
