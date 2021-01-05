package API_Tests;

import API_Test_Functionality.UsersAPI;
import org.testng.annotations.Test;

import java.io.IOException;

public class User_API_Tests {
    public User_API_Tests()
    {}
    @Test
    public void Post_User_And_Verify_Response_Test() throws IOException {
        UsersAPI usersAPI =new UsersAPI();
        usersAPI.Post_User_And_Verify_Response();

    }
    @Test(priority = 1)
    public void Get_Single_User_And_Verify_Test() throws IOException {
        UsersAPI usersAPI=new UsersAPI();
        usersAPI.Get_Single_User_And_Verify();
    }
    @Test(priority = 2)
    public void Get_Ten_Users_and_Verify_Test() throws IOException {
        UsersAPI usersAPI=new UsersAPI();
        usersAPI.GetTen();
    }
}
