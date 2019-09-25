package SortAlgorithme;

import org.junit.Test;

public class BubbleSort {

	public void Bubblesort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if(nums[i] > nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
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
		int[] nums = { 64, 34, 25, 12, 22, 11, 90 };
		Bubblesort(nums);
		System.out.println(nums);
	}
}
