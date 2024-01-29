package util;

import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductUtil {
    public static Map<Integer, Integer> getProducts(List<WebElement> productsList){
        Map<Integer, Integer> productsMap = HashMap.newHashMap(productsList.size());

        Pattern pattern = Pattern.compile("Product (\\d+) -.*?Quantity: (\\d+)");
        productsList.stream().map(WebElement::getText).forEach(
                productString -> {
                    Matcher matcher = pattern.matcher(productString);
                    matcher.find();
                    productsMap.put(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
                }
        );

        return productsMap;
    }
}
