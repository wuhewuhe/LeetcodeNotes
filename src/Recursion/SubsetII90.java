package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author he.wu Given a collection of integers that might contain duplicates,
 *         nums, return all possible subsets (the power set).
 * 
 *         Note: The solution set must not contain duplicate subsets.
 * 
 *         Example:
 * 
 *         Input: [1,2,2] Output: [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 */
public class SubsetII90 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return res;
		Arrays.sort(nums);
		List<Integer> tem = new ArrayList<Integer>();
		backtracking(res, tem, nums, 0);
		return res;
	}

	private void backtracking(List<List<Integer>> res, List<Integer> tem, int[] nums, int index) {
		res.add(new ArrayList<Integer>(tem));
		for (int j = index; j < nums.length; j++) {
			if (j > index && nums[j] == nums[j - 1])
				continue;
			tem.add(nums[j]);
			backtracking(res, tem, nums, j + 1);
			tem.remove(tem.size() - 1);
		}
	}

	@Test
	public void test() {
		int[] nums = { 1, 2, 2 };
		System.out.println(subsetsWithDup(nums));
	}
}
