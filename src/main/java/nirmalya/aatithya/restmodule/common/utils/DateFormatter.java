/**
 * 
 */
package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Nirmalya Labs
 *
 */
public class DateFormatter {

	public static String getStringDate(String date) {

		String formattedDate = null;

		try {

			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			Date newDate = format.parse(date);

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			formattedDate = formatter.format(newDate);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return formattedDate;
	}

	public static String getStringTime(String date) {

		String formattedDate = null;

		try {

			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			Date newDate = format.parse(date);

			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
			formattedDate = formatter.format(newDate);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return formattedDate;
	}
	
	public static String getStringDateTime(String date) {
		
		String formattedDate = null;
		
		try {
			
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			Date newDate = format.parse(date);
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			formattedDate = formatter.format(newDate);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return formattedDate;
	}
	
	public static String getStringDateTimeWithoutS(String date) {
		
		String formattedDate = null;
		
		try {
			
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			Date newDate = format.parse(date);
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			formattedDate = formatter.format(newDate);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return formattedDate;
	}

	public static Object returnStringDate(Object date) {

		Object formattedDate = null;

		try {
			Date newDate = (Date) date;
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			formattedDate = formatter.format(newDate);
		} catch (Exception e) {
			formattedDate = "--";
			e.printStackTrace();
		}

		return formattedDate;
	}

	public static Object returnStringDateTime(Object date) {

		Object formattedDate = null;

		try {
			Date newDate = (Date) date;
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			formattedDate = formatter.format(newDate);
		} catch (Exception e) {
			formattedDate = "--";
			e.printStackTrace();
		}

		return formattedDate;
	}

	public static Object returnStringTime(Object date) {

		Object formattedDate = null;

		try {
			Date newDate = (Date) date;
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
			formattedDate = formatter.format(newDate);
		} catch (Exception e) {
			formattedDate = "--";
			e.printStackTrace();
		}

		return formattedDate;
	}

	public static Object returnStringTimeHMS(Object date) {

		Object formattedDate = null;

		try {
			Date newDate = (Date) date;
			SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
			formattedDate = formatter.format(newDate);
		} catch (Exception e) {
			formattedDate = "--";
			e.printStackTrace();
		}

		return formattedDate;
	}

	public static Object returnStringDateMMMFormat(Object date) {

		Object formattedDate = null;

		try {
			Date newDate = (Date) date;
			DateFormat formatter = new SimpleDateFormat("MMM dd yyyy");
			formattedDate = formatter.format(newDate);
		} catch (Exception e) {
			formattedDate = "--";
			e.printStackTrace();
		}

		return formattedDate;
	}
	
	public static Object returnStringDateYear(Object date) {

		Object formattedDate = null;

		try {
			Date newDate = (Date) date;
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
			formattedDate = formatter.format(newDate);
		} catch (Exception e) {
			formattedDate = "--";
			e.printStackTrace();
		}

		return formattedDate;
	}
	
	public static String getStringMonthYear(String date) {

		String formattedDate = null;

		try {

			SimpleDateFormat format = new SimpleDateFormat("MM-yyyy");
			Date newDate = format.parse(date);

			SimpleDateFormat formatter = new SimpleDateFormat("YY");
			formattedDate = formatter.format(newDate);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return formattedDate;
	}

	@SuppressWarnings("unused")
	public static String getMonthYear(String date) {
		String dateParts[] = date.split("-");

		String day = dateParts[0];
		String month = dateParts[1];
		String year = dateParts[2];

		return "SET @p_month ='" + month + "',@p_date='" + date + "', @p_year='" + year + "';";
	}

}
