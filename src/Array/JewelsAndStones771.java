package Array;

/**
 * @author he.wu You're given strings J representing the types of stones that
 *         are jewels, and S representing the stones you have. Each character in
 *         S is a type of stone you have. You want to know how many of the
 *         stones you have are also jewels.
 * 
 *         The letters in J are guaranteed distinct, and all characters in J and
 *         S are letters. Letters are case sensitive, so "a" is considered a
 *         different type of stone from "A".
 * 
 *         Example 1:
 * 
 *         Input: J = "aA", S = "aAAbbbb" Output: 3 Example 2:
 * 
 *         Input: J = "z", S = "ZZ" Output: 0 Note:
 * 
 *         S and J will consist of letters and have length at most 50. The
 *         characters in J are distinct.
 */
public class JewelsAndStones771 {
	public int numJewelsInStones(String j, String s) {
		if (j == null || j.length() == 0 || s == null || s.length() == 0)
			return 0;
		int count = 0;
		boolean[] bool = new boolean[128];
		for (char c : j.toCharArray()) {
			bool[c] = true;
		}
		for (char c : s.toCharArray()) {
			if (bool[c])
				count++;
		}
		return count;
	}
}
