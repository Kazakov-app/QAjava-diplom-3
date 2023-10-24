package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private static WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By LOGIN_LINK = By.xpath(".//a[text()='Войти']");
    private final By NAME_INPUT = By.xpath(".//label[text()='Имя']//following-sibling::input");
    private final By EMAIL_INPUT = By.xpath(".//label[text()='Email']//following-sibling::input");
    private final By PASSWORD_INPUT = By.xpath(".//label[text()='Пароль']//following-sibling::input");
    private final By BUTTON_REGISTER = By.xpath("//button[text()='Зарегистрироваться']");
    private final By ERROR_PASSWORD = By.xpath("//p[text()='Некорректный пароль']");

    @Step("Click login link")
    public RegisterPage clickLoginLink() {
        driver.findElement(LOGIN_LINK).click();
        return this;
    }

    @Step("Fill in the field name")
    public RegisterPage inputFieldName(String name) {
        driver.findElement(NAME_INPUT).click();
        driver.findElement(NAME_INPUT).sendKeys(name);
        return this;
    }

    @Step("Fill in the field name")
    public RegisterPage inputFieldEmail(String email) {
        driver.findElement(EMAIL_INPUT).click();
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        return this;
    }

    @Step("Fill in the field password")
    public RegisterPage inputFieldPassword(String password) {
        driver.findElement(PASSWORD_INPUT).click();
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        return this;
    }

    @Step("Click button register")
    public boolean buttonRegisterIsDisplayed() {
        return driver.findElement(BUTTON_REGISTER).isDisplayed();
    }

    @Step("Click button register")
    public RegisterPage clickButtonRegister() {
        driver.findElement(BUTTON_REGISTER).click();
        return this;
    }

    @Step("Error text about incorrect password")
    public String getTextErrorPassword() {
        return driver.findElement(ERROR_PASSWORD).getText();
    }

    @Step("Fill register form")
    public void fillRegisterForm(String name, String email, String password) {
        inputFieldName(name);
        inputFieldEmail(email);
        inputFieldPassword(password);
        clickButtonRegister();
    }
}
