package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = about:blank
public class LoginPage extends BasePage{
    @FindBy(id = "amplify-id-:r1:")
    private WebElement email;
    @FindBy(id = "amplify-id-:r4:")
    private WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signInButton;
    @FindBy(xpath = "//div[@class='amplify-alert__body']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void enterEmail(String email){
        this.email.sendKeys(email);
    }
    public void enterPassword(String password){
        this.password.sendKeys(password);
    }
    public void login(){
        this.signInButton.click();
    }
    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        login();
    }
    public boolean isErrorMessageDisplayed(){
        return this.errorMessage.isDisplayed();
    }
    public String getErrorMessageText(){
        return this.errorMessage.getTagName();
    }
}