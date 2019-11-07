package queue;

import java.util.PriorityQueue;

import org.junit.Test;

/**
 * @author he.wu Given a string, sort it in decreasing order based on the
 *         frequency of characters.
 * 
 *         Example 1:
 * 
 *         Input: "tree"
 * 
 *         Output: "eert"
 * 
 *         Explanation: 'e' appears twice while 'r' and 't' both appear once. So
 *         'e' must appear before both 'r' and 't'. Therefore "eetr" is also a
 *         valid answer. Example 2:
 * 
 *         Input: "cccaaa"
 * 
 *         Output: "cccaaa"
 * 
 *         Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also
 *         a valid answer. Note that "cacaca" is incorrect, as the same
 *         characters must be together. Example 3:
 * 
 *         Input: "Aabb"
 * 
 *         Output: "bbAa"
 * 
 *         Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
 *         Note that 'A' and 'a' are treated as two different characters.
 */
public class SortCharactersByFrequency451 {
	// priority queue
	public String frequencySort(String s) {
		if (s == null || s.length() == 0)
			return "";
		StringBuilder sb = new StringBuilder();
		PriorityQueue<MutliChars> pq = new PriorityQueue<MutliChars>(
				(MutliChars n1, MutliChars n2) -> n2.count - n1.count);
		int[] hash = new int[128];
		// 65 - 122 A - z
		for (char c : s.toCharArray()) {
			hash[c]++;
		}
		for (int i = 48; i <= 122; i++) {
			if (hash[i] != 0) {
				pq.add(new MutliChars(hash[i], (char) i));
			}
		}
		while (pq.size() > 0) {
			MutliChars mc = pq.poll();
			while (mc.count-- > 0) {
				sb.append(mc.letter);
			}
		}
		return sb.toString();
	}

	static class MutliChars {
		int count;
		char letter;

		MutliChars(int count, char letter) {
			this.count = count;
			this.letter = letter;
		}
	}

	@Test
	public void test() {
		String s = "Aabb";
		System.out.println(frequencySort(s));
	}
}
