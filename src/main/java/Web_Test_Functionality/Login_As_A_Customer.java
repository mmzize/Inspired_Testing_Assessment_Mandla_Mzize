package Web_Test_Functionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_As_A_Customer {

    private WebDriver driver;

    public Login_As_A_Customer(WebDriver driver)
    {
        this.driver=driver;
    }
    @FindBy(xpath = "//button[contains(.,'Customer Login')]")
    WebElement CustomerLogin;
    @FindBy(xpath = "//select[contains(@id,'userSelect')]")
    WebElement Name;
    @FindBy(xpath = "//button[contains(.,'Login')]")
    WebElement Login_Button;

    public void Click_Login_As_A_Customer()
    {
        WebDriverWait login=new WebDriverWait(driver,40);
        login.until(ExpectedConditions.visibilityOf(CustomerLogin));
        CustomerLogin.click();
    }
    public void Select_Name(String _name)
    {
        WebDriverWait name=new WebDriverWait(driver,40);
        name.until(ExpectedConditions.visibilityOf(Name));
        Select FName=new Select(Name);
        FName.selectByVisibleText(_name);
    }
    public void Click_Login_Button()
    {
        WebDriverWait login_btn=new WebDriverWait(driver,40);
        login_btn.until(ExpectedConditions.visibilityOf(Login_Button));
        Login_Button.click();
    }
}
