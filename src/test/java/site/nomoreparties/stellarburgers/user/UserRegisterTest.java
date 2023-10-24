package site.nomoreparties.stellarburgers.user;

import site.nomoreparties.stellarburgers.baseRule.BaseRule;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.HomePage;
import site.nomoreparties.stellarburgers.pages.LoginPage;
import site.nomoreparties.stellarburgers.pages.RegisterPage;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class UserRegisterTest extends BaseRule {
    private UserConstructor userConstructor;
    private HomePage homePage;
    private RegisterPage registerPage;
    private LoginPage loginPage;


    @Before
    public void setUp() {
        userConstructor = UserRandom.getUserRandom();
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    @DisplayName("Register user by valid data, through the \"log in to account\" button")
    public void registerUserByValidData() {
        homePage.clickButtonAccount();
        loginPage.clickRegisterLink();
        registerPage.fillRegisterForm(userConstructor.getName(),
                userConstructor.getEmail(), userConstructor.getPassword());
        boolean isDisplayed = registerPage.buttonRegisterIsDisplayed();
        String text = loginPage.getTextLoginForm();
        assertTrue(isDisplayed);
        assertThat("There was no transition to the login page",
                text, containsString("Вход"));
    }

    @Test
    @DisplayName("Register user by invalid password - 5 symbol")
    public void registerUserNotValidPassword() {
        homePage.clickButtonAccount();
        loginPage.clickRegisterLink();
        registerPage.fillRegisterForm(userConstructor.getName(), userConstructor.getEmail(), "123z5");
        String text = registerPage.getTextErrorPassword();
        assertThat("Incorrect error about incorrect password ",
                text, containsString("Некорректный пароль"));
    }

    @After
    public void clearState() {
        userConstructor = null;
    }
}
