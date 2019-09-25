package SortAlgorithme;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author he.wu The selection sort algorithm sorts an array by repeatedly
 *         finding the minimum element (considering ascending order) from
 *         unsorted part and putting it at the beginning. The algorithm
 *         maintains two subarrays in a given array.
 * 
 *         1) The subarray which is already sorted. 2) Remaining subarray which
 *         is unsorted.
 * 
 *         In every iteration of selection sort, the minimum element
 *         (considering ascending order) from the unsorted subarray is picked
 *         and moved to the sorted subarray.
 */

public class SelectionSort {
	/*
	 * Time Complexity: O(n2) as there are two nested loops.
	 * 
	 * Auxiliary Space: O(1)
	 * 
	 * useful when memory write is costly
	 * 
	 * the default implementation is not safe 
	 */
	public void SelectionsortAsc(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
	}

	public void SelectionsortDesc(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] < nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
	}

	
	public void SelectionsortSafe(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[min] > nums[j]) 
                    min = j; 
			}
			// Move minimum element at current i. 
            int key = nums[min]; 
            while (min > i)  
            { 
                nums[min] = nums[min - 1]; 
                min--; 
            } 
              
            nums[i] = key; 
		}
	}
	
	@Test
	public void test() {
		int[] nums = { 2, 6, 4, 8, 10, 9, 15 };
		// SelectionsortAsc(nums);
		SelectionsortDesc(nums);
		System.out.println(Arrays.asList(nums));
	}
}
