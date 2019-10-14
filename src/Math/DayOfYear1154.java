package Math;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * @author he.wu Given a string date representing a Gregorian calendar date
 *         formatted as YYYY-MM-DD, return the day number of the year.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: date = "2019-01-09" Output: 9 Explanation: Given date is the
 *         9th day of the year in 2019. Example 2:
 * 
 *         Input: date = "2019-02-10" Output: 41 Example 3:
 * 
 *         Input: date = "2003-03-01" Output: 60 Example 4:
 * 
 *         Input: date = "2004-03-01" Output: 61
 */
public class DayOfYear1154 {

	public int dayOfYear(String date) {
		if (date.length() != 10)
			return 0;
		if (date.charAt(4) != '-' || date.charAt(7) != '-')
			return 0;
		int month = Integer.parseInt(date.substring(5, 7));
		int year = Integer.parseInt(date.substring(0, 4));
		int d = Integer.parseInt(date.substring(8, 10));
		int res = 0;
		if (month < 2)
			return d;
		for (int i = 1; i < month; i++) {
			if ((i == 1) || (i == 3) || (i == 5) || (i == 7) || (i == 8) || (i == 10) || (i == 12))
				res += 31;
			else if ((i == 4) || (i == 6) || (i == 9) || (i == 11))
				res += 30;
			else
				res = checkLeapYear(year) ? res + 29 : res + 28;
		}
		return res;
	}

	public boolean checkLeapYear(int year) {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}

	public int dayOfYear2(String date) {
		Date inp = null;
		try {
			inp = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(inp);
		return cal.get(Calendar.DAY_OF_YEAR);
	}

	@Test
	public void test() {
		String s = "2003-03-01";
		System.out.println(dayOfYear(s));
	}
}
