package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import org.apache.log4j.Logger;

public class CheckoutPage extends HomeBanner{
    private static Logger logger = Logger.getLogger(CheckoutPage.class);
    public static final String SHIPPING_ADDRESS_TEXT_ID = "shipping-address-text";
    public static final String CHECKOUT_BUTTON_ID = "checkout-button";
    @FindBy(id = SHIPPING_ADDRESS_TEXT_ID)
    private WebElement shippingAddressText;

    @FindBy(id = CHECKOUT_BUTTON_ID)
    private WebElement checkoutButton;

    private String orderId;


    public CheckoutPage(WebDriver driver){ super(driver); }

    public void enterShippingAddress(String shippingAddress){
        logger.debug("Shipping Address: " + shippingAddress);
        this.shippingAddressText.sendKeys(shippingAddress);
    }

    public void completeCheckout(){
        logger.debug("Clicking the \"Complete Checkout\" button");
        this.checkoutButton.click();
        getOrderIdFromAlert();
    }

    private void getOrderIdFromAlert(){
        logger.debug("Getting order ID from the alert");
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertMessage= driver.switchTo().alert().getText();
        this.orderId = Arrays.stream(alertMessage.split(" ")).toList().getLast();
        logger.debug("Order ID: " + this.orderId);
        alert.accept();
    }

    public String getOrderId(){
        return orderId;
    }

}
