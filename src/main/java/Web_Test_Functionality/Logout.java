package Web_Test_Functionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logout {
    private WebDriver driver;

    public Logout(WebDriver driver)
    {
        this.driver=driver;
    }
    @FindBy(xpath = "//button[contains(.,'Logout')]")
    WebElement Logout;

    public void Logout()
    {
        WebDriverWait logout=new WebDriverWait(driver,40);
        logout.until(ExpectedConditions.visibilityOf(Logout));
        Logout.click();
    }
}
