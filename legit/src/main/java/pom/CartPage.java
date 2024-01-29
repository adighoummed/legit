package pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.ProductUtil;

public class CartPage extends BasePage{
    private static Logger logger =Logger.getLogger(CartPage.class);
    public static final String PROCEED_TO_CHECKOUT_BUTTON_XPATH = "//button[normalize-space()='Proceed to Checkout']";
    public static final String CART_ITEMS_XPATH = "//div[@id='root']/div/div/div/ul/li";
    @FindBy(xpath = PROCEED_TO_CHECKOUT_BUTTON_XPATH)
    private WebElement proceedToCheckout;
    @FindBy(xpath = CART_ITEMS_XPATH)
    private List<WebElement> cartItems;

    public CartPage(WebDriver driver) { super(driver); }

    public void proceedToCheckout(){
        this.proceedToCheckout.click();
    }
    public Map<Integer, Integer> getProducts(){
        logger.debug("Getting products in the cart");
        return ProductUtil.getProducts(cartItems);
    }
    private Optional<WebElement> getProductInCart(int product){
        logger.debug("Trying to find product " + product + " in cart");
        return cartItems.stream().filter(item -> item.getText().contains("Product " + product)).findAny();
    }
    public boolean isProductInCart(int product){
        return getProductInCart(product).isPresent();
    }

    public int getQuantityOfProductInCart(int product){
        Optional<WebElement> item = getProductInCart(product);
        if (item.isPresent()){
            String quantityString = item.get().getText();
            return Integer.parseInt(quantityString.substring(quantityString.indexOf(' ') + 1, quantityString.length() - 1));
        }
        else{
            //todo logger
            //todo special exception
            throw new RuntimeException();
        }
    }


}
