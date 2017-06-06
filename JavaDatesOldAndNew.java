package extras;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

public class JavaDatesOldAndNew {

	public static void main(String[] args) {
		
		/*******************************************
		 * Old way of using dates in Java- still
		 * heavily used
		 ******************************************/
		System.out.println("Old Java Date and Calendar:");
		System.out.println("---------------------------");
		// 1 old - create date with current System time
		Date now = new Date();
		System.out.println("Current date/time = " + now);
		
		// 2 old - create a date in the past, must use a Calendar
		GregorianCalendar calendar = new GregorianCalendar(1978, 7, 2);
		// now have to get the Date from GregorianCalendar
		Date discoDate = calendar.getTime();
		System.out.println("Date when disco popular, month may not be the one you want: " + discoDate);
		
		// 3 old - parse string into date
		String userDateString1 = "01/02/2000";
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date userDate1;
		try {
			userDate1 = sdf.parse(userDateString1);
			System.out.println("Date parsed from string: " + userDate1);
		} catch (ParseException e) {
			System.out.println(userDateString1 + " is not a valid Date.  Date must be in mm/dd/yyyy format.");
		}
		
		// 4 old - format date into string
		System.out.println("Current date (formatted): " + sdf.format(now));
		
		
		/*******************************************
		 * New way of using dates, as of Java 8.
		 * Uses LocalDate,LocalTime and LocalDateTime classes
		 ******************************************/
		System.out.println("\nNew, Java 8, LocalDate");
		System.out.println("-------------------------");
		// 1 new - create date with current System time
		
		LocalDate nowLocalDate = LocalDate.now();
		System.out.println("Current date = " + nowLocalDate);
		LocalTime nowLocalTime = LocalTime.now();
		System.out.println("Current time = " + nowLocalTime);
		LocalDateTime nowLocalDateTime = LocalDateTime.now();
		System.out.println("Current date/time = " + nowLocalDateTime);
		
		
		// 2 new - create a date in the past
		LocalDate walkmanDate = LocalDate.of(1985, Month.JULY, 2);
		System.out.println("Date when walmans popular: " + walkmanDate);
		
		// 3 new - pares string into date
		String userDateString2 = "02/03/2010";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate userDate2 = LocalDate.parse(userDateString2, formatter);
		System.out.println("Date parsed from string " + userDate2);
		
		// 4 old - format date into string
		System.out.println("Current date (formatted): " + nowLocalDate.format(formatter));
	}

}
