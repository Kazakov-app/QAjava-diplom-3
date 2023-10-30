package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private static WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By loginLink = By.xpath(".//a[text()='Войти']");
    private final By nameInput = By.xpath(".//label[text()='Имя']//following-sibling::input");
    private final By emailInput = By.xpath(".//label[text()='Email']//following-sibling::input");
    private final By passwordInput = By.xpath(".//label[text()='Пароль']//following-sibling::input");
    private final By buttonRegister = By.xpath("//button[text()='Зарегистрироваться']");
    private final By errorPassword = By.xpath("//p[text()='Некорректный пароль']");

    @Step("Click login link")
    public RegisterPage clickLoginLink() {
        driver.findElement(loginLink).click();
        return this;
    }

    @Step("Fill in the field name")
    public RegisterPage inputFieldName(String name) {
        driver.findElement(nameInput).click();
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }

    @Step("Fill in the field name")
    public RegisterPage inputFieldEmail(String email) {
        driver.findElement(emailInput).click();
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    @Step("Fill in the field password")
    public RegisterPage inputFieldPassword(String password) {
        driver.findElement(passwordInput).click();
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    @Step("Click button register")
    public boolean buttonRegisterIsDisplayed() {
        return driver.findElement(buttonRegister).isDisplayed();
    }

    @Step("Click button register")
    public RegisterPage clickButtonRegister() {
        driver.findElement(buttonRegister).click();
        return this;
    }

    @Step("Error text about incorrect password")
    public String getTextErrorPassword() {
        return driver.findElement(errorPassword).getText();
    }

    @Step("Fill register form")
    public void fillRegisterForm(String name, String email, String password) {
        inputFieldName(name);
        inputFieldEmail(email);
        inputFieldPassword(password);
        clickButtonRegister();
    }
}
