package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author he.wu Given an array A of strings made only from lowercase letters,
 *         return a list of all characters that show up in all strings within
 *         the list (including duplicates). For example, if a character occurs 3
 *         times in all strings but not 4 times, you need to include that
 *         character three times in the final answer.
 * 
 *         You may return the answer in any order.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: ["bella","label","roller"] Output: ["e","l","l"] Example 2:
 * 
 *         Input: ["cool","lock","cook"] Output: ["c","o"]
 */
public class FindCommonCharacter1002 {

	// time n^2*logn space o(n)
	public List<String> commonChars(String[] A) {
		if (A == null || A.length == 0)
			return null;
		if (A.length == 1)
			return Arrays.asList(A[0]);
		List<String> list = new ArrayList<String>();
		for (int i = 1; i < A.length; i++) {
			A[i] = validString(A[i].toCharArray(), A[i - 1].toCharArray());
		}
		for (char c : A[A.length - 1].toCharArray()) {
			list.add(String.valueOf(c));
		}
		return list;
	}

	public String validString(char[] c1, char[] c2) {
		int i = 0, j = 0, k = 0;
		Arrays.sort(c1);
		Arrays.sort(c2);
		while (i < c1.length && j < c2.length) {
			if (c1[i] - 'a' < c2[j] - 'a')
				i++;
			else if (c1[i] - 'a' > c2[j] - 'a')
				j++;
			else {
				c1[k++] = c2[j];
				i++;
				j++;
			}
		}
		c1 = Arrays.copyOfRange(c1, 0, k);
//		StringBuilder sb = new StringBuilder();
//		sb.append(c1);
//		return sb.toString();
		return new String(c1);
	}

	// time o(n^2) space o(n)
	public List<String> commonChars2(String[] A) {
		int[] all_dict = new int[26];
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < 26; i++) {
			all_dict[i] = Integer.MAX_VALUE;
		}
		for (String word : A) {
			int[] dict = new int[26];
			// give a value can reduce time
			for (int i = 0; i < 26; i++) {
				dict[i] = 0;
			}

			for (Character c : word.toCharArray()) {
				dict[c - 'a']++;
			}
			for (int k = 0; k < 26; k++) {
				if (dict[k] < all_dict[k]) {
					all_dict[k] = dict[k];
				}
			}
		}
		for (int k = 0; k < 26; k++) {
			if (all_dict[k] == 1) 
				result.add(Character.toString((char) (k + 'a')));
			else if(all_dict[k] > 1) {
				result.add(Character.toString((char) (k + 'a')));
				all_dict[k]-=1;
				k--;
			}
			else continue;
		}
		return result;
	}

	@Test
	public void test() {
		String[] str = { "bella", "label", "roller" };
		System.out.println(commonChars(str));
	}
}
