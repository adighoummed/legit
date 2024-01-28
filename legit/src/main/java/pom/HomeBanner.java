package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomeBanner extends BasePage{
    @FindBy(xpath = "//a[normalize-space()='Home']")
    protected WebElement home;
    @FindBy(xpath = "//a[normalize-space()='Shopping Cart']")
    protected WebElement shoppingCart;

    @FindBy(xpath = "//a[normalize-space()='Checkout']")
    protected WebElement checkOut;
    @FindBy(xpath = "//a[normalize-space()='Orders']")
    protected WebElement orders;
    @FindBy(xpath = "//button[normalize-space()='Sign out']")
    protected WebElement signOut;

    //Constructor
    public HomeBanner(WebDriver driver) {
        super(driver);
    }

}