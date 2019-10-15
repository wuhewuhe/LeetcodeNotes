package Array;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * @author he.wu Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array),
 *         some elements appear twice and others appear once.
 * 
 *         Find all the elements that appear twice in this array.
 * 
 *         Could you do it without extra space and in O(n) runtime?
 * 
 *         Example: Input: [4,3,2,7,8,2,3,1]
 * 
 *         Output: [2,3]
 */
public class FindAllDuplicateArray442 {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> list = new LinkedList<Integer>();
		if (nums == null || nums.length == 0)
			return list;
		int[] ans = new int[nums.length];
		for (int i : nums) {
			ans[i - 1]++;
		}
		for (int j = 0; j < ans.length; j++) {
			if (ans[j] == 2)
				list.add(j + 1);
		}
		return list;
	}

	@Test
	public void test() {
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		System.out.println(findDuplicates(nums));
	}
}
