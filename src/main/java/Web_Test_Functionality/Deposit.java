package Web_Test_Functionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Deposit {

    private WebDriver driver;

    public Deposit(WebDriver driver)
    {
        this.driver=driver;
    }
    @FindBy(xpath = "//button[@ng-class='btnClass2'][contains(.,'Deposit')]")
    WebElement Deposit_Button;

    @FindBy(xpath = "//input[contains(@type,'number')]")
    WebElement Amount;

    @FindBy(xpath = "//select[contains(@ng-hide,'noAccount')]")
    WebElement AccountNo;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Deposit')]")
    WebElement Deposit;

    @FindBy(xpath = "//span[@class='error ng-binding'][contains(.,'Deposit Successful')]")
    WebElement SuccessMSG;

    public void Click_Deposit_Button()
    {
        WebDriverWait name=new WebDriverWait(driver,40);
        name.until(ExpectedConditions.visibilityOf(Deposit_Button));
        Deposit_Button.click();
    }
    public void Select_Account(String _accNo)
    {
        WebDriverWait name=new WebDriverWait(driver,40);
        name.until(ExpectedConditions.visibilityOf(Deposit_Button));
        Select accNo=new Select(AccountNo);
        accNo.selectByVisibleText(_accNo);
    }
    public void Capture_Amount(String _amount)
    {
        WebDriverWait amount=new WebDriverWait(driver,40);
        amount.until(ExpectedConditions.visibilityOf(Amount));
        Amount.sendKeys(_amount);
    }
    public void Deposit()
    {
        WebDriverWait name=new WebDriverWait(driver,40);
        name.until(ExpectedConditions.visibilityOf(Deposit));
        Deposit.click();
    }
    public void Verify_Deposit_Was_Successful()
    {
        WebDriverWait msg=new WebDriverWait(driver,40);
        msg.until(ExpectedConditions.visibilityOf(SuccessMSG));
        Assert.assertTrue(SuccessMSG.isDisplayed());
    }
}
