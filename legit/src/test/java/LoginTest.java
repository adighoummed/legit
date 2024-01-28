
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pom.LoginPage;

public class LoginTest {
    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){
        System.setProperty("webdriver.chrome.driver", Config.getProperties().getProperty("selenium.location"));

        ChromeOptions options = new ChromeOptions();
        options.addArguments(Config.getProperties().getProperty("selenium.arguments"));
        this.driver = new ChromeDriver(options);


//        this.driver = new ChromeDriver();

        this.driver.get(Config.getProperties().getProperty("site.url"));
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("BasicTest::BeforeClass");
    }

    @Test
    public void basicTest(){
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.login(Config.getProperties().getProperty("default.login.email"), Config.getProperties().getProperty("default.login.password"));
    }

    @AfterClass
    public void afterClass(){
        System.out.println("BasicTest::AfterClass");
    }

    @AfterSuite
    public void afterSuite(){
        this.driver.close();
    }
}
