package TwoPointer;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import org.junit.Test;

/**
 * @author mac Given an array nums, there is a sliding window of size k which is
 *         moving from the very left of the array to the very right. You can
 *         only see the k numbers in the window. Each time the sliding window
 *         moves right by one position. Return the max sliding window.
 * 
 *         Example:
 * 
 *         Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3 Output: [3,3,5,5,6,7]
 *         Explanation:
 * 
 *         Window position Max --------------- ----- [1 3 -1] -3 5 3 6 7 3 1 [3
 *         -1 -3] 5 3 6 7 3 1 3 [-1 -3 5] 3 6 7 5 1 3 -1 [-3 5 3] 6 7 5 1 3 -1
 *         -3 [5 3 6] 7 6 1 3 -1 -3 5 [3 6 7] 7 Note: You may assume k is always
 *         valid, 1 ≤ k ≤ input array's size for non-empty array.
 * 
 *         Follow up:
 */
public class maxSlidingWindow239 {

	// time o(n*k)
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length <= 0)
			return new int[0];
		if (k > nums.length)
			return new int[0];

		// store results
		int[] res = new int[nums.length - k + 1];
		int slow = 0;
		for (int i = k - 1; i < nums.length; i++) {
			int tem = slow, max = nums[i];
			while (tem < i) {
				if (nums[tem] > max)
					max = nums[tem];
				tem++;
			}
			res[slow++] = max;
		}
		return res;
	}

	// tree map and heap
	public int[] maxSlidingWindow2(int[] nums, int k) {
		if (nums == null || nums.length == 0 || nums.length < k) {
			return new int[0];
		}
		int[] result = new int[nums.length - k + 1];
		// tree map is like priority queue, add and remove is log(n) search is height
		TreeMap<Integer, Integer> tm = new TreeMap<>(new Comparator<Integer>() {
			// from high to slow
			@Override
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});
		for (int i = 0; i < nums.length; i++) {
			if (i >= k) {
				if (tm.get(nums[i - k]) == 1) {
					tm.remove(nums[i - k]);
				} else {
					tm.put(nums[i - k], tm.get(nums[i - k]) - 1);
				}
			}

			if (tm.containsKey(nums[i])) {
				tm.put(nums[i], tm.get(nums[i]) + 1);
			} else {
				tm.put(nums[i], 1);
			}

			if (i + 1 >= k) {
				result[i + 1 - k] = tm.firstKey();
			}
		}
		return result;
	}

	public int[] maxSlidingWindow3(int[] nums, int k) {
		int len = nums.length;
		int[] result = new int[len - k + 1];
		if (nums.length == 0)
			return new int[0];
		Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return Integer.compare(i2, i1);
			}
		});

		for (int i = 0; i < k; i++) {
			queue.add(nums[i]);
		}
		result[0] = queue.peek();
		for (int i = k; i < len; i++) {
			queue.remove(nums[i - k]);
			queue.add(nums[i]);
			result[i - k + 1] = queue.peek();
		}

		return result;
	}

	// dequeue monotonic queue
	public int[] maxSlidingWindow4(int[] nums, int k) {
		if (nums == null || k <= 0) {
			return new int[0];
		}
		if (k > nums.length)
			return new int[0];
		int n = nums.length;
		int[] res = new int[n - k + 1];
		int slow = 0;
		// store index add and remove in double side 
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < nums.length; i++) {
			// remove numbers out of range k
			if (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
				q.pollLast();
			}
			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				res[slow++] = nums[q.peek()];
			}
		}
		return res;
	}

	@Test
	public void test() {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		System.out.println(maxSlidingWindow4(nums, k));
	}
}
