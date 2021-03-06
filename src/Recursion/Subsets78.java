package Recursion;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author mac Given a set of distinct integers, nums, return all possible
 *         subsets (the power set).
 * 
 *         Note: The solution set must not contain duplicate subsets.
 * 
 *         Example:
 * 
 *         Input: nums = [1,2,3] Output: [ [3], [1], [2], [1,2,3], [1,3], [2,3],
 *         [1,2], [] ]
 */
public class Subsets78 {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return res;
		List<Integer> tem = new ArrayList<Integer>();
		backtracking(res, tem, nums, 0);
		return res;
	}

	// if we would like return all of answer, we use void
	private void backtracking(List<List<Integer>> res, List<Integer> tem, int[] nums, int index) {
		// exit
		res.add(new ArrayList<Integer>(tem));
		for (int i = index; i < nums.length; i++) {
			tem.add(nums[i]);
			// iterate the next number
			backtracking(res, tem, nums, i + 1);
			// back track to the previous step
			tem.remove(tem.size() - 1);
		}
	}

	@Test
	public void test() {
		int[] nums = { 1, 2, 3 };
		System.out.println(subsets(nums));
	}
}
