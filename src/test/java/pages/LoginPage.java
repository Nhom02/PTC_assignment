package pages;
import base.BaseClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{

    @FindBy(id = "txtEmail")
    private WebElement txtEmail;

    @FindBy(id = "lblEmailErr")
    private WebElement lblEmailErr;

    @FindBy(id = "txtPassword")
    private WebElement txtPassword;

    @FindBy(id = "lblPasswordErr")
    private WebElement lblPasswordErr;

    @FindBy(id = "btnLogin")
    private WebElement btnLogin;

    @FindBy(id = "lblLoggedinSuccessfully")
    private WebElement lblLoggedinSuccessfully;

    public LoginPage() {

        PageFactory.initElements(driver, this);
    }

    public void goToPage() {
        driver.get("https://login.com");
    }
    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clickLogin() {
        this.waitFor(btnLogin);
        btnLogin.click();
    }

    public void inputEmail(String email) {
        this.txtEmail.sendKeys(email);
    }

    public void inputPassword(String password) {
        this.txtPassword.sendKeys(password);
    }

    public String getEmailError(){
        return this.lblEmailErr.getText();
    }

    public String getPasswordError(){
        return this.lblPasswordErr.getText();
    }

    public void doLogin(String email, String password) {
        this.inputEmail(email);
        this.inputPassword(password);
        this.clickLogin();
    }
}
