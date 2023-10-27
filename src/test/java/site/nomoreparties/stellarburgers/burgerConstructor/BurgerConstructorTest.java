package site.nomoreparties.stellarburgers.burgerConstructor;

import site.nomoreparties.stellarburgers.baseRule.BaseRule;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.HomePage;
import static org.junit.Assert.assertTrue;
import static site.nomoreparties.stellarburgers.pages.HomePage.BY_CLASS_CONSTRUCTOR_BURGER;

public class BurgerConstructorTest extends BaseRule {
    private HomePage homePage;


    @Before
    public void setUp() {
        homePage = new HomePage(driver);
    }

    @Test
    @DisplayName("Go to the \"Bun\" section")
    public void findBunIngredient() {
        String actualClass = homePage.clickIngredientsBun();
        assertTrue(actualClass.contains(BY_CLASS_CONSTRUCTOR_BURGER));
    }

    @Test
    @DisplayName("Go to the \"Sauces\" section")
    public void findSauceIngredient() {
        String actualClass = homePage.clickIngredientsSauce();
        assertTrue(actualClass.contains(BY_CLASS_CONSTRUCTOR_BURGER));
    }

    @Test
    @DisplayName("Go to the \"Filling\" section")
    public void findFillingIngredient() {
        String actualClass = homePage.clickIngredientsFilling();
        assertTrue(actualClass.contains(BY_CLASS_CONSTRUCTOR_BURGER));
    }
}
