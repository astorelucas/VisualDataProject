package lucastorie;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Time {
	
	public static String AdjustTime(long millis) {
		Date date = new Date(millis); 
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd-MM-YYYY"); // the format of your date
		String formattedDate = sdf.format(date);
		return formattedDate;
		}

}
