package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private static WebDriver driver;
    public static final String ACCOUNT_URL = "https://stellarburgers.nomoreparties.site/account";
    private final By BUTTON_LOGOUT = By.xpath(".//button[text()='Выход']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click login link")
    public AccountPage clickLogoutButton() {
        driver.findElement(BUTTON_LOGOUT).click();
        return this;
    }
}
