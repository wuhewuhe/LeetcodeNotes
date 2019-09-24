package Amazon;

import org.junit.jupiter.api.Test;

/**
 * @author he.wu Amazon
 * 
 *         one string is strictly smaller than another when the frequency of
 *         occurrence of smallest character in the string is less than the
 *         frequency of the occurrence of the smallest character in comparison
 *         String
 *
 *         write a function, given two string A and B, contains M and N string,
 *         delimited by space return an array C of N integers, values of c[j]
 *         specify the numbers of string in A which are strictly smaller than
 *         the comparsion j-th string in B start from 0
 * 
 *         assume that: 1<= N, M<=1000 1<=length of length of any string
 *         contained by A or B <= 10 all input string comprise only lowercase,
 *         English alphabet letters a to z
 */
public class CompareString {
	//time complex o(n^2)  space complex O(n)
	public int[] CompareStrings(String A, String B) {
		String[] strsA = A.split(","), strsB = B.split(",");
		int lenA = strsA.length, lenB = strsB.length;
		int[] freqs = new int[11]; // the frequency of the smallest char must be less than or equal to 10.
		int[] res = new int[lenB];
		for (String s : strsA) {
			if (s.length() == 0)
				continue;
			int[] counts = new int[26];// record the frequency of letter in one world
			int minIdx = 26;
			for (char c : s.toCharArray()) {
				++counts[c - 'a'];
				minIdx = Math.min(minIdx, c - 'a');
			}
			int freq = counts[minIdx];
			freqs[freq]++;
		}

		// use prefix sum to easily get sum from idx 0 to i
//        for(int i = 1; i < 11; ++i)
//            freqs[i] += freqs[i - 1];

		for (int i = 0; i < lenB; ++i) {
			String s = strsB[i];
			int[] counts = new int[26];
			int minIdx = 26;
			for (char c : s.toCharArray()) {
				++counts[c - 'a'];
				minIdx = Math.min(minIdx, c - 'a');
			}
			int freq = counts[minIdx];
			// res[i] = (freq - 1 >= 0)? freqs[freq - 1]: 0;
			for (int j = 0; j < freq; j++) {
				res[i] += freqs[j];
			}
		}
		return res;
	}

	@Test
	public void test() {
		String A = "abcd,aabc,bd";
		String B = "aaa,aa";
		System.out.println(CompareStrings(A, B)[0] + " " + CompareStrings(A, B)[1]);
	}
}
