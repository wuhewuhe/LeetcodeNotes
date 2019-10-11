package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author he.wu Given an array of characters, compress it in-place.
 * 
 *         The length after compression must always be smaller than or equal to
 *         the original array.
 * 
 *         Every element of the array should be a character (not int) of length
 *         1.
 * 
 *         After you are done modifying the input array in-place, return the new
 *         length of the array.
 * 
 * 
 *         Follow up: Could you solve it using only O(1) extra space?
 * 
 * 
 *         Example 1:
 * 
 *         Input: ["a","a","b","b","c","c","c"]
 * 
 *         Output: Return 6, and the first 6 characters of the input array
 *         should be: ["a","2","b","2","c","3"]
 * 
 *         Explanation: "aa" is replaced by "a2". "bb" is replaced by "b2".
 *         "ccc" is replaced by "c3".
 * 
 * 
 *         Example 2:
 * 
 *         Input: ["a"]
 * 
 *         Output: Return 1, and the first 1 characters of the input array
 *         should be: ["a"]
 * 
 *         Explanation: Nothing is replaced.
 */
public class StringCompression443 {
	// time out
	public int compress(char[] chars) {
		if (chars.length == 0 || chars == null)
			return 0;
		if (chars.length == 1)
			return 1;
		List<Character> list = new ArrayList<Character>();
		int count = 1;
		char prev = chars[0];
		for (int i = 1; i < chars.length + 1; i++) {
			if (chars[i] == prev) {
				count++;
			} else {
				list.add(chars[i - 1]);
				if (count == 1)
					continue;
				if (count >= 10) {
					char[] s = String.valueOf(count).toCharArray();
					for (char c : s)
						list.add(c);
				} else
					list.add((char) (count + '0'));
				count = 1;
			}
			prev = chars[i];
		}
		if (list.size() <= chars.length) {
			count = 0;
			for (char c : list)
				chars[count++] = c;
			return list.size();
		} else
			return chars.length;
	}

	public int compress2(char[] chars) {
		if (chars.length == 0 || chars == null)
			return 0;
		if (chars.length == 1)
			return 1;
		int len = chars.length;
		int i = 0, count = 1;
		for (int j = 1; j < chars.length + 1; j++) {
			if (j < len && chars[j] == chars[j - 1])
				count++;
			else {
				chars[i] = chars[j - 1];
				i += 1;
				if (count > 1) {
					for (char c : String.valueOf(count).toCharArray()) {
						chars[i] = c;
						i += 1;
					}
				}
				count = 1;
			}
		}
		return i;
	}

	@Test
	public void test() {
		char[] chars = { 'a', 'a', 'a', 'b', 'b', 'a', 'a' };
		System.out.println(compress2(chars));
	}
}
