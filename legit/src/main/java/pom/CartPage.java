package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    @FindBy(xpath = "//button[normalize-space()='Proceed to Checkout']")
    private WebElement proceedToCheckout;

    @FindBy(id = "remove-product_id_1-product")
    private WebElement removeProduct1;
    @FindBy(id = "remove-product_id_2-product")
    private WebElement removeProduct2;
    @FindBy(id = "remove-product_id_3-product")
    private WebElement removeProduct3;
    @FindBy(id = "remove-product_id_4-product")
    private WebElement removeProduct4;
    @FindBy(id = "remove-product_id_5-product")
    private WebElement removeProduct5;

    public CartPage(WebDriver driver, WebElement removeProduct1) { super(driver);
        this.removeProduct1 = removeProduct1;
    }
}
