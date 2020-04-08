package Math;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BinaryPrefixFive1081 {
	public List<Boolean> prefixesDivBy5(int[] A) {
		int k = 0;
		List<Boolean> ans = new ArrayList<>();
		for (int a : A) {
			k = (k << 1 | a) % 5; // left shift k by 1 bit and plus current element a is the binary number.
			ans.add(k == 0);
		}
		return ans;
	}

	public List<Boolean> prefixesDivBy52(int[] A) {
		if (A == null || A.length == 0) {
			return null;
		}
		List<Boolean> ans = new ArrayList<>(A.length);
		int reminder = 0;
		for (int bit : A) {
			// %5 avoid out of range
			reminder = (2 * reminder + bit) % 5;
			System.out.println(reminder);
			ans.add(reminder == 0);
		}
		return ans;
	}

	@Test
	public void test() {
		int[] n = { 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1,
				0, 1, 0, 0, 0, 1 };
		System.out.println(prefixesDivBy52(n));
	}
}
