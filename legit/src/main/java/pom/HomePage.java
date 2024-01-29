package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Optional;


public class HomePage extends HomeBanner{
    public static final String BUTTON_TEXT_ADD_TO_CART = "//button[text()='Add to Cart']";
    public static final String SELECT_ELEMENTS_XPATH = "//select";
    public static final String PRODUCT_ID_PRODUCT_QUANTITY_SELECT_TEMPLATE = "product_id_%d-product-quantity-select";
    public static final String PRODUCT_ID_PRODUCT_QUANTITY_OPTION_TEMPLATE = "product_id_%d-product-quantity-%d-option";
    @FindBy(xpath = SELECT_ELEMENTS_XPATH)
    List<WebElement> selectElements;

    @FindBy(xpath = BUTTON_TEXT_ADD_TO_CART)
    List<WebElement> addToCartButtons;
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void selectQuantityProduct(int product, int quantity){
        String productSelectId = String.format(PRODUCT_ID_PRODUCT_QUANTITY_SELECT_TEMPLATE, product);
        Optional<WebElement> productSelect = selectElements.stream().filter(e -> e.getAttribute("id").contains(productSelectId)).findAny();

        if (productSelect.isEmpty()){
            //todo logger
            throw new IllegalArgumentException(String.format("Product %d was not found!", product));
        }
        WebElement selectElement = productSelect.get();

        String quantityId = String.format(PRODUCT_ID_PRODUCT_QUANTITY_OPTION_TEMPLATE, product, quantity);
        if (selectElement.findElements(By.id(quantityId)).isEmpty()){
            //todo logger
            throw new IllegalArgumentException("Quantity \"" + quantity + "\" was not found!");
        }
        else{
            Select quantities = new Select(selectElement);
            quantities.selectByIndex(quantity - 1);
        }
    }

    public void addQuantityToCartProduct(int product){
        addToCartButtons.get(product - 1).click();
    }

}