package steps;

import Pages.HomePage;
import Pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static com.codeborne.selenide.Selenide.*;

public class LoginSteps {

    private LoginPage loginPage;
    private HomePage homePage;

    @Before
    public void setup(){
        open("https://cms.demo.onehippo.com/");
    }

    @Test
    public void loginUsingCredentials(String username, String password,String language) {
        loginPage.login(username,password,language);
        homePage.verifyHomeIsVisible();
    }

    public void verifyIAmLoggedInAs(String roleType) {
        switch(roleType){
            case "Admin":
                //code here
                break;
            case "author":
                //code here
                break;
            case "editor":
                //code here
                break;
        }
    }

    @After
    public void close(){
        //session ends automatically with selenide, if we were using selenium then we have to close the browser in order to start the new session
    }

}
