package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends HomeBanner{
    @FindBy(id = "shipping-address-text")
    private WebElement shippingAddressText;

    @FindBy(id = "checkout-button")
    private WebElement checkoutButton;


    public CheckoutPage(WebDriver driver){ super(driver); }


}
