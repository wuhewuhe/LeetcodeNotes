package TwoPointer;

import java.util.Stack;

import org.junit.Test;

/**
 * @author mac Given n non-negative integers representing an elevation map where
 *         the width of each bar is 1, compute how much water it is able to trap
 *         after raining.
 * 
 * 
 *         The above elevation map is represented by array
 *         [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue
 *         section) are being trapped. Thanks Marcos for contributing this
 *         image!
 * 
 *         Example:
 * 
 *         Input: [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6
 */
public class TrappingRainWater42 {
	// dynamic program
	public int trap(int[] height) {
		if (height.length == 0 || height == null)
			return 0;
		int n = height.length, sum = 0;
		int[] left = new int[n];
		int[] right = new int[n];
		left[0] = height[0];
		right[n - 1] = height[n - 1];
		for (int i = 1; i < n; i++) {
			left[i] = Math.max(height[i], left[i - 1]);
		}
		for (int i = 2; i <= n; i++) {
			right[n - i] = Math.max(height[n - i], right[n - i + 1]);
		}
		for (int i = 0; i < n; i++) {
			sum += (Math.min(left[i], right[i]) - height[i]);
		}
		return sum;
	}

	// two pointer
	public int trap2(int[] height) {
		if (height.length < 3 || height == null)
			return 0;
		int n = height.length, sum = 0, left = 0, right = n - 1;
		int left_max = height[left], right_max = height[right];
		while (left < right) {
			if (left_max <= right_max) {
				sum += (left_max - height[left++]);
				left_max = Math.max(left_max, height[left]);
			} else {
				sum += (right_max - height[right--]);
				right_max = Math.max(right_max, height[right]);
			}
		}
		return sum;
	}

	// stack
	public int trap3(int[] height) {
		if (height.length < 3)
			return 0;
		int ans = 0, cur = 0;
		Stack<Integer> stack = new Stack<Integer>();
		while (cur < height.length) {
			while (!stack.isEmpty() && height[cur] > height[stack.peek()]) {
				int top = stack.peek();
				stack.pop();
				if (stack.isEmpty())
					break;
				int distance = cur - stack.peek() - 1;
				int bounded_height = Math.min(height[cur], height[stack.peek()]) - height[top];
				ans += distance * bounded_height;
			}
			stack.push(height[cur++]);
		}
		return ans;
	}

	// brute force
	public int trap4(int[] height) {
		if (height.length < 3)
			return 0;
		int ans = 0, n = height.length;
		int max_left = 0, max_right = 0;
		for (int i = 0; i < height.length; i++) {
			if (max_left < height[i])
				max_left = height[i];
			max_right = 0;
			for (int j = n - 1; j >= i; j--) {
				if (max_right < height[j])
					max_right = height[j];
			}
			ans += (Math.min(max_right, max_left) - height[i]);
		}
		return ans;
	}

	@Test
	public void test() {
		int[] nums = { 0,1,0,2,1,0,1,3,2,1,2,1 };
		System.out.println(trap4(nums));
	}
}
