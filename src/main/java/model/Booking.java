package model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Booking {
	String firstname;
	String lastname;
	int totalprice;
	boolean depositpaid;
	Bookingdates bookingdates;
	String additionalneeds;

	public static Booking createBookingObject(String firstname, String lastname, String totalPrice, String depositpaid, Bookingdates bookingDates, String additionalneeds){
		return new Booking(firstname,lastname,Integer.parseInt(totalPrice),Boolean.parseBoolean(depositpaid),bookingDates,additionalneeds);
//		return Booking.builder()
//				.firstname(firstName)
//				.lastname(lastName)
//				.totalprice(Integer.parseInt(totalPrice))
//				.depositpaid(Boolean.parseBoolean(depositPaid))
//				.bookingdates(bookingDates)
//				.additionalneeds(aditionalNeeds).build();
	}
}
