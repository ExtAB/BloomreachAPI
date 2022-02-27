package Pages;

import com.codeborne.selenide.SelenideElement;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class ContentReportsPage {
    SelenideElement buzz = $(byClassName("idf7c"));
    SelenideElement buzzRecentlyPublishedTable = $(byClassName("x-panel"));
    SelenideElement buzzRecentlyPublishedPages = $(byClassName("ext-comp-1186"));
    SelenideElement buzzVisitorLastMonthTable = $(byClassName("hippo-report"));
    SelenideElement buzzRefreshButton = $(byClassName("reports-refresh-button"));

    SelenideElement myDocuments = $(byClassName("idf7d"));
    SelenideElement myDocsRecentlyEdited = $(byClassName("x-panel-body-noborder"));
    SelenideElement myDocsRecentlyPublished = $(byClassName("hippo-report-message-normal"));
    SelenideElement myDocsMyTotal = $(byClassName("x-panel-body"));

    SelenideElement teamDocuments = $(byClassName("idf7e"));
    SelenideElement teamDocInProgress = $(byClassName("x-panel-body"));
    SelenideElement teamDocOldestContentOnline = $(byClassName("hippo-report-message-normal"));
    SelenideElement teamDoc12MonthsPublicationTrends = $(byClassName("x-panel-body-noheader-publication"));
    SelenideElement teamDocRecentlyCreated = $(byClassName("x-panel-body-noborder"));
    SelenideElement teamDocRecentlyEdited = $(byClassName("x-panel-body-border"));
    SelenideElement teamDocRecentlyPublished = $(byClassName("hippo-report-message-normal-offest"));

    SelenideElement totals = $(byClassName("idf7f"));
    SelenideElement totalsDocumentTypeDistribution = $(byClassName("c3-event-rect-0"));
    SelenideElement totalsDocumentWorkflowStates = $(byClassName("c3-event-rect-1"));
    SelenideElement totalsDocumentsImagesAssetsTotals = $(byClassName("c3-event-rect-2"));
    SelenideElement totalsDocumentTopAuthors = $(byClassName("c3-event-rect-3"));
    SelenideElement totalsDocumentTranslations = $(byClassName("c3-event-rect-4"));
    SelenideElement totalsDocumentVisitorsLastTwoWeeks = $(byClassName("c3-event-rect-5"));

    public void verifyTableMetrics(){
        // assertions
    }
}