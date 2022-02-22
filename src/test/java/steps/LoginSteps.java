package steps;

import Pages.LoginPage;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class LoginSteps {

    private LoginPage loginPage;

    @Test
    public void loginUsingCredentials(String username, String password,String language) {
        open("https://cms.demo.onehippo.com/");
        loginPage.login(username,password,language);
    }

    public void verifyIAmLoggedInAs(String roleType) {
        switch(roleType){
            case "Admin":
                //code here
                break;
            case "author":
                //code here
                break;
            case "zomething":
                //code here
                break;
        }
    }
}
