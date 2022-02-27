package Pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class DocumentSearchPage {
    SelenideElement searchPerformAction = $(byClassName("hippo-advanced-search-searchbox-input"));
    SelenideElement searchButton = $(byClassName("btn-br-primary"));
    SelenideElement documentTypeDropDown = $(byClassName("selectric"));
    SelenideElement locationSearchField = $(byClassName("hippo-advanced-search-input-large"));
    SelenideElement statusPublishedYes = $(byId("id272"));
    SelenideElement statusPublishedNo = $(byId("id273"));
    SelenideElement statusHasChangesYes = $(byId("id274"));
    SelenideElement statusHasChangesNo = $(byId("id275"));
    SelenideElement lastModifiedBySearchField = $(byId("id276"));
    SelenideElement lastModificationDateFromSearchField = $(byId("id277"));
    SelenideElement lastModificationDateToSearchField = $(byId("id278"));
    SelenideElement creationDateFromSearchField = $(byId("id279"));
    SelenideElement creationDateToSearchField = $(byId("id280"));
    SelenideElement publicationDateFromSearchField = $(byId("id281"));
    SelenideElement publicationDateToSearchField = $(byId("id282"));
    SelenideElement campaignFilterSearchField = $(byId("id27e"));
    SelenideElement titleFilterSearchField = $(byClassName("hippo-advanced-search-input-large"));
    SelenideElement pageListRow = $(byClassName("paging-container-"));
    List<SelenideElement> documentList = $$(byClassName("datatable-tbody"));
    SelenideElement clearButton = $(byClassName("clear"));

    public void searchDocument(String doc){
        $(searchPerformAction).val(doc);
        $(searchButton).click();
    }

    public void searchSpecifiedDocument(String doc,String documentType,String location,Boolean statusPublished,Boolean statusHasChanged,String lastModifiedBy,String lastModificationDateFrom,String lastModificationDateTo,String creationDateFrom,
                                        String creationDateTo,String publicationDateFrom,String publicationDateTo,String campaignFilter,String titleFilter){
        $(documentTypeDropDown).selectOptionByValue(documentType);
        $(locationSearchField).val(location);
        if (statusPublished) {
            $(this.statusPublishedYes).click();
        } else {
            $(this.statusPublishedNo).click();
        }
        if (statusHasChanged) {
            $(this.statusHasChangesYes).click();
        } else {
            $(this.statusHasChangesNo).click();
        }
        $(lastModifiedBySearchField).val(lastModifiedBy);
        $(lastModificationDateFromSearchField).val(lastModificationDateFrom);
        $(lastModificationDateToSearchField).val(lastModificationDateTo);
        $(creationDateFromSearchField).val(creationDateFrom);
        $(creationDateToSearchField).val(creationDateTo);
        $(publicationDateFromSearchField).val(publicationDateFrom);
        $(publicationDateToSearchField).val(publicationDateTo);
        $(campaignFilterSearchField).val(campaignFilter);
        $(titleFilterSearchField).val(titleFilter);
        searchDocument(doc);
    }

    public void pickPageRow(int i){
        $(pageListRow.getValue() + i).click();
    }

    public void selectDocumentFromList(String doc){
        documentList.stream().filter(name -> name.getText().equalsIgnoreCase(doc)).findAny().orElseThrow().click();
    }
}