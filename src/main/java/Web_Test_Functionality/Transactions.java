package Web_Test_Functionality;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Transactions {

    private WebDriver driver;

    public Transactions(WebDriver driver)
    {
        this.driver=driver;
    }
    @FindBy (xpath = "//button[contains(.,'Transactions')]")
    WebElement Transactions;

    @FindBy(xpath = "(//td[contains(@class,'ng-binding')])[8]")
    WebElement Transaction_History;

    @FindBy(xpath = "(//td[@class='ng-binding'])[11]")
    WebElement Transaction_History_Withdrawal;

    @FindBy(xpath = "(//td[contains(@class,'ng-binding')])[14]")
    WebElement Transaction_History_Json;

    @FindBy(xpath = "(//td[@class='ng-binding'])[17]")
    WebElement Transaction_History_Withdrawal_Json;

    @FindBy(xpath = "//button[@class='btn'][contains(.,'Back')]")
    WebElement Back;

    public void Click_Transactions() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        WebDriverWait trans=new WebDriverWait(driver,40);
        trans.until(ExpectedConditions.visibilityOf(Transactions));
        Transactions.click();
    }
    public void Validate_Transaction()
    {
        WebDriverWait trans=new WebDriverWait(driver,40);
        trans.until(ExpectedConditions.visibilityOf(Transaction_History));
        Assert.assertEquals(Transaction_History.getText(),"31459");
    }
    public void Validate_Transaction_Withdraw()
    {
        WebDriverWait trans=new WebDriverWait(driver,40);
        trans.until(ExpectedConditions.visibilityOf(Transaction_History));
        Assert.assertEquals(Transaction_History_Withdrawal.getText(),"31459");
    }
    public void Validate_Transaction_Withdraw_Json()
    {
        WebDriverWait trans=new WebDriverWait(driver,40);
        trans.until(ExpectedConditions.visibilityOf(Transaction_History));
        Assert.assertEquals(Transaction_History_Withdrawal_Json.getText(),"31459");
    }
    public void Click_Back()
    {
        WebDriverWait back=new WebDriverWait(driver,40);
        back.until(ExpectedConditions.visibilityOf(Back));
        Back.click();
    }
}
