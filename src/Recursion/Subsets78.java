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
		helper(tem,res,nums,0,0);
		return res;
	}

	private void helper(List<Integer> tem, List<List<Integer>> res, int[] nums, int pos, int iter) {
		res.add(new ArrayList<Integer>(tem));
		if(pos == nums.length) return;
		for (int i = iter; i < nums.length; i++) {
			if(tem.contains(nums[i])) continue;
			tem.add(nums[i]);
			helper(tem,res,nums,pos+1,i);
			tem.remove(tem.size()-1);
		}
	}
	
	public List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return res;
		List<Integer> tem = new ArrayList<Integer>();
		helper(tem,res,nums,0);
		return res;
	}
	

	private void helper(List<Integer> tem, List<List<Integer>> res, int[] nums, int start) {
		res.add(new ArrayList<Integer>(tem));
		for (int i = start; i < nums.length; i++) {
			tem.add(nums[i]);
			helper(tem,res,nums,i+1);
			tem.remove(tem.size()-1);
		}
	}

	@Test
	public void test() {
		int[] nums = {1,2,3};
		System.out.println(subsets2(nums));
	}
}
