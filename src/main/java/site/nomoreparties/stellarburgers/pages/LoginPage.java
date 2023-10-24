package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private static WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By REGISTER_LINK = By.xpath(".//a[text()='Зарегистрироваться']");
    private final By FORGOT_PASSWORD_LINK = By.xpath(".//a[text()='Восстановить пароль']");
    private final By EMAIL_INPUT = By.xpath(".//input[@name='name']");
    private final By PASSWORD_INPUT =  By.xpath(".//input[@name='Пароль']");
    private final By LOGIN_BUTTON = By.xpath(".//button[text()='Войти']");
    private final By TEXT_LOGIN_FORM = By.xpath("//h2[text()='Вход']");
    private final By TEXT_BUTTON_CREATE_ORDER = By.xpath(".//button[text()='Оформить заказ']");

    @Step("Click register link")
    public LoginPage clickRegisterLink() {
        driver.findElement(REGISTER_LINK).click();
        return this;
    }

    @Step("Getting text login form")
    public String getTextLoginForm() {
        return driver.findElement(TEXT_LOGIN_FORM).getText();
    }

    @Step("Getting a button name after registration")
    public String getTextButtonCreateOrder() {
        return driver.findElement(TEXT_BUTTON_CREATE_ORDER).getText();
    }

    @Step("Click forgot password link")
    public LoginPage clickForgotPasswordLink() {
        driver.findElement(FORGOT_PASSWORD_LINK).click();
        return this;
    }

    @Step("Fill in the field email")
    public LoginPage inputFieldEmail(String email) {
        driver.findElement(EMAIL_INPUT).click();
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        return this;
    }

    @Step("Fill in the field password")
    public LoginPage inputFieldPassword(String password) {
        driver.findElement(PASSWORD_INPUT).click();
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        return this;
    }

    @Step("Click button login")
    public boolean buttonLoginIsDisplayed() {
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }

    @Step("Click button login")
    public LoginPage clickButtonLogin() {
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    @Step("Fill login form")
    public void fillLoginForm(String email, String password) {
        inputFieldEmail(email);
        inputFieldPassword(password);
        clickButtonLogin();
    }
}

