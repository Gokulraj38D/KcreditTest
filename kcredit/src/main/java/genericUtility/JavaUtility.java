package genericUtility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.testng.annotations.Test;

public class JavaUtility {
	
	public String toGetDateAndTime() {

		Date date = new Date();
		System.out.println(date);// Wed Mar 20 08:35:10 IST 2024
		// Based on user identification we are modifying the date structure based on our
		// needs.Here i dont want IST, :
		String tempdate[] = date.toString().split(" ");
		String day = tempdate[0];
		String month = tempdate[1];
		String date1 = tempdate[2];
		String time = tempdate[3].replace(":", "-");
		String year = tempdate[5];
		String finaldateformate = day + " " + month + " " + date1 + " " + time + " " + year;
		System.out.println(finaldateformate); // Wed Mar 20 08-44-03 2024
		return finaldateformate;
	}
@Test
public String dateandtime() {
	LocalDateTime currentDateTime = LocalDateTime.now();
    // Define the desired date and time format
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    // Format the current date and time
    String formattedDateTime = currentDateTime.format(formatter);
    // Print the formatted date and time
    System.out.println("Formatted Date and Time: " + formattedDateTime);
    return formattedDateTime;
	
}

}
