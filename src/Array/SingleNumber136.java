package Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

public class SingleNumber136 {
	// HashMap
	public int SingleNumber(int[] nums) {
		if (nums == null || nums.length == 0)
			new IllegalArgumentException("verify array");
		if (nums.length == 1)
			return nums[0];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums) {
			if (map.containsKey(i))
				map.put(i, 2);
			else
				map.put(i, 1);
		}
		for (int i : map.keySet()) {
			if (map.get(i) == 1) {
				return i;
			}
		}
		return 0;
	}

	// bit manipulation
	/*
	 * Concept
	 * 
	 * If we take XOR of zero and some bit, it will return that bit a \oplus 0 =
	 * aa⊕0=a If we take XOR of two same bits, it will return 0 a \oplus a = 0a⊕a=0
	 * a \oplus b \oplus a = (a \oplus a) \oplus b = 0 \oplus b =
	 * ba⊕b⊕a=(a⊕a)⊕b=0⊕b=b So we can XOR all bits together to find the unique
	 * number.
	 */
	public int SingleNumber2(int[] nums) {
		int result = 0;
		for (int i : nums) {
			result ^= i;
		}
		return result;
	}

	// Math
	// get unique of an array : U(a,b,b,c,c) = 2(a+b+c) - sum(a+b+b+c+c)


	@Test
	public void test() {
		int[] nums = { 4, 1, 2, 1, 2 };
		System.out.println(SingleNumber2(nums));
	}
}
