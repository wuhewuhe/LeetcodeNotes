package AlgoGenerale;

import org.junit.Test;

public class KMPSubstringpattern {

	public void prefixtable(char[] pattern, int[] prefix, int n) {
		prefix[0] = 0;
		int len = 0;
		int i = 1;
		while (i < n) {
			if (pattern[len] == pattern[i]) {
				len++;
				prefix[i] = len;
				i++;
			} else {
				if (len > 0)
					len = prefix[len - 1];
				else {
					prefix[i] = len;
					i++;
				}
			}
		}
	}

	public void move(int[] prefix, int n) {
		int i;
		for (i = n - 1; i > 0; i--) {
			prefix[i] = prefix[i - 1];
		}
		prefix[0] = -1;
	}

	public void kmp_search(char[] text, char[] pattern) {
		int n = pattern.length;
		int[] prefix = new int[pattern.length];
		prefixtable(pattern, prefix, n);
		move(prefix, n);

		// text[i] len(text) = m
		// pattern[j] len(pattern) = n
		int i = 0, m = text.length;
		int j = 0;
		while (i < m) {
			if (j == n - 1 && text[i] == pattern[j]) {
				System.out.println("found " + (i - j));
				j = prefix[j];
			}
			if (text[i] == pattern[j]) {
				i++;
				j++;
			} else {
				j = prefix[j];
				if (j == -1) {
					i++;
					j++;
				}
			}
		}
	}

	@Test
	public void test() {
//		String s = "ababcabaa";
//		char[] c = s.toCharArray();
//		int[] prefix = new int[c.length];
//		prefixtable(c, prefix, c.length);
//		System.out.println(prefix);

		char[] text = "abcdabcd".toCharArray();
		char[] pattern = "abcd".toCharArray();
		kmp_search(text, pattern);
	}
}
