package site.nomoreparties.stellarburgers.user;

import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;
import site.nomoreparties.stellarburgers.baseRule.BaseRule;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.ForgotPasswordPage;
import site.nomoreparties.stellarburgers.pages.HomePage;
import site.nomoreparties.stellarburgers.pages.LoginPage;
import site.nomoreparties.stellarburgers.pages.RegisterPage;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class UserLoginTest extends BaseRule {
    private UserConstructor userConstructor;
    private HomePage homePage;
    private LoginPage loginPage;
    private UserSteps userSteps;
    private RegisterPage registerPage;
    private ForgotPasswordPage forgotPasswordPage;


    @Before
    public void setUp() {
        userConstructor = UserRandom.getUserRandom();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        userSteps = new UserSteps();
        userSteps.userCreate(userConstructor);
    }

    @Test
    @DisplayName("Log in using the \"Log in to account\" button on the main page")
    public void loginUserByLoginButton() {
        homePage.clickButtonLoginAccount();
        loginPage.fillLoginForm(userConstructor.getEmail(), userConstructor.getPassword());
        boolean isDisplayed = loginPage.buttonLoginIsDisplayed();
        String text = loginPage.getTextButtonCreateOrder();
        assertTrue(isDisplayed);
        assertThat("There was no transition to the main page after registration",
                text, containsString("Оформить заказ"));
    }

    @Test
    @DisplayName("Login via the \"Personal Account\" button")
    public void loginUserByAccountButton() {
        homePage.clickButtonAccount();
        loginPage.fillLoginForm(userConstructor.getEmail(), userConstructor.getPassword());
        boolean isDisplayed = loginPage.buttonLoginIsDisplayed();
        String text = loginPage.getTextButtonCreateOrder();
        assertTrue(isDisplayed);
        assertThat("There was no transition to the main page after registration",
                text, containsString("Оформить заказ"));
    }

    @Test
    @DisplayName("Login via the button in the registration form")
    public void loginUserByRegisterPage() {
        registerPage = new RegisterPage(driver);
        homePage.clickButtonAccount();
        loginPage.clickRegisterLink();
        registerPage.clickLoginLink();
        loginPage.fillLoginForm(userConstructor.getEmail(), userConstructor.getPassword());
        boolean isDisplayed = loginPage.buttonLoginIsDisplayed();
        String text = loginPage.getTextButtonCreateOrder();
        assertTrue(isDisplayed);
        assertThat("There was no transition to the main page after registration",
                text, containsString("Оформить заказ"));
    }

    @Test
    @DisplayName("Login via the button in the password recovery form")
    public void loginUserByForgotPasswordPage() {
        forgotPasswordPage = new ForgotPasswordPage(driver);
        homePage.clickButtonAccount();
        loginPage.clickForgotPasswordLink();
        forgotPasswordPage.clickLoginLink();
        loginPage.fillLoginForm(userConstructor.getEmail(), userConstructor.getPassword());
        boolean isDisplayed = loginPage.buttonLoginIsDisplayed();
        String text = loginPage.getTextButtonCreateOrder();
        assertTrue(isDisplayed);
        assertThat("There was no transition to the main page after registration",
                text, containsString("Оформить заказ"));
    }

    @After
    @Step("Delete user")
    public void userDelete() {
        String accessToken = homePage.getAccessToken();
        userSteps.userDelete(StringUtils.substringAfter(accessToken, ""));
    }
}

