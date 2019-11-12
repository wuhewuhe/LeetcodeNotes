package TwoPointer;

/**
 * @author mac Given a string, find the length of the longest substring T that
 *         contains at most 2 distinct characters. For example, Given s =
 *         “eceba”, T is "ece" which its length is 3.
 * 
 */
public class LongestSubstringTwoDistinctNumbers159 {

	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s.length() == 0 || s == null)
			return 0;
		int l = 0, count = 0, res = 0;
		char[] sArr = s.toCharArray();
		int[] hash = new int[256];
		for (int r = 0; r < s.length(); r++) {
			hash[s.charAt(r)]++;
			if (hash[sArr[r]] == 1) {
				count++;
			}
			while (count > 2) {
				hash[sArr[l]]--;

				if (hash[sArr[l]] == 0) {
					count--;
				}

				l++;
			}

			res = Math.max(res, r - l + 1);
		}
		return res;
	}
}
