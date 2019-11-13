package TwoPointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * @author he.wu n a row of trees, the i-th tree produces fruit with type
 *         tree[i].
 * 
 *         You start at any tree of your choice, then repeatedly perform the
 *         following steps:
 * 
 *         Add one piece of fruit from this tree to your baskets. If you cannot,
 *         stop. Move to the next tree to the right of the current tree. If
 *         there is no tree to the right, stop. Note that you do not have any
 *         choice after the initial choice of starting tree: you must perform
 *         step 1, then step 2, then back to step 1, then step 2, and so on
 *         until you stop.
 * 
 *         You have two baskets, and each basket can carry any quantity of
 *         fruit, but you want each basket to only carry one type of fruit each.
 * 
 *         What is the total amount of fruit you can collect with this
 *         procedure?
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: [1,2,1] Output: 3 Explanation: We can collect [1,2,1]. Example
 *         2:
 * 
 *         Input: [0,1,2,2] Output: 3 Explanation: We can collect [1,2,2]. If we
 *         started at the first tree, we would only collect [0, 1]. Example 3:
 * 
 *         Input: [1,2,3,2,2] Output: 4 Explanation: We can collect [2,3,2,2].
 *         If we started at the first tree, we would only collect [1, 2].
 *         Example 4:
 * 
 *         Input: [3,3,3,1,2,1,1,2,3,3,4] Output: 5 Explanation: We can collect
 *         [1,2,1,1,2]. If we started at the first tree or the eighth tree, we
 *         would only collect 4 fruits.
 * 
 * 
 *         Note:
 * 
 *         1 <= tree.length <= 40000 0 <= tree[i] < tree.length
 */
public class BasketOfFruits {
	public int totalFruit(int[] tree) {
		if (tree.length < 2)
			return tree.length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int l = 0, count = 0, res = 0;
		for (int i = 0; i < tree.length; i++) {
			if (map.containsKey(tree[i])) {
				map.put(tree[i], map.get(tree[i]) + 1);
			} else {
				map.put(tree[i], 1);
				count++;
			}

			while (count > 2) {
				int tem = tree[l++];
				map.put(tem, map.get(tem) - 1);
				if (map.get(tem) == 0) {
					count--;
					map.remove(tem);
				}
			}
			res = Math.max(res, i - l + 1);
		}
		return res;
	}

	public int totalFruit2(int[] tree) {
		// We'll make a list of indexes for which a block starts.
		List<Integer> blockLefts = new ArrayList<Integer>();

		// Add the left boundary of each block
		for (int i = 0; i < tree.length; ++i)
			if (i == 0 || tree[i - 1] != tree[i])
				blockLefts.add(i);

		// Add tree.length as a sentinel for convenience
		blockLefts.add(tree.length);
		int ans = 0, i = 0;
		search: while (true) {
			// We'll start our scan at block[i].
			// types : the different values of tree[i] seen
			// weight : the total number of trees represented
			// by blocks under consideration
			Set<Integer> types = new HashSet<Integer>();
			int weight = 0;
			// For each block from the i-th and going forward,
			for (int j = i; j < blockLefts.size() - 1; ++j) {
				// Add each block to consideration
				types.add(tree[blockLefts.get(j)]);
				weight += blockLefts.get(j + 1) - blockLefts.get(j);

				// If we have 3+ types, this is an illegal subarray
				if (types.size() >= 3) {
					i = j - 1;
					continue search;
				}
				// If it is a legal subarray, record the answer
				ans = Math.max(ans, weight);
			}
			break;
		}
		return ans;
	}

	public int totalFruit3(int[] tree) {
		int res = 0, cur = 0, count_b = 0, a = 0, b = 0;
		for (int c : tree) {
			cur = c == a || c == b ? cur + 1 : count_b + 1;
			count_b = c == b ? count_b + 1 : 1;
			if (b != c) {
				a = b;
				b = c;
			}
			res = Math.max(res, cur);
		}
		return res;
	}

	@Test
	public void test() {
		int[] nums = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
		System.out.println(totalFruit(nums));
	}
}
