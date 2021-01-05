package Web_Tests;

import Startup.Setup_Class;
import Web_Test_Functionality.*;
import Test_Helpers.Report;
import com.aventstack.extentreports.Status;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class Online_Banking_Tests extends Report {

    public static String dir = System.getProperty("user.dir");
    private WebDriver driver = Setup_Class.startBrowserOfChoice("http://www.way2automation.com/angularjs-protractor/banking/#/login", "chrome");
    public Online_Banking_Tests() {
    }
    @Test(priority = 1, description = "Deposit On Customers First Account")
    public void Tests1()
    {
        test = extent.createTest("Tests1");
        Login_As_A_Customer login_as_a_customer = PageFactory.initElements(driver, Login_As_A_Customer.class);
        Deposit deposit= PageFactory.initElements(driver,Deposit.class);
        Logout logout=PageFactory.initElements(driver, Logout.class);
        test.log(Status.PASS, "Click Login As A Customer");
        login_as_a_customer.Click_Login_As_A_Customer();
        test.log(Status.PASS, "Select Name To Login");
        login_as_a_customer.Select_Name("Harry Potter");
        test.log(Status.PASS, "Click Login Button");
        login_as_a_customer.Click_Login_Button();
        test.log(Status.PASS, "Click Deposit Button");
        deposit.Click_Deposit_Button();
        test.log(Status.PASS, "Enter Deposit Amount");
        deposit.Capture_Amount("1500");
        test.log(Status.PASS, "Click Deposit");
        deposit.Deposit();
        test.log(Status.PASS, "Verify If Deposit Was Successful");
        deposit.Verify_Deposit_Was_Successful();
        test.log(Status.PASS, "Click Logout Button");
        logout.Logout();
    }
    @Test(priority = 2,description = "Deposit On All Accounts")
    public void Tests2()
    {
        Login_As_A_Customer login_as_a_customer = PageFactory.initElements(driver, Login_As_A_Customer.class);
        Deposit deposit= PageFactory.initElements(driver,Deposit.class);
        Logout logout=PageFactory.initElements(driver, Logout.class);
        Home home=PageFactory.initElements(driver, Home.class);
        test = extent.createTest("Tests2");
        test.log(Status.PASS, "Click Home Button");
        home.Click_Home();
        test.log(Status.PASS, "Click Login Button");
        login_as_a_customer.Click_Login_As_A_Customer();
        test.log(Status.PASS, "Select Name To Login With");
        login_as_a_customer.Select_Name("Harry Potter");
        test.log(Status.PASS, "Click Login Button");
        login_as_a_customer.Click_Login_Button();
        test.log(Status.PASS, "Click Deposit Button");
        deposit.Click_Deposit_Button();
        test.log(Status.PASS, "Select Account Number");
        deposit.Select_Account("1004");
        test.log(Status.PASS, "Enter Amount To Deposit");
        deposit.Capture_Amount("1500");
        test.log(Status.PASS, "Click Deposit Button");
        deposit.Deposit();
        test.log(Status.PASS, "Verify Deposit Was Successful");
        deposit.Verify_Deposit_Was_Successful();
        test.log(Status.PASS, "Select Account");
        deposit.Select_Account("1005");
        test.log(Status.PASS, "Enter Amount To Deposit");
        deposit.Capture_Amount("1500");
        test.log(Status.PASS, "Click Deposit Button");
        deposit.Deposit();
        test.log(Status.PASS, "Verify Deposit Was Successful");
        deposit.Verify_Deposit_Was_Successful();
        test.log(Status.PASS, "Enter Amount To Deposit");
        deposit.Select_Account("1006");
        test.log(Status.PASS, "Enter Amount To Deposit");
        deposit.Capture_Amount("1500");
        test.log(Status.PASS, "Click Deposit");
        deposit.Deposit();
        test.log(Status.PASS, "Verify Deposit Was Successful");
        deposit.Verify_Deposit_Was_Successful();
        test.log(Status.PASS, "Click Logout Button");
        logout.Logout();
    }
    @Test(priority = 3,description = "Deposit And Withdraw")
    public void Tests3() throws InterruptedException {
        Login_As_A_Customer login_as_a_customer = PageFactory.initElements(driver, Login_As_A_Customer.class);
        Deposit deposit = PageFactory.initElements(driver, Deposit.class);
        Logout logout = PageFactory.initElements(driver, Logout.class);
        Home home = PageFactory.initElements(driver, Home.class);
        Transactions transactions=PageFactory.initElements(driver,Transactions.class);
        Withdrawal withdrawal=PageFactory.initElements(driver,Withdrawal.class);
        test = extent.createTest("Tests3");
        test.log(Status.PASS, "Click Home Button");
        home.Click_Home();
        test.log(Status.PASS, "Click Login As A Customer");
        login_as_a_customer.Click_Login_As_A_Customer();
        test.log(Status.PASS, "Select Name To Login");
        login_as_a_customer.Select_Name("Harry Potter");
        test.log(Status.PASS, "Click Login Button");
        login_as_a_customer.Click_Login_Button();
        test.log(Status.PASS, "Click Deposit Button");
        deposit.Click_Deposit_Button();
        test.log(Status.PASS, "Select Account To Deposit");
        deposit.Select_Account("1004");
        test.log(Status.PASS, "Enter Amount To Deposit");
        deposit.Capture_Amount("31459");
        test.log(Status.PASS, "Click Deposit Button");
        deposit.Deposit();
        test.log(Status.PASS, "Verify Deposit Was Successful");
        deposit.Verify_Deposit_Was_Successful();
        test.log(Status.PASS, "Click Transactions");
        transactions.Click_Transactions();
        test.log(Status.PASS, "Validate Transactions Was Successful");
        transactions.Validate_Transaction();
        test.log(Status.PASS, "Click Back Button");
        transactions.Click_Back();
        test.log(Status.PASS, "Click Withdraw");
        withdrawal.Withdrawal();
        test.log(Status.PASS, "Enter Amount To Withdraw");
        withdrawal.Capture_Withdrawal_Amount("31459");
        test.log(Status.PASS, "Click Withdraw Button");
        withdrawal.Click_Withdraw_Button();
        test.log(Status.PASS, "Verify Balance");
        withdrawal.Verify_Balance();
        test.log(Status.PASS, "Click Transactions");
        transactions.Click_Transactions();
        test.log(Status.PASS, "Validate Transactions ");
        transactions.Validate_Transaction_Withdraw();
        test.log(Status.PASS, "Click Logout Button");
        logout.Logout();
    }
    @Test(priority = 4,description = "Read JSON File")
    public void Test4() throws IOException, ParseException, InterruptedException {

        Login_As_A_Customer login_as_a_customer = PageFactory.initElements(driver, Login_As_A_Customer.class);
        Deposit deposit = PageFactory.initElements(driver, Deposit.class);
        Logout logout = PageFactory.initElements(driver, Logout.class);
        Home home = PageFactory.initElements(driver, Home.class);
        Transactions transactions=PageFactory.initElements(driver,Transactions.class);
        Withdrawal withdrawal=PageFactory.initElements(driver,Withdrawal.class);

        ///////////////READ JSON FILE AND FORMAT DATA////////
        JSONParser parser = new JSONParser();

        Object obj = parser.parse(new FileReader(dir + "\\src\\main\\java\\Test_Data\\Data.json"));

        JSONObject jsonObject = (JSONObject) obj;

        JSONArray _customer = (JSONArray) jsonObject.get("Customer");
        JSONArray _account = (JSONArray) jsonObject.get("Account");
        JSONArray _amount = (JSONArray) jsonObject.get("Amount");

        String Customer=_customer.toJSONString().replace("[","").replace("]","").replace("\"","");
        String Account=_account.toJSONString().replace("[","").replace("]","").replace("\"","");
        String Amount=_amount.toJSONString().replace("[","").replace("]","").replace("\"","");

        //////////////
        test = extent.createTest("Tests4");
        test.log(Status.PASS, "Click Home Button");
        home.Click_Home();
        test.log(Status.PASS, "Login As A Customer");
        login_as_a_customer.Click_Login_As_A_Customer();
        test.log(Status.PASS, "Select Name To Login");
        login_as_a_customer.Select_Name(Customer);
        test.log(Status.PASS, "Click Login Button");
        login_as_a_customer.Click_Login_Button();
        test.log(Status.PASS, "Click Deposit Button");
        deposit.Click_Deposit_Button();
        test.log(Status.PASS, "Select Account To Deposit");
        deposit.Select_Account(Account);
        test.log(Status.PASS, "Capture Amount");
        deposit.Capture_Amount(Amount);
        test.log(Status.PASS, "Click Deposit");
        deposit.Deposit();
        test.log(Status.PASS, "Verify Deposit Was Successful");
        deposit.Verify_Deposit_Was_Successful();
        test.log(Status.PASS, "Click Transactions");
        transactions.Click_Transactions();
        test.log(Status.PASS, "Validate Transactions");
        transactions.Validate_Transaction();
        test.log(Status.PASS, "Click Back");
        transactions.Click_Back();
        test.log(Status.PASS, "Click Withdrawal");
        withdrawal.Withdrawal();
        test.log(Status.PASS, "Enter Amount To Withdraw");
        withdrawal.Capture_Withdrawal_Amount(Amount);
        test.log(Status.PASS, "Click Withdraw Button");
        withdrawal.Click_Withdraw_Button();
        test.log(Status.PASS, "Verify Balance");
        withdrawal.Verify_Balance();
        test.log(Status.PASS, "Click Transactions");
        transactions.Click_Transactions();
        test.log(Status.PASS, "Validate Transactions");
        transactions.Validate_Transaction_Withdraw_Json();
        test.log(Status.PASS, "Click Logout Button");
        logout.Logout();
    }
    @AfterSuite
    public void Quit()
    {
        driver.quit();
    }
}
