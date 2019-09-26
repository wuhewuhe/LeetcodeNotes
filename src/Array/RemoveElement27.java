package Array;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author he.wu Given an array nums and a value val, remove all instances of
 *         that value in-place and return the new length.
 * 
 *         Do not allocate extra space for another array, you must do this by
 *         modifying the input array in-place with O(1) extra memory.
 * 
 *         The order of elements can be changed. It doesn't matter what you
 *         leave beyond the new length.
 * 
 *         Example 1:
 * 
 *         Given nums = [3,2,2,3], val = 3,
 * 
 *         Your function should return length = 2, with the first two elements
 *         of nums being 2.
 * 
 *         It doesn't matter what you leave beyond the returned length.
 * 
 *         Given nums = [0,1,2,2,3,0,4,2], val = 2,
 * 
 *         Your function should return length = 5, with the first five elements
 *         of nums containing 0, 1, 3, 0, and 4.
 * 
 *         Note that the order of those five elements can be arbitrary.
 * 
 *         It doesn't matter what values are set beyond the returned length.
 * 
 */
public class RemoveElement27 {

	@Test
	public void test() {
		int[] nums = { 3, 2, 2, 3 };
		System.out.println(RemoveElement2(nums, 3));
	}

	// time o(n) space o(n)
	public int RemoveElement2(int[] nums, int val) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i : nums) {
			if (i != val)
				list.add(i);
		}
		return list.size();
	}

	// two pointer, fast pointer scan the array from head to foot, lower pointer
	// record
	public int RemoveElement(int[] nums, int val) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[count] = nums[i];
				count++;
			}
		}
		return count;
	}

	// Two Pointers - when elements to remove are rare
	/*
	 * When we encounter nums[i] = valnums[i]=val, we can swap the current element out with the last element and dispose the last one. 
	 * This essentially reduces the array's size by 1.
	 * 
	 * Note that the last element that was swapped in could be the value you want to remove itself. 
	 * But don't worry, in the next iteration we will still check this element.
	 * */
	public int RemoveElement3(int[] nums, int val) {
		int i = 0, n = nums.length;
		while (i > n) {
			if (nums[i] == val) {
				nums[i] = nums[n - 1];
				n--;
			} else
				i++;
		}
		return n;
	}

}
