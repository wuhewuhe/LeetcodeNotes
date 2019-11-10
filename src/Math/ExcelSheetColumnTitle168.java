package Math;

import org.junit.Test;

/**
 * @author mac Given a positive integer, return its corresponding column title
 *         as appear in an Excel sheet.
 * 
 *         For example:
 * 
 *         1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB ... Example 1:
 * 
 *         Input: 1 Output: "A" Example 2:
 * 
 *         Input: 28 Output: "AB" Example 3:
 * 
 *         Input: 701 Output: "ZY"
 */
public class ExcelSheetColumnTitle168 {
	public String convertToTitle(int n) {
		if (n <= 0)
			return "";
		 String ans = "";
	        while (n>0) {
	            ans = (char) ((n - 1) % 26 + 'A') + ans;
	            n = (n - 1) / 26;
	        }
	        return ans;
	}

	@Test
	public void test() {
		System.out.println(convertToTitle(29));
	}
}
