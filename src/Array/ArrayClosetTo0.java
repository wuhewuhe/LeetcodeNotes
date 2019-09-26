package Array;

import java.util.Arrays;

import org.junit.Test;

public class ArrayClosetTo0 {
	
	//time o(nlogn) space o(1)
	public int ClosetToZero(int[] nums) {
		Arrays.sort(nums);
		int near = Integer.MAX_VALUE;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (Math.abs(nums[i]) < Math.abs(nums[i + 1]))
				near = nums[i];
		}
		return near;
	}

	@Test
	public void test() {
		int[] nums = { -2, -1, 10, 1 };
		System.out.println(ClosetToZero(nums));
	}
}
