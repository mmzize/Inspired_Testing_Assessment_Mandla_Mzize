package Web_Test_Functionality;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import java.io.*;

public class ReadJson {
    private WebDriver driver;

    public ReadJson(WebDriver driver)
    {
        this.driver=driver;
    }
    public static String dir = System.getProperty("user.dir");

    public void ReadJson() throws IOException, ParseException {
        JSONParser parser = new JSONParser();

        Object obj = parser.parse(new FileReader(dir + "\\src\\main\\java\\Test_Data\\Data.json"));

        JSONObject jsonObject = (JSONObject) obj;

        JSONArray _customer = (JSONArray) jsonObject.get("Customer");
        JSONArray _account = (JSONArray) jsonObject.get("Account");
        JSONArray _amount = (JSONArray) jsonObject.get("Amount");

        String Customer=_customer.toJSONString().replace("[","").replace("]","").replace("\"","");
        String Account=_account.toJSONString().replace("[","").replace("]","").replace("\"","");
        String Amount=_amount.toJSONString().replace("[","").replace("]","").replace("\"","");
        System.out.println(Customer);
        System.out.println(Account);
        System.out.println(Amount);
    }
}
