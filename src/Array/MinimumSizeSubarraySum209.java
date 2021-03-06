package Array;

import org.junit.Test;

/**
 * @author he.wu Given an array of n positive integers and a positive integer s,
 *         find the minimal length of a contiguous subarray of which the sum ≥
 *         s. If there isn't one, return 0 instead.
 * 
 *         Example:
 * 
 *         Input: s = 7, nums = [2,3,1,2,4,3] Output: 2 Explanation: the
 *         subarray [4,3] has the minimal length under the problem constraint.
 *         Follow up: If you have figured out the O(n) solution, try coding
 *         another solution of which the time complexity is O(n log n).
 */
public class MinimumSizeSubarraySum209 {
	// method manual
	public int minSubArrayLen(int s, int[] nums) {
		if (s == 0 || nums.length == 0 || nums == null)
			return 0;
		int sum = 0, left = 0, min = Integer.MAX_VALUE;
		int[] ans = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum >= s) {
				ans[left] = i + 1 - left;
				left++;
				i = left - 1;
				sum = 0;
				continue;
			}
			if (i == nums.length - 1 && sum < s) {
				ans[left] = Integer.MAX_VALUE;
				left++;
				i = left - 1;
				sum = 0;
			}
		}

		for (int i : ans) {
			min = Math.min(i, min);
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}

	// two pointer, sliding window
	public int minSubArrayLen2(int s, int[] nums) {
		int ans = Integer.MAX_VALUE, left = 0, sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (sum >= s) {
				ans = Math.min(ans, i + 1 - left);
				sum -= nums[left];
				left++;
			}
		}
		return ans == Integer.MAX_VALUE ? 0 : ans;
	}

	// binary search time o(nlogn)
	 public int minSubArrayLen3(int s, int[] nums) {
	        int min = Integer.MAX_VALUE;

	        int[] sums = new int[nums.length];
	        for (int i = 0; i < nums.length; i++)
	            sums[i] = nums[i] + (i == 0 ? 0 : sums[i - 1]);

	        for (int i = 0; i < nums.length; i++) {
	            int j = findWindowEnd(i, sums, s);
	            if (j == nums.length) break;
	            min = Math.min(j - i + 1, min);
	        }
	        
	        return min == Integer.MAX_VALUE ? 0 : min;
	    }

	    private int findWindowEnd(int start, int[] sums, int s) {
	        int i = start, j = sums.length - 1, offset = start == 0 ? 0 : sums[start - 1];
	        while (i <= j) {
	            int m = (i + j) / 2;
	            int sum = sums[m] - offset;
	        if (sum >= s) j = m - 1;
	        else i = m + 1;
	    }
	    return i;
	}
	    
	    public int minSubArrayLen4(int s, int[] nums) {
	        int i = 1, j = nums.length, min = 0;
	        while (i <= j) {
	            int mid = (i + j) / 2;
	            if (windowExist(mid, nums, s)) {
	                j = mid - 1;
	                min = mid;
	            } else i = mid + 1;
	        }
	        return min;
	    }


	    private boolean windowExist(int size, int[] nums, int s) {
	        int sum = 0;
	        for (int i = 0; i < nums.length; i++) {
	            if (i >= size) sum -= nums[i - size];
	            sum += nums[i];
	            if (sum >= s) return true;
	        }
	        return false;
	    }

	@Test
	public void test() {
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		System.out.println(minSubArrayLen3(7, nums));
	}
}
