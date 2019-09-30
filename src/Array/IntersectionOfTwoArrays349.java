package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author he.wu Given two arrays, write a function to compute their
 *         intersection.
 * 
 *         Example 1:
 * 
 *         Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2] Example 2:
 * 
 *         Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4] Output: [9,4] Note:
 * 
 *         Each element in the result must be unique. The result can be in any
 *         order.
 */
public class IntersectionOfTwoArrays349 {
	// stream
	public int[] Intersection(int[] nums1, int[] nums2) {
		return Arrays.stream(nums1).distinct().filter(x -> Arrays.stream(nums2).anyMatch(y -> y == x)).toArray();
	}

	// set
	public int[] Intersection2(int[] nums1, int[] nums2) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		for (Integer n : nums1)
			set1.add(n);
		HashSet<Integer> set2 = new HashSet<Integer>();
		for (Integer n : nums2)
			set2.add(n);
		set1.retainAll(set2);
		int[] output = new int[set1.size()];
		int idx = 0;
		for (int s : set1)
			output[idx++] = s;
		return output;
	}

	// set revo
	public int[] Intersection3(int[] nums1, int[] nums2) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		HashSet<Integer> set2 = new HashSet<Integer>();
		for (Integer n : nums1)
			set1.add(n);
		for (int i = 0; i < nums2.length; i++) {
			if (set1.contains(nums2[i]))
				set2.add(nums2[i]);
		}
		int[] output = new int[set2.size()];
		int idx = 0;
		for (int s : set2)
			output[idx++] = s;
		return output;
	}

	// binary search
	public int[] Intersection4(int[] nums1, int[] nums2) {
		Arrays.sort(nums2);
		Set<Integer> set = new HashSet<Integer>();
		for (int num : nums1) {
			if (binarySearch(nums2, num))
				set.add(num);
		}

		int i = 0;
		int[] res = new int[set.size()];
		for (Integer num : set) {
			res[i++] = num;
		}
		return res;
	}

	private boolean binarySearch(int[] num, int x) {
		int high = num.length - 1;
		int low = 0;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (x < num[mid]) {
				high = mid - 1;
			} else if (x > num[mid]) {
				low = mid + 1;
			} else {
				return true;
			}
		}

		return false;
	}

}
