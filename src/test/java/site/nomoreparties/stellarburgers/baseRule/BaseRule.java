package site.nomoreparties.stellarburgers.baseRule;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import site.nomoreparties.stellarburgers.constantsApi.ApiEndPoints;
import java.util.concurrent.TimeUnit;

public class BaseRule {
    public static final String PATH_CHROMEDRIVER_EXE =
            "C:\\Yaprakticum\\WebDriver\\bin\\chromedriver-win64\\chromedriver.exe";
    public static final String PATH_YANDEXDRIVER_EXE =
            "C:\\Yaprakticum\\WebDriver\\bin\\yandexdriver\\yandexdriver.exe";
    public WebDriver driver;

    @Before
    public void setBaseRule() {

        if ("Yandex".equals(System.getProperty("browser")))
            setUpYandex();
        else
            setUpChrome();

        driver.manage().window().maximize();
        WebDriverManager.chromedriver().setup();
        driver.get(ApiEndPoints.BASE_URL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private void setUpChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", PATH_CHROMEDRIVER_EXE);
        driver = new ChromeDriver(options);
    }


    public void setUpYandex() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", PATH_YANDEXDRIVER_EXE);
        driver = new ChromeDriver(options);

    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
