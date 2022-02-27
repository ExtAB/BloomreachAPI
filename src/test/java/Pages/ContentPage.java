package Pages;

import com.codeborne.selenide.SelenideElement;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class ContentPage {

    SelenideElement searchField = $(byId("ided"));
    List<SelenideElement> documentList = $$(byId("id1d7"));

    public void search(String text){
    $(searchField).val(text).pressEnter();
    }

    public SelenideElement getDocumentSearched(String documentName){
        return documentList.stream().filter(docName -> docName.getText().equalsIgnoreCase(documentName)).findAny().orElseThrow();
    }

    //map documents to make reading easier or selecting based on name/type/last modified
    //more methods.... object to map below
    ContentData data;
}