package steps;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import model.Booking;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import restAPI.BookingClient;
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.assertj.core.api.Assertions.assertThat;

public class BookingSteps {

    @Steps
    BookingClient bookingClient;

    public void authenticateWith(JsonObject authType) {
        bookingClient.authenticateWith(authType);
    }

    public void getBooking(String bookingID) {
        bookingClient.getBookingByID(bookingID);
    }

    public void createBooking(String jsonObject) {
        bookingClient.createBooking(jsonObject);
    }

    public void updateBooking(String jsonObject,String bookingID) {
        bookingClient.updateBooking(jsonObject, bookingID);
    }

    public void deleteBooking(String bookingID) {
        bookingClient.deleteBooking(bookingID);
    }

    public void verifyBookingInformation(Booking booking) {
        Booking latestBooking = new GsonBuilder().create().fromJson(SerenityRest.lastResponse().body().prettyPrint(), Booking.class);
        assertThat(booking).isEqualTo(latestBooking);
    }

    public void verifyBookingDeleted(String bookingID) {
        bookingClient.deleteBooking(bookingID);
        then().assertThat().statusCode(SC_NOT_FOUND);
        //the response returns 405 method not allowed if booking doesn't exist
    }
}
