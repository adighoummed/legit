package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.ProductUtil;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OrdersPage extends HomeBanner{
    public static final String ORDERS_XPATH = "//div[@id='root']/div/div/div";
    public static final String ORDER_PRODUCTS_XPATH = "/ul/li";
    @FindBy(xpath = ORDERS_XPATH)
    private List<WebElement> orders;

    public OrdersPage(WebDriver driver){
        super(driver);
    }

    private List<WebElement> getOrder(String orderId){
        Optional<WebElement> orderElement = orders.stream().filter(e -> e.findElement(By.tagName("h2")).getText().contains(orderId)).findAny();
        if (orderElement.isEmpty()){
            //todo logger
            throw new RuntimeException("Order " + orderId + " was not found!");
        }
        return orderElement.get().findElements(By.xpath(ORDER_PRODUCTS_XPATH));
    }

    public Map<Integer,Integer> getProducts(String orderId){
        return ProductUtil.getProducts(getOrder(orderId));
    }
}
