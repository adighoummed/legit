package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends HomeBanner{
    @FindBy(id = "product_id_1-product-quantity-select")
    private WebElement selectQuantityProduct1;

    @FindBy(xpath = "//li[1]//button[1]")
    private WebElement addToCartProduct1;

    @FindBy(id = "product_id_2-product-quantity-select")
    private WebElement selectQuantityProduct2;

    @FindBy(xpath = "//li[2]//button[1]")
    private WebElement addToCartProduct2;

    @FindBy(id = "product_id_3-product-quantity-select")
    private WebElement selectQuantityProduct3;

    @FindBy(xpath = "//li[3]//button[1]")
    private WebElement addToCartProduct3;

    @FindBy(id = "product_id_4-product-quantity-select")
    private WebElement selectQuantityProduct4;

    @FindBy(xpath = "//li[4]//button[1]")
    private WebElement addToCartProduct4;

    @FindBy(id = "product_id_5-product-quantity-select")
    private WebElement selectQuantityProduct5;

    @FindBy(xpath = "//li[5]//button[1]")
    private WebElement addToCartProduct5;

    //Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

}