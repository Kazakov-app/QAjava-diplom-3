package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;

public class HomePage {
    private static WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By buttonAccount = By.xpath(".//p[text()='Личный Кабинет']");
    private final By buttonConstructor = By.xpath("//p[text()='Конструктор']");
    private final By linkLogoBurgers = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");
    private final By buttonLoginAccount = By.xpath("//button[text()='Войти в аккаунт']");
    private final By buttonIngredientsBun = By.xpath("//span[@class='text text_type_main-default' and text()='Булки']/ancestor::div[1]");
    private final By buttonIngredientsSauce = By.xpath("//span[@class='text text_type_main-default' and text()='Соусы']/ancestor::div[1]");
    private final By buttonIngredientsFilling = By.xpath("//span[@class='text text_type_main-default' and text()='Начинки']/ancestor::div[1]");
    public static final String BY_CLASS_CONSTRUCTOR_BURGER = "tab_tab_type_current__2BEPc";

    @Step("Click button personal account")
    public HomePage clickButtonAccount(){
        driver.findElement(buttonAccount).click();
        return this;
    }

    @Step("Click button burger constructor")
    public HomePage clickButtonConstructor(){
        driver.findElement(buttonConstructor).click();
        return this;
    }

    @Step("Click logo burgers")
    public HomePage clickLinkLogoBurgers(){
        driver.findElement(linkLogoBurgers).click();
        return this;
    }

    @Step("Click button login account")
    public HomePage clickButtonLoginAccount(){
        driver.findElement(buttonLoginAccount).click();
        return this;
    }

    @Step("Click burger constructor - bun")
    public String clickIngredientsBun(){
        driver.findElement(buttonIngredientsBun);
        String bunClass = driver.findElement(buttonIngredientsBun).getAttribute("class").toString();
        return bunClass;
    }

    @Step("Click burger constructor - sauce")
    public String clickIngredientsSauce(){
        driver.findElement(buttonIngredientsSauce).click();
        String sauceClass = driver.findElement(buttonIngredientsSauce).getAttribute("class").toString();
        return sauceClass;
    }

    @Step("Click burger constructor - filling")
    public String clickIngredientsFilling(){
        driver.findElement(buttonIngredientsFilling).click();
        String fillingClass = driver.findElement(buttonIngredientsFilling).getAttribute("class").toString();
        return fillingClass;
    }

    @Step("Get AccessToken from localStorage")
    public String getAccessToken() {
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        String accessToken = localStorage.getItem("accessToken");
        return accessToken;
    }

}
