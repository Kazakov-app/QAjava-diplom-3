package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private static WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By BUTTON_ACCOUNT = By.xpath(".//p[text()='Личный Кабинет']");
    private final By BUTTON_CONSTRUCTOR = By.xpath("//p[text()='Конструктор']");
    private final By LINK_LOGO_BURGERS = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");
    private final By BUTTON_LOGIN_ACCOUNT = By.xpath("//button[text()='Войти в аккаунт']");
    private final By BUTTON_INGREDIENTS_BUN = By.xpath("//span[@class='text text_type_main-default' and text()='Булки']/ancestor::div[1]");
    private final By BUTTON_INGREDIENTS_SAUCE = By.xpath("//span[@class='text text_type_main-default' and text()='Соусы']/ancestor::div[1]");
    private final By BUTTON_INGREDIENTS_FILLING= By.xpath("//span[@class='text text_type_main-default' and text()='Начинки']/ancestor::div[1]");

    @Step("Click button personal account")
    public HomePage clickButtonAccount(){
        driver.findElement(BUTTON_ACCOUNT).click();
        return this;
    }

    @Step("Click button burger constructor")
    public HomePage clickButtonConstructor(){
        driver.findElement(BUTTON_CONSTRUCTOR).click();
        return this;
    }

    @Step("Click logo burgers")
    public HomePage clickLinkLogoBurgers(){
        driver.findElement(LINK_LOGO_BURGERS).click();
        return this;
    }

    @Step("Click button login account")
    public HomePage clickButtonLoginAccount(){
        driver.findElement(BUTTON_LOGIN_ACCOUNT).click();
        return this;
    }

    @Step("Click burger constructor - bun")
    public String clickIngredientsBun(){
        driver.findElement(BUTTON_INGREDIENTS_BUN);
        String bunClass = driver.findElement(BUTTON_INGREDIENTS_BUN).getAttribute("class").toString();
        return bunClass;
    }

    @Step("Click burger constructor - sauce")
    public String clickIngredientsSauce(){
        driver.findElement(BUTTON_INGREDIENTS_SAUCE).click();
        String sauceClass = driver.findElement(BUTTON_INGREDIENTS_SAUCE).getAttribute("class").toString();
        return sauceClass;
    }

    @Step("Click burger constructor - filling")
    public String clickIngredientsFilling(){
        driver.findElement(BUTTON_INGREDIENTS_FILLING).click();
        String fillingClass = driver.findElement(BUTTON_INGREDIENTS_FILLING).getAttribute("class").toString();
        return fillingClass;
    }
}
