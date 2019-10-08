package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author he.wu Given a collection of numbers that might contain duplicates,
 *         return all possible unique permutations.
 * 
 *         Example:
 * 
 *         Input: [1,1,2] Output: [ [1,1,2], [1,2,1], [2,1,1] ]
 */
public class PermutationII47 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return res;
		backtrack(res, nums, new ArrayList<Integer>(), new boolean[nums.length]);
		return res;
	}

	private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tem, boolean[] bool) {
		if (nums.length == tem.size() && !res.contains(tem))
			res.add(new ArrayList<Integer>(tem));
		for (int i = 0; i < bool.length; i++) {
			if (!bool[i]) {
				tem.add(nums[i]);
				bool[i] = true;
				backtrack(res, nums, tem, bool);
				bool[i] = false;
				tem.remove(tem.size() - 1);
			}
		}
	}

	public List<List<Integer>> permuteUnique2(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return res;
		Arrays.sort(nums);
		backtrack2(res, nums, new ArrayList<Integer>(), new boolean[nums.length]);
		return res;
	}

	private void backtrack2(List<List<Integer>> res, int[] nums, ArrayList<Integer> tem, boolean[] bool) {
		if (nums.length == tem.size())
			res.add(new ArrayList<Integer>(tem));
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1] && !bool[i - 1])
				continue;
			if (!bool[i]) {
				tem.add(nums[i]);
				bool[i] = true;
				backtrack2(res, nums, tem, bool);
				bool[i] = false;
				tem.remove(tem.size() - 1);
			}
		}
	}

	@Test
	public void test() {
		int[] nums = { 1, 2, 2 };
		System.out.println(permuteUnique2(nums));
	}
}
