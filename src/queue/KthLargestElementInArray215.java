package queue;

import java.util.PriorityQueue;

import org.junit.Test;

/**
 * @author he.wu Find the kth largest element in an unsorted array. Note that it
 *         is the kth largest element in the sorted order, not the kth distinct
 *         element.
 * 
 *         Example 1:
 * 
 *         Input: [3,2,1,5,6,4] and k = 2 Output: 5 Example 2:
 * 
 *         Input: [3,2,3,1,2,4,5,5,6] and k = 4 Output: 4
 */
public class KthLargestElementInArray215 {

	@Test
	public void test() {
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		System.out.println(findKthLargest2(nums, 3));
	}

	// Priority queue
	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0 || nums.length < k)
			return -1;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k + 1);
		for (int ele : nums) {
			pq.add(ele);
			if (pq.size() > k)
				pq.poll();
		}
		return pq.poll();
	}

	// quick select find pivot
	public int findKthLargest2(int[] nums, int k) {
		if (nums == null || nums.length == 0 || nums.length < k)
			return -1;
		int start = 0, end = nums.length - 1, index = nums.length - k;
		while (start < end) {
			int pivot = partion(nums, start, end);
			if (pivot < index)
				start = pivot + 1;
			else if (pivot > index)
				end = pivot - 1;
			else
				return nums[pivot];
		}
		return nums[start];
	}

	private int partion(int[] nums, int start, int end) {
		int pivot = start, temp;
		while (start <= end) {
			while (start <= end && nums[start] <= nums[pivot])
				start++;
			while (start <= end && nums[end] > nums[pivot])
				end--;
			if (start > end)
				break;
			temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
		}
		temp = nums[end];
		nums[end] = nums[pivot];
		nums[pivot] = temp;
		return end;
	}
}
