package site.nomoreparties.stellarburgers.user;

import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;
import site.nomoreparties.stellarburgers.baseRule.BaseRule;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.AccountPage;
import site.nomoreparties.stellarburgers.pages.HomePage;
import site.nomoreparties.stellarburgers.pages.LoginPage;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static site.nomoreparties.stellarburgers.constantsApi.ApiEndPoints.BASE_URL;
import static site.nomoreparties.stellarburgers.constantsApi.ApiEndPoints.ACCOUNT_URL;

public class UserAccountTest extends BaseRule {
    private UserConstructor userConstructor;
    private HomePage homePage;
    private LoginPage loginPage;
    private UserSteps userSteps;
    private String accessToken = new String();


    @Before
    public void setUp() {
        userConstructor = UserRandom.getUserRandom();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        userSteps = new UserSteps();
        userSteps.userCreate(userConstructor);
        homePage.clickButtonLoginAccount();
        loginPage.fillLoginForm(userConstructor.getEmail(), userConstructor.getPassword());
    }

    @Test
    @DisplayName("Click-through to the Personal Account")
    public void transitionToAccount() {
        homePage.clickButtonAccount();
        String actualUrl = driver.getCurrentUrl();
        assertEquals("URL doesn't match", ACCOUNT_URL, actualUrl);
    }

    @Test
    @DisplayName("Transition from the personal account to the constructor by clicking on the \"Constructor\"")
    public void transitionToConstructor() {
        homePage.clickButtonAccount();
        homePage.clickButtonConstructor();
        String actualUrl = driver.getCurrentUrl();
        assertEquals("URL doesn't match", BASE_URL, actualUrl);
    }

    @Test
    @DisplayName("Transfer from your personal account to the constructor by clicking on the Stellar Burgers logo")
    public void transitionToLogoBurgers() {
        homePage.clickButtonAccount();
        homePage.clickLinkLogoBurgers();
        String actualUrl = driver.getCurrentUrl();
        assertEquals("URL doesn't match", BASE_URL, actualUrl);
    }

    @Test
    @DisplayName("Log out using the \"Log out\" button in your personal account")
    public void logoutUserByLogoutButton() {
        homePage.clickButtonAccount();
        new AccountPage(driver).clickLogoutButton();
        String text = loginPage.getTextLoginForm();
        assertThat("There was no transition to the login page",text, containsString("Вход"));
    }

    @After
    @Step("Delete user")
    public void userDelete() {
        userSteps.userDelete(StringUtils.substringAfter(accessToken, ""));
    }
}
