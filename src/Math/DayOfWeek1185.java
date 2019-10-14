package Math;

import java.time.Month;
import java.time.Year;

import org.junit.Test;

/**
 * @author he.wu Given a date, return the corresponding day of the week for that
 *         date.
 * 
 *         The input is given as three integers representing the day, month and
 *         year respectively.
 * 
 *         Return the answer as one of the following values {"Sunday", "Monday",
 *         "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: day = 31, month = 8, year = 2019 Output: "Saturday" Example 2:
 * 
 *         Input: day = 18, month = 7, year = 1999 Output: "Sunday" Example 3:
 * 
 *         Input: day = 15, month = 8, year = 1993 Output: "Sunday"
 */
public class DayOfWeek1185 {
	public String dayOfTheWeek(int day, int month, int year) {
		String[] weeks = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
		int weekOfDay = Year.of(year).atMonth(Month.of(month)).atDay(day).getDayOfWeek().getValue() - 1;
		return weeks[weekOfDay];
	}

	public String dayOfTheWeek2(int day, int month, int year) {
		// 1971 1 1 is a Friday
		String[] dayMap = { "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday" };
		int[] monthMap = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334 };
		int sum = 0;
		for (int i = 1971; i < year; i++) {
			if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0)
				sum += 366;
			else
				sum = sum + 365;
		}
		int extraDay = 0;
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
			if (month >= 3)
				extraDay = 1;
		int totalDays = sum + (monthMap[month - 1]) + extraDay + day;
		return dayMap[totalDays % 7];
	}

	// zeller formula
	//d = c/4 - 2*c + y +4/y + (13*(m+1))/5 + d -1;

	@Test
	public void test() {
		System.out.println(dayOfTheWeek2(14, 10, 2019));
	}
}