package Pages;

import com.codeborne.selenide.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class LoginPage {

    //first style selector
    SelenideElement usernameField = $(byId("id1"));
    SelenideElement passwordField = $(byId("id2"));
    SelenideElement languageDropDownButton = $(byId("id3"));
    SelenideElement loginButton = $(byId("id9"));

    //second style selector
    //    SelenideElement usernameField = $(By.id("id1"));
    //    SelenideElement passwordField = $(By.id("id2"));
    //    SelenideElement languageDropDownButton = $(By.id("id3"));
    //    SelenideElement loginButton = $(By.id("id9"));


    public void login(String username,String password,String languageType){
        usernameField.val(username);
        passwordField.val(password);
        languageDropDownButton.selectOption(languageType);
        loginButton.click();
    }
}


