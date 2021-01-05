package Web_Test_Functionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
    private WebDriver driver;

    public Home(WebDriver driver)
    {
        this.driver=driver;
    }
    @FindBy(xpath = "//button[@class='btn home'][contains(.,'Home')]")
    WebElement Home;

    public void Click_Home()
    {
        WebDriverWait logout=new WebDriverWait(driver,40);
        logout.until(ExpectedConditions.visibilityOf(Home));
        Home.click();
    }
}
