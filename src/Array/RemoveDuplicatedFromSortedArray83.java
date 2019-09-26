package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * @author he.wu Given a sorted array nums, remove the duplicates in-place such
 *         that each element appear only once and return the new length.
 * 
 *         Do not allocate extra space for another array, you must do this by
 *         modifying the input array in-place with O(1) extra memory.
 */
public class RemoveDuplicatedFromSortedArray83 {

	@Test
	public void test() {
		int[] nums = { 0,0,1,1,1,2,2,3,3,4 };
		System.out.println(RemoveDuplictaed3(nums));
	}

	// remove duplicate from unsorted array
	// time o(n) space o(n)
	public int RemoveDuplictaed(int[] nums) {
		if (nums.length == 0)
			return 0;
		Set<Integer> set = new HashSet<Integer>();
		for (int i : nums) {
			set.add(i);
		}
		return set.size();
	}
	
	//time o(n) space o(n)
	public int RemoveDuplictaed3(int[] nums) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int i = 0; i < nums.length; i++) {
			if(!map.containsKey(nums[i]))
				map.put(nums[i], i);
		}
		return map.size();
	}

	// remove from sorted array time o(n) space o(1)
	public int RemoveDuplictaed2(int[] nums) {
		if (nums.length == 0 || nums == null)
			return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[j-1]) {
				i++;
				nums[i] =nums[j];
			}
		}
		return i + 1;
	}
	
	//two pointer
	/*
	 * fast pointer j who traverse the array, slower pointer record the distinct value
	 * */
	public int RemoveDuplictaed4(int[] nums) {
		if (nums.length == 0 || nums == null)
			return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] =nums[j];
			}
		}
		return i + 1;
	}
}
