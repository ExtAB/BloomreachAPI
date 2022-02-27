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

    SelenideElement usernameField = $(byId("id1"));
    SelenideElement passwordField = $(byId("id2"));
    SelenideElement languageDropDownButton = $(byId("id3"));
    SelenideElement loginButton = $(byId("id9"));


    public HomePage login(String username,String password,String languageType){
        usernameField.val(username);
        passwordField.val(password);
        languageDropDownButton.selectOption(languageType);
        loginButton.click();
        return new HomePage();
    }
}


