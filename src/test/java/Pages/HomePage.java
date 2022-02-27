package Pages;

import com.codeborne.selenide.SelenideElement;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class HomePage {

    SelenideElement changePassword = $(byId("id1"));
    SelenideElement createNewsDoc = $(byId("id1"));
    SelenideElement createEventDoc = $(byId("id1"));
    SelenideElement createBlogDoc = $(byId("id1"));
    SelenideElement createProductDoc = $(byId("id1"));
    SelenideElement toggleExpandLeftBar = $(byClassName("menu-trigger"));
    SelenideElement userAccountIcon = $(byClassName("mat-tooltip-trigger"));
    SelenideElement logoutButton = $(byClassName("qa-usersettings-logout"));

    public Object navigateToPage(String page){
        $$(".ng-tns-c19-4 .mat-ripple").find(text(page)).click();
        switch (page){
            case "Home":
                return  new HomePage();
            case "ExperienceManager":
                return new ExperienceManagerPage();
            case "Projects":
                return new ProjectsPage();
            case "Content":
                return new ContentPage();
            case "DocumentSearch":
                return new DocumentSearchPage();
            case "ContentReports":
                return new ContentReportsPage();
            case "ContentAudiences":
                return new ContentAudiencesPage();
            case "Setup":
                return new SetupPage();
        }
        return null;
    }

    public void verifyHomeIsVisible(){
        $("mat-ripple").shouldHave(text("Home"));
    }

    public LoginPage logOut(){
        $(toggleExpandLeftBar).click();
        $(userAccountIcon).click();
        $(logoutButton).click();
        return new LoginPage();
    }
}