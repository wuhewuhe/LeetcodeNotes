package queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * @author he.wu Given a non-empty array of integers, return the k most frequent
 *         elements.
 * 
 *         Example 1:
 * 
 *         Input: nums = [1,1,1,2,2,3], k = 2 Output: [1,2] Example 2:
 * 
 *         Input: nums = [1], k = 1 Output: [1] Note:
 * 
 *         You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 *         Your algorithm's time complexity must be better than O(n log n),
 *         where n is the array's size.
 */
public class TopKFrequentElement347 {
	// priority queue
	public List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		// count frequency
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));
		for (int n : map.keySet()) {
			pq.add(n);
			if (pq.size() > k)
				pq.poll();
		}
		List<Integer> res = new ArrayList<Integer>();
		for (int i : pq)
			res.add(i);
		Collections.reverse(res);
		return res;
	}

	@Test
	public void test() {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		System.out.println(topKFrequent(nums, k));
	}
}
