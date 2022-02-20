package stepdefinitions;

import com.google.gson.JsonObject;
import controller.EnvironmentController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Booking;
import model.Bookingdates;
import net.thucydides.core.annotations.Steps;
import steps.BookingSteps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static model.Booking.createBookingObject;
import static net.serenitybdd.core.Serenity.sessionVariableCalled;

public class BookingStepDefinitions {

    @Steps
    private BookingSteps bookingSteps;

    private JsonObject authType;
    private String jsonObject;
    private Booking booking;
    private Bookingdates bookingdates;
    private List<Booking> bookingList = new ArrayList<>();

    @Given("user creates a booking with full name: {string} {string} that paid {string} euro, deposit paid  {string} that will check in from {string} and check out at {string} with specific needs of {string}")
    public void userCreatesABooking(String firstName, String lastName, String totalPrice, String depositPaid, String checkIn, String checkOut, String aditionalNeeds) {
        bookingdates = new Bookingdates(checkIn,checkOut);
        booking = createBookingObject(firstName,lastName,totalPrice,depositPaid,bookingdates,aditionalNeeds);
        jsonObject = EnvironmentController.serializeJsonBooking(booking);
        bookingSteps.createBooking(jsonObject);
        //request
    }

    @When("a mistaken is identified that name of the client should have been Dee {string} and properly edited")
    public void aMistakenIsIdentifiedThatNameOfTheClientShouldHaveBeenDeeAndProperlyEdited(String lastName) throws IOException {
        booking.setLastname(lastName);
        jsonObject = EnvironmentController.serializeJsonBooking(booking);
        authType = EnvironmentController.getJsonObject("admin");
        bookingSteps.authenticateWith(authType);
        bookingSteps.updateBooking(jsonObject, sessionVariableCalled("bookingID"));
    }

    @Then("the system should display the change")
    public void theSystemShouldDisplayTheChange() {
        bookingSteps.getBooking(sessionVariableCalled("bookingID"));
        bookingSteps.verifyBookingInformation(booking);
    }

    @When("the user requests to extend his stay until {string}")
    public void theUserRequestsToExtendHisStayUntil(String updatedCheckout) throws IOException {
        bookingdates.setCheckout(updatedCheckout);
        booking.setBookingdates(bookingdates);
        jsonObject = EnvironmentController.serializeJsonBooking(booking);
        authType = EnvironmentController.getJsonObject("admin");
        bookingSteps.authenticateWith(authType);
        bookingSteps.updateBooking(jsonObject, sessionVariableCalled("bookingID"));
    }

    @Then("the system should update the checkout date")
    public void theSystemShouldUpdateTheCheckoutDate() {
        bookingSteps.getBooking(sessionVariableCalled("bookingID"));
        bookingSteps.verifyBookingInformation(booking);
    }

    @When("user wishes to cancel the booking")
    public void userWishesToCancelTheBooking() {
        bookingSteps.deleteBooking(sessionVariableCalled("bookingID"));
    }

    @Then("the booking should not be displayed")
    public void theBookingShouldNotBeDisplayed() {
        bookingSteps.verifyBookingDeleted(sessionVariableCalled("bookingID"));
    }
}
