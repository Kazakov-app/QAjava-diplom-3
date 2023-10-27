package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private static WebDriver driver;
    private final By buttonLogout = By.xpath(".//button[text()='Выход']");
    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click login link")
    public AccountPage clickLogoutButton() {
        driver.findElement(buttonLogout).click();
        return this;
    }
}
