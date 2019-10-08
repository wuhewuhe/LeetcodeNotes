package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * @author he.wu Given a collection of candidate numbers (candidates) and a
 *         target number (target), find all unique combinations in candidates
 *         where the candidate numbers sums to target.
 * 
 *         Each number in candidates may only be used once in the combination.
 * 
 *         Note:
 * 
 *         All numbers (including target) will be positive integers. The
 *         solution set must not contain duplicate combinations. Example 1:
 * 
 *         Input: candidates = [10,1,2,7,6,1,5], target = 8, A solution set is:
 *         [ [1, 7], [1, 2, 5], [2, 6], [1, 1, 6] ] Example 2:
 * 
 *         Input: candidates = [2,5,2,1,2], target = 5, A solution set is: [
 *         [1,2,2], [5] ]
 */
public class CombinationSumII40 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (candidates.length == 0 || candidates == null)
			return res;
		Arrays.sort(candidates);
		dfs(res, new ArrayList<Integer>(), candidates, target, 0, 0);
		return res;
	}

	private void dfs(List<List<Integer>> res, ArrayList<Integer> tem, int[] candidates, int target, int sum,
			int start) {
		if (target == sum)
			res.add(new ArrayList<Integer>(tem));
		for (int i = start; i < candidates.length; i++) {
			if (candidates[i] > target || sum + candidates[i] > target)
				break;
			tem.add(candidates[i]);
			dfs(res, tem, candidates, target, sum + candidates[i], i + 1);
			tem.remove(tem.size() - 1);
			while(i<candidates.length-1 && candidates[i]==candidates[i+1]) i++;
		}
	}

	@Test
	public void test() {
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		System.out.println(combinationSum2(candidates,target));
	}
}
