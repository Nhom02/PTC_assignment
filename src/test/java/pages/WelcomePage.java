package pages;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends BaseClass{
    @FindBy(id = "lblLoggedinSuccessfully")
    private WebElement lblLoggedinSuccessfully;

    public String getLoggedInMessage(){
        return this.lblLoggedinSuccessfully.getText();
    }
}
