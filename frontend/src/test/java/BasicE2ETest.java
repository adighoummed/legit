
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pom.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

public class BasicE2ETest {
    public static final String SHIPPING_ADDRESS = "North Carolina";
    private static Logger logger = Logger.getLogger(BasicE2ETest.class);
    protected WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        logger.debug("Starting test");
    }
    @BeforeSuite
    public void beforeSuite(){
        logger.debug("Setting property \"webdriver.chrome.driver\" to have chromedriver location");
        System.setProperty("webdriver.chrome.driver", Config.getProperties().getProperty("selenium.location"));

        logger.debug("Instantiating a chrome driver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(Config.getProperties().getProperty("selenium.arguments"));
        this.driver = new ChromeDriver(options);

//        this.driver = new ChromeDriver();

        logger.debug("Getting URL " + Config.getProperties().getProperty("site.url"));
        this.driver.get(Config.getProperties().getProperty("site.url"));
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    //Enhancement: Data providers
    @Test
    public void basicTest(){
        logger.debug("Logging in");
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.login(Config.getProperties().getProperty("default.login.email"), Config.getProperties().getProperty("default.login.password"));

        Map<Integer,Integer> productsToAdd = Map.of(
                1,1,
                2,3
        );
        logger.debug("Add the following proudcts to cart");
        productsToAdd.forEach((product, quantity) -> logger.debug(String.format("Product: %d, Quantity: %d", product, quantity)));
        HomePage homePage = new HomePage(this.driver);
        productsToAdd.forEach((product,quantity) -> {
            homePage.selectQuantityProduct(product,quantity);
            homePage.addQuantityToCartProduct(product);
        });

        logger.debug("Browsing shopping cart");
        homePage.browseShoppingCart();

        logger.debug("Validating the cart content");
        CartPage cartPage = new CartPage(this.driver);
        Map<Integer,Integer> cartProducts = cartPage.getProducts();
        logger.debug("Products in the cart:");
        cartProducts.forEach((product,quanity) -> logger.debug(String.format("Product: %d, Quantity: %d", product, quanity)));
        new SoftAssert().assertEquals(productsToAdd, cartProducts, "There are difference between expected and actual products in cart");

        logger.debug("Proceeding to checkout");
        cartPage.proceedToCheckout();

        logger.debug("Completing checkout");
        CheckoutPage checkoutPage = new CheckoutPage(this.driver);
        checkoutPage.enterShippingAddress(SHIPPING_ADDRESS);
        checkoutPage.completeCheckout();
        String orderId = checkoutPage.getOrderId();

        logger.debug("Browsing order");
        checkoutPage.browseOrders();

        logger.debug(String.format("Validating order %s", orderId));
        OrdersPage ordersPage = new OrdersPage(this.driver);
        Map<Integer,Integer> orderProducts = ordersPage.getProducts(orderId);
        logger.debug("Products in the order:");
        orderProducts.forEach((product,quanity) -> logger.debug(String.format("Product: %d, Quantity: %d", product, quanity)));
        new SoftAssert().assertEquals(productsToAdd, orderProducts, "There are difference between expected and actual products in cart");

        logger.debug("Signing out");
        ordersPage.signOut();

    }

    @AfterTest
    public void afterTest(){
        logger.debug("Ending test");
    }

    @AfterSuite
    public void afterSuite(){
        this.driver.close();
    }
}
