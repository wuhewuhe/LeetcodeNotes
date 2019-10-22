package HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author he.wu Given a non-empty array of integers, every element appears
 *         three times except for one, which appears exactly once. Find that
 *         single one.
 * 
 *         Note:
 * 
 *         Your algorithm should have a linear runtime complexity. Could you
 *         implement it without using extra memory?
 * 
 *         Example 1:
 * 
 *         Input: [2,2,3,2] Output: 3 Example 2:
 * 
 *         Input: [0,1,0,1,0,1,99] Output: 99
 */
public class SingleNumberII137 {
	// sort
	public int singleNumber(int[] nums) {
		Arrays.sort(nums);
		int i = 0, n = nums.length, count = 1;
		while (i < n - 1) {
			while (nums[i] == nums[i + 1]) {
				count++;
				i++;
			}
			if (count != 3)
				return nums[i];
			else {
				count = 1;
				i++;
			}
		}
		// no single number
		return nums[i];
	}

	// HashMap
	public int singleNumber2(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		for (Integer i : map.keySet()) {
			if (map.get(i) != 3)
				return i;
		}
		return -1;
	}

	// bit manipulation
	public int singleNumber3(int[] A) {
		if (A == null)
			return 0;
		int x0 = ~0, x1 = 0, x2 = 0, t;
		for (int i = 0; i < A.length; i++) {
			t = x2;
			x2 = (x1 & A[i]) | (x2 & ~A[i]);
			x1 = (x0 & A[i]) | (x1 & ~A[i]);
			x0 = (t & A[i]) | (x0 & ~A[i]);
		}
		return x1;
	}

	@Test
	public void test() {
		int[] nums = { 0, 1, 0, 1, 0, 1, 9 };
		System.out.println(singleNumber2(nums));
	}
}
