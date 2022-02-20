package model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Booking {
	private String firstname;
	private String lastname;
	private int totalprice;
	private boolean depositpaid;
	private Bookingdates bookingdates;
	private String additionalneeds;

	public static Booking createBookingObject(String firstname, String lastname, String totalPrice, String depositpaid, Bookingdates bookingDates, String additionalneeds){
		return new Booking(firstname,lastname,Integer.parseInt(totalPrice),Boolean.parseBoolean(depositpaid),bookingDates,additionalneeds);
	}
}
