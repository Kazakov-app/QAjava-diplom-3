package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private static WebDriver driver;
    private final By loginLink = By.xpath(".//p[text()='Личный Кабинет']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click login link")
    public ForgotPasswordPage clickLoginLink() {
        driver.findElement(loginLink).click();
        return this;
    }
}
