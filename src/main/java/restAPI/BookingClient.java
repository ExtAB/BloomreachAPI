package restAPI;

import com.google.gson.JsonObject;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static net.serenitybdd.core.Serenity.setSessionVariable;

public class BookingClient {

    private final String baseURL = "https://restful-booker.herokuapp.com";
    private final String authURL = "https://restful-booker.herokuapp.com/auth";

    public void authenticateWith(JsonObject userType) {
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(userType)
                .post(authURL);

        setSessionVariable("tokenID").to(SerenityRest.lastResponse().jsonPath().get("token"));
    }


    public void createBooking(String jsonObject) {
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                .body(jsonObject)
                .post(baseURL + Endpoints.BOOKING.getPath());
        
        setsessionVariableCalled("bookingID").to(SerenityRest.lastResponse().jsonPath().get("bookingID"));
    }


    public void updateBooking(String jsonObject, String bookingID) {
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + sessionVariableCalled("tokenID"))
                .header("Authorisation", "Basic " + sessionVariableCalled("tokenID"))
                .body(jsonObject)
                .put(baseURL + Endpoints.BOOKING.getPath() + "/" + bookingID);
    }

    public void deleteBooking(String bookingID){
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorisation","Basic "+ sessionVariableCalled("tokenID"))
                .delete(baseURL + Endpoints.BOOKING.getPath() + "/" + bookingID);
    }

    public void getBookingByID(String bookingID) {
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .get(baseURL + Endpoints.BOOKING.getPath() + "/" + bookingID);
    }

    public void getBookingByFirstnameAndLastname(String firstName,String lastName) {
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .get(baseURL + Endpoints.BOOKING.getPath() + "?firstname=" + firstName + "&lastname=" + lastName);
    }

    public void getBookingByCheckinAndCheckout(String checkin,String checkout) {
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .get(baseURL + Endpoints.BOOKING.getPath() + "?checkin=" + checkin + "&checkout=" + checkout);
    }

    public void getListOfBookings(){
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .get(baseURL + Endpoints.BOOKING.getPath());
    }
}
