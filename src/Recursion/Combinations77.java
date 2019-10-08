package Recursion;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author he.wu Given two integers n and k, return all possible combinations of
 *         k numbers out of 1 ... n.
 * 
 *         Example:
 * 
 *         Input: n = 4, k = 2 Output: [ [2,4], [3,4], [2,3], [1,2], [1,3],
 *         [1,4], ]
 */
public class Combinations77 {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (k == 0)
			return res;
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}
		helper(res, nums, new ArrayList<Integer>(), k, 0, 0);
		return res;
	}

	private void helper(List<List<Integer>> res, int[] nums, ArrayList<Integer> tem, int k, int start, int count) {
		if (tem.size() == k)
			res.add(new ArrayList<Integer>(tem));
		for (int i = start; i < nums.length && count < k; i++) {
			if(!tem.isEmpty() && tem.get(tem.size()-1) >= nums[i]) continue;
			tem.add(nums[i]);
			helper(res, nums, tem, k, start + 1, count + 1);
			tem.remove(tem.size() - 1);
		}
	}

	@Test
	public void test() {
		System.out.println(combine(4, 2));
	}
}
