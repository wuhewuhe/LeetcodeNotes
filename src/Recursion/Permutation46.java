package Recursion;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author he.wu Given a collection of distinct integers, return all possible
 *         permutations.
 * 
 *         Example:
 * 
 *         Input: [1,2,3] Output: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2],
 *         [3,2,1] ]
 * 
 *         recursion + dfs + backtracking
 */
public class Permutation46 {
	public List<List<Integer>> permute(int[] nums) {
		if(nums.length == 0 || nums == null) return null;
		boolean[] bool = new boolean[nums.length];
		List<Integer> tem = new ArrayList<Integer>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		dfs(res,nums,tem,bool);
		return res;
	}

	private void dfs(List<List<Integer>> res, int[] nums, List<Integer> tem, boolean[] bool) {
		if(tem.size() == nums.length)
			res.add(new ArrayList<Integer>(tem));
		for (int i = 0; i < nums.length; i++) {
			if(!bool[i]) {
				tem.add(nums[i]);
				bool[i] = true;
				dfs(res,nums,tem,bool);
				tem.remove(tem.size()-1);
				bool[i] = false;
			}
		}
	}
	
	@Test
	public void test() {
		int[] nums = {1,2,3};
		System.out.println(permute(nums));
	}
	
	


}
