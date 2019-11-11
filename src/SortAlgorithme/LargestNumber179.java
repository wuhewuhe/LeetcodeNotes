package SortAlgorithme;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

/**
 * @author mac Given a list of non negative integers, arrange them such that
 *         they form the largest number.
 * 
 *         Example 1:
 * 
 *         Input: [10,2] Output: "210" Example 2:
 * 
 *         Input: [3,30,34,5,9] Output: "9534330" Note: The result may be very
 *         large, so you need to return a string instead of an integer.
 */

public class LargestNumber179 {

	public String largestNumber(int[] nums) {
		if (nums == null)
			return "";
		StringBuilder sb = new StringBuilder();
		String[] s_num = new String[nums.length];
		for (int i = 0; i < nums.length; i++)
			s_num[i] = String.valueOf(nums[i]);
		// Comparator to decide which string should come first in concatenation
		Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String s1 = o1 + o2;
				String s2 = o2 + o1;
				return s2.compareTo(s1);
			}
		};

		// An extreme edge case by lc, say you have only a bunch of 0 in your int array
		Arrays.sort(s_num, comp);
		if (s_num[0].charAt(0) == '0')
			return "0";
		for (String s : s_num)
			sb.append(s);

		return sb.toString();
	}

	@Test
	public void test() {
		int[] nums = { 3, 30, 34, 5, 9 };
		System.out.println(largestNumber(nums));
	}
}
