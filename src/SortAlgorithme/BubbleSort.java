package SortAlgorithme;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author he.wu bubble sort is a safe sort [1,2,3,4,1],a[0]=a[4] after sorted,
 *         a[0] is also before a[4], event though it same value
 */
public class BubbleSort {

	

	/*
	 * temps complex worst o(n^2) when array is reverse, best case is O(n) when
	 * array is sorted auxiliary space o(1) compare repeatedly and swapping the
	 * adjacent elements if they are in wrong order find the largest one by one sort
	 * pattern ****** ***** **** *** ** *
	 */
	public void BubblesortAsc(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 0; j < nums.length - i - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					int temp = nums[j + 1];
					nums[j + 1] = nums[j];
					nums[j] = temp;
				}
			}
		}
	}
	
	public void BubblesortDesc(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 0; j < nums.length - i - 1; j++) {
				if (nums[j] < nums[j + 1]) {
					int temp = nums[j + 1];
					nums[j + 1] = nums[j];
					nums[j] = temp;
				}
			}
		}
	}

	public void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	@Test
	public void test() {
		int[] nums = { 1, 4, 1, 2, 3 };
		//BubblesortAsc(nums);
		BubblesortDesc(nums);
		Arrays.asList(nums).stream().forEach(System.out::print);
	}
}
