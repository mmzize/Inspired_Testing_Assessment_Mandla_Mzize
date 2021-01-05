package Web_Test_Functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Accept_Quote_And_Buy_Cover {
    private WebDriver driver;

    public Accept_Quote_And_Buy_Cover(WebDriver driver)
    {
        this.driver=driver;
    }
    public void Scroll_and_Click_Accept_And_Buy_Cover() throws InterruptedException, AWTException {

        TimeUnit.SECONDS.sleep(5);
        Actions dragger = new Actions(driver);
        WebElement draggablePartOfScrollbar = driver.findElement(By.xpath("//*[@id=\"cdk-step-content-0-3\"]/app-review-quote/div/div/div[5]/div/div/div[3]/button"));

        // drag downwards
        int numberOfPixelsToDragTheScrollbarDown = 10;
        for (int i = 100; i < 200; i = i + numberOfPixelsToDragTheScrollbarDown) {
            try {
                // this causes a gradual drag of the scroll bar, 10 units at a time
                dragger.moveToElement(draggablePartOfScrollbar).clickAndHold().moveByOffset(0, numberOfPixelsToDragTheScrollbarDown).release().perform();
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e1) {
            }
        }
    }
}
