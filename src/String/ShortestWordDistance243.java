package String;

import org.junit.Test;

/**
 * @author he.wu Shortest Word Distance Total Accepted: 1754 Total Submissions:
 *         4239 Difficulty: Easy Given a list of words and two words word1 and
 *         word2, return the shortest distance between these two words in the
 *         list.
 * 
 *         For example, Assume that words = ["practice", "makes", "perfect",
 *         "coding", "makes"].
 * 
 *         Given word1 = “coding”, word2 = “practice”, return 3. Given word1 =
 *         "makes", word2 = "coding", return 1.
 * 
 *         Note: You may assume that word1 does not equal to word2, and word1
 *         and word2 are both in the list. ————————————————
 */
public class ShortestWordDistance243 {
	public int shortestDistance(String[] words, String word1, String word2) {
		int n = words.length;
		int distance = Integer.MAX_VALUE, index1 = n, index2 = n;
		for (int i = 0; i < words.length; i++) {
			if (words[i] == word1)
				index1 = i;
			if (words[i] == word2)
				index2 = i;
			if (index1 != n && index2 != n)
				distance = Math.min(distance, Math.abs(index2 - index1));
		}
		return distance;
	}

	@Test
	public void test() {
		String[] str = { "practice", "makes", "perfect", "coding", "makes" };
		String word1 = "makes", word2 = "coding";
		System.out.println(shortestDistance(str, word1, word2));
	}
}
