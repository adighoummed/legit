package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeBanner extends BasePage{
    public static final String HOME_XPATH = "//a[normalize-space()='Home']";
    public static final String SHOPPING_CART_XPATH = "//a[normalize-space()='Shopping Cart']";
    public static final String CHECKOUT_XPATH = "//a[normalize-space()='Checkout']";
    public static final String ORDERS_XPATH = "//a[normalize-space()='Orders']";
    public static final String SIGN_OUT_XPATH = "//button[normalize-space()='Sign out']";
    @FindBy(xpath = HOME_XPATH)
    protected WebElement home;
    @FindBy(xpath = SHOPPING_CART_XPATH)
    protected WebElement shoppingCart;
    @FindBy(xpath = CHECKOUT_XPATH)
    protected WebElement checkout;
    @FindBy(xpath = ORDERS_XPATH)
    protected WebElement orders;
    @FindBy(xpath = SIGN_OUT_XPATH)
    protected WebElement signOut;

    //Constructor
    public HomeBanner(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeDisplayed(){ return home.isDisplayed();}
    public boolean isShoppingCartDisplayed(){ return shoppingCart.isDisplayed();}
    public boolean isCheckoutDisplayed(){ return checkout.isDisplayed();}
    public boolean isOrdersDisplayed(){ return orders.isDisplayed();}
    public boolean isSignOutDisplayed(){ return signOut.isDisplayed();}


    public void browseHome(){ home.click();}
    public void browseShoppingCart(){ shoppingCart.click();}
    public void browseCheckout(){ checkout.click();}
    public void browseOrders(){ orders.click();}
    public void signOut(){ signOut.click();}

}