package String;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * @author he.wu Given a paragraph and a list of banned words, return the most
 *         frequent word that is not in the list of banned words. It is
 *         guaranteed there is at least one word that isn't banned, and that the
 *         answer is unique.
 * 
 *         Words in the list of banned words are given in lowercase, and free of
 *         punctuation. Words in the paragraph are not case sensitive. The
 *         answer is in lowercase.
 * 
 * 
 * 
 *         Example:
 * 
 *         Input: paragraph = "Bob hit a ball, the hit BALL flew far after it
 *         was hit." banned = ["hit"] Output: "ball" Explanation: "hit" occurs 3
 *         times, but it is a banned word. "ball" occurs twice (and no other
 *         word does), so it is the most frequent non-banned word in the
 *         paragraph. Note that words in the paragraph are not case sensitive,
 *         that punctuation is ignored (even if adjacent to words, such as
 *         "ball,"), and that "hit" isn't the answer even though it occurs more
 *         because it is banned.
 * 
 *         Note:
 * 
 *         1 <= paragraph.length <= 1000. 0 <= banned.length <= 100. 1 <=
 *         banned[i].length <= 10. The answer is unique, and written in
 *         lowercase (even if its occurrences in paragraph may have uppercase
 *         symbols, and even if it is a proper noun.) paragraph only consists of
 *         letters, spaces, or the punctuation symbols !?',;. There are no
 *         hyphens or hyphenated words. Words only consist of letters, never
 *         apostrophes or other punctuation symbols.
 */
public class MostCommonWord819 {

	public String mostCommonWord2(String p, String[] banned) {
		Set<String> ban = new HashSet<>(Arrays.asList(banned));
		Map<String, Integer> count = new HashMap<>();
		//regex \w a-zA-Z0-9 \W no character \s whitespace + occur at least one times
		String[] words = p.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
		for (String w : words)
			if (!ban.contains(w))
				/*Returns the value to which the specified key is mapped, or
			     * {@code defaultValue} if this map contains no mapping for the key.*/
				count.put(w, count.getOrDefault(w, 0) + 1);
		return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
	}

	public String mostCommonWord(String paragraph, String[] banned) {

		paragraph += ".";

		Set<String> banset = new HashSet<String>();

		for (String word : banned)
			banset.add(word);
		Map<String, Integer> count = new HashMap<String, Integer>();

		String ans = "";
		int ansfreq = 0;

		StringBuilder word = new StringBuilder();
		for (char c : paragraph.toCharArray()) {
			if (Character.isLetter(c)) {
				word.append(Character.toLowerCase(c));
			} else if (word.length() > 0) {
				String finalword = word.toString();
				if (!banset.contains(finalword)) {
					count.put(finalword, count.getOrDefault(finalword, 0) + 1);
					if (count.get(finalword) > ansfreq) {
						ans = finalword;
						ansfreq = count.get(finalword);
					}
				}
				word = new StringBuilder();
			}
		}
		return ans;
	}

	@Test
	public void test() {
		String str = "Bob hit a ball, the hit BALL flew far after it was hit 0 2 3.";
		String[] ban = { "hit" };
		System.out.println(mostCommonWord2(str, ban));
	}

}
