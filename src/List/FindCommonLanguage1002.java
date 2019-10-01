package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;

/**
 * @author mac Given an array A of strings made only from lowercase letters,
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
public class FindCommonLanguage1002 {
	public List<String> commonChars(String[] A) {
		int[] count = new int[26];
		Arrays.fill(count, Integer.MAX_VALUE);
		for (String str : A) {
			int[] cnt = new int[26];
			str.chars().forEach(c -> ++cnt[c - 'a']); // count each char's frequency in string str.
			IntStream.range(0, 26).forEach(i -> count[i] = Math.min(cnt[i], count[i])); // update minimum frequency.
		}
		List<String> ans = new ArrayList<>();
		IntStream.range('a', 'z' + 1).forEach(c -> ans.addAll(Collections.nCopies(count[c - 'a'], "" + (char) c)));
		return ans;
	}

	public List<String> commonChars2(String[] A) {
		List<String> ans = new ArrayList<>();
		int[] count = new int[26];
		Arrays.fill(count, Integer.MAX_VALUE);
		for (String str : A) {
			int[] cnt = new int[26];
			str.chars().forEach(c -> ++cnt[c - 'a']); // count each char's frequency in string str.
			for (int i = 0; i < 26; ++i) {
				count[i] = Math.min(cnt[i], count[i]);
			} // update minimum frequency.
		}
		for (char c = 'a'; c <= 'z'; ++c) {
			while (count[c - 'a']-- > 0) {
				ans.add("" + c);
			}
		}
		return ans;

	}

	public List<String> commonChars3(String[] A) {
		if (A == null || A.length == 0)
			return null;
		List<String> list = new ArrayList<String>();
		if (A.length == 1) {
			for (char c : A[0].toCharArray())
				list.add(String.valueOf(c));
			return list;
		} else {
			int[] global = new int[26];
			for (int k = 0; k < global.length; k++) {
				global[k] = Integer.MAX_VALUE;
			}
			for (String str : A) {
				int[] local = new int[26];
				for (int k = 0; k < local.length; k++) {
					local[k]=0;
				}
				for (int i = 0; i < str.length(); i++) {
					local[str.charAt(i)-'a']+=1;
				}
				for (int i = 0; i < local.length; i++) {
					if(local[i]<global[i])
						global[i]=local[i];
				}
			}
			for (char i = 'a'; i <= 'z';) {
				if(global[i-'a']>0) {
					list.add(String.valueOf(i));
					global[i-'a']-=1;
				}
				else
					i++;
			}
			return list;
		}
	}

	@Test
	public void test() {
		String[] str = { "bella", "label", "roller" };
		commonChars3(str).forEach(System.out::println);
	}
}
