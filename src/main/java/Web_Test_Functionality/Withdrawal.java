package Web_Test_Functionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Withdrawal {
    private WebDriver driver;

    public Withdrawal(WebDriver driver)
    {
        this.driver=driver;
    }
    @FindBy(xpath = "//button[contains(.,'Withdrawl')]")
    WebElement Withdrawal;

    @FindBy(xpath = "//input[contains(@type,'number')]")
    WebElement Withdrawal_Amount;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Withdraw')]")
    WebElement Withdraw_Button;

    @FindBy(xpath = "//input[contains(@type,'number')]")
    WebElement Balance;

    public void Withdrawal()
    {
        WebDriverWait withdraw=new WebDriverWait(driver,40);
        withdraw.until(ExpectedConditions.visibilityOf(Withdrawal));
        Withdrawal.click();
    }
    public void Capture_Withdrawal_Amount(String _amount)
    {
        WebDriverWait withdraw=new WebDriverWait(driver,40);
        withdraw.until(ExpectedConditions.visibilityOf(Withdrawal_Amount));
        Withdrawal_Amount.sendKeys(_amount);
    }
    public void  Click_Withdraw_Button()
    {
        WebDriverWait withdraw=new WebDriverWait(driver,40);
        withdraw.until(ExpectedConditions.visibilityOf(Withdraw_Button));
       Withdraw_Button.click();
    }
    public void  Verify_Balance()
    {
        WebDriverWait withdraw=new WebDriverWait(driver,40);
        withdraw.until(ExpectedConditions.visibilityOf(Balance));
        Assert.assertEquals(Balance.getText(),"");
    }
}
