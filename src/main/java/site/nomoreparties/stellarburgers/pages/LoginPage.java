package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private static WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By registerLink = By.xpath(".//a[text()='Зарегистрироваться']");
    private final By forgotPasswordLink = By.xpath(".//a[text()='Восстановить пароль']");
    private final By emailInput = By.xpath(".//input[@name='name']");
    private final By passwordInput =  By.xpath(".//input[@name='Пароль']");
    private final By loginButton = By.xpath(".//button[text()='Войти']");
    private final By textLoginForm = By.xpath("//h2[text()='Вход']");
    private final By textButtonCreateOrder = By.xpath(".//button[text()='Оформить заказ']");

    @Step("Click register link")
    public LoginPage clickRegisterLink() {
        driver.findElement(registerLink).click();
        return this;
    }

    @Step("Getting text login form")
    public String getTextLoginForm() {
        return driver.findElement(textLoginForm).getText();
    }

    @Step("Getting a button name after registration")
    public String getTextButtonCreateOrder() {
        return driver.findElement(textButtonCreateOrder).getText();
    }

    @Step("Click forgot password link")
    public LoginPage clickForgotPasswordLink() {
        driver.findElement(forgotPasswordLink).click();
        return this;
    }

    @Step("Fill in the field email")
    public LoginPage inputFieldEmail(String email) {
        driver.findElement(emailInput).click();
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    @Step("Fill in the field password")
    public LoginPage inputFieldPassword(String password) {
        driver.findElement(passwordInput).click();
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    @Step("Click button login")
    public boolean buttonLoginIsDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }

    @Step("Click button login")
    public LoginPage clickButtonLogin() {
        driver.findElement(loginButton).click();
        return this;
    }

    @Step("Fill login form")
    public void fillLoginForm(String email, String password) {
        inputFieldEmail(email);
        inputFieldPassword(password);
        clickButtonLogin();
    }
}

