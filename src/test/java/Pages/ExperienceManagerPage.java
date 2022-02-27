package Pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.Objects;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class ExperienceManagerPage {

    SelenideElement createChannel = $(byClassName("x-btn"));
    SelenideElement createNewsDoc = $(byId("id1"));
    List<SelenideElement> mobileProducts = $$(byId("channel-group odd"));
    List<SelenideElement> websiteProducts = $$(byId("channel-group even"));

    public void selectMobileProduct(String mobileProductName){
        $(Objects.requireNonNull(mobileProducts.stream().filter(productName ->
                productName.getText().equalsIgnoreCase(mobileProductName)).findAny().orElseThrow())).click();
    }

    public void selectWebProduct(String webProductName){
        $(Objects.requireNonNull(websiteProducts.stream().filter(productName ->
                productName.getText().equalsIgnoreCase(webProductName)).findAny().orElseThrow())).click();
    }
}