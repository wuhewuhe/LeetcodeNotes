package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

/**
 * @author he.wu Given two arrays, write a function to compute their
 *         intersection.
 * 
 *         Example 1:
 * 
 *         Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2,2] Example 2:
 * 
 *         Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4] Output: [4,9] Note:
 * 
 *         Each element in the result should appear as many times as it shows in
 *         both arrays. The result can be in any order. Follow up:
 * 
 *         What if the given array is already sorted? How would you optimize
 *         your algorithm? What if nums1's size is small compared to nums2's
 *         size? Which algorithm is better? What if elements of nums2 are stored
 *         on disk, and the memory is limited such that you cannot load all
 *         elements into the memory at once?
 */
public class IntersectionOfTwoArrays350 {

	public int[] Intersection(int[] nums1, int[] nums2) {
		if (nums1.length == 0)
			return nums1;
		if (nums2.length == 0)
			return nums2;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			if (map.containsKey(nums1[i]))
				map.put(nums1[i], map.get(nums1[i]) + 1);
			else
				map.put(nums1[i], 1);
		}

		for (int i = 0; i < nums2.length; i++) {
			if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
				result.add(nums2[i]);
				map.put(nums2[i], map.get(nums2[i]) - 1);
			}
		}
		int[] r = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			r[i] = result.get(i);
		}

		return r;
	}

	public int[] Intersect2(int[] nums1, int[] nums2) {
		if (nums1.length == 0)
			return nums1;
		if (nums2.length == 0)
			return nums2;
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0, j = 0, k = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j])
				i++;
			else if (nums2[j] < nums1[i])
				j++;
			else if (nums1[i] == nums2[j]) {
				nums1[k++] = nums1[i];
				i++;
				j++;
			}
		}
		return Arrays.copyOfRange(nums1, 0, k);
	}

	@Test
	public void test() {
		int[] nums1 = { 4, 4, 9, 5 }, nums2 = { 9, 4, 9, 8, 4 };
		System.out.println(Intersection(nums1, nums2));

		// best way for java convert list to array
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		int[] arr = list.stream().mapToInt(x -> x).toArray();
	}
}
