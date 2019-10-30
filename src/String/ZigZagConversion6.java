package String;

import org.junit.Test;

/**
 * @author he.wu The string "PAYPALISHIRING" is written in a zigzag pattern on a
 *         given number of rows like this: (you may want to display this pattern
 *         in a fixed font for better legibility)
 * 
 *         P A H N A P L S I I G Y I R And then read line by line:
 *         "PAHNAPLSIIGYIR"
 * 
 *         Write the code that will take a string and make this conversion given
 *         a number of rows:
 * 
 *         string convert(string s, int numRows); Example 1:
 * 
 *         Input: s = "PAYPALISHIRING", numRows = 3 Output: "PAHNAPLSIIGYIR"
 *         Example 2:
 * 
 *         Input: s = "PAYPALISHIRING", numRows = 4 Output: "PINALSIGYAHRPI"
 *         Explanation:
 * 
 *         P I N A L S I G Y A H R P I
 */

public class ZigZagConversion6 {
	// sort by row or visit by row
	public String convert(String s, int numRows) {
		char[] c = s.toCharArray();
		int len = c.length;
		StringBuilder[] sb = new StringBuilder[numRows];
		for (int i = 0; i < sb.length; i++) {
			sb[i] = new StringBuilder();
		}
		int i = 0;
		while (i < len) {
			// vertically
			for (int idx = 0; idx < numRows && i < len; idx++) {
				sb[idx].append(c[i]);
				i++;
			}
			// obliquely
			for (int idx = numRows - 2; idx >= 1 && i < len; idx--) {
				sb[idx].append(c[i]);
				i++;
			}
		}
		for (int idx = 1; idx < sb.length; idx++) {
			sb[0].append(sb[idx]);
		}
		return sb[0].toString();
	}

	@Test
	public void test() {
		String s = "PAYPALISHIRING";
		int numRows = 4;
		String str = convert(s, numRows);
		System.out.println(str);
	}
}
