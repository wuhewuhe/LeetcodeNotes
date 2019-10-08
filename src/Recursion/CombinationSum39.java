package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * @author mac Given a set of candidate numbers (candidates) (without
 *         duplicates) and a target number (target), find all unique
 *         combinations in candidates where the candidate numbers sums to
 *         target.
 * 
 *         The same repeated number may be chosen from candidates unlimited
 *         number of times.
 * 
 *         Note:
 * 
 *         All numbers (including target) will be positive integers. The
 *         solution set must not contain duplicate combinations.
 * 
 * 
 *         Example 1:
 * 
 *         Input: candidates = [2,3,6,7], target = 7, A solution set is: [ [7],
 *         [2,2,3] ] Example 2:
 * 
 *         Input: candidates = [2,3,5], target = 8, A solution set is: [
 *         [2,2,2,2], [2,3,3], [3,5] ]
 */
public class CombinationSum39 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (candidates == null || candidates.length == 0)
			return res;
		Arrays.sort(candidates);
		helper(res, candidates, new ArrayList<Integer>(), target, 0,0);
		return res;

	}

	private void helper(List<List<Integer>> res, int[] candidates, ArrayList<Integer> tem, int target, int start,int sum) {
		if (target == sum)
			res.add(new ArrayList<Integer>(tem));
		for (int i = start; i < candidates.length; i++) {
			if(sum+candidates[i]>target) break;
			tem.add(candidates[i]);
			helper(res, candidates, tem, target, i, sum+candidates[i]);
			tem.remove(tem.size() - 1);
		}
	}

	@Test
	public void test() {
		int[] nums = { 2, 3, 6, 7 };
		System.out.println(combinationSum(nums,7));
	}
}
