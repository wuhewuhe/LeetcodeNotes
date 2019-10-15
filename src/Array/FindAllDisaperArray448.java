package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class FindAllDisaperArray448 {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list = new LinkedList<Integer>();
		if (nums.length == 0 || nums == null)
			return list;
		int[] ans = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			ans[nums[i] - 1]++;
		}
		for (int j = 0; j < ans.length; j++) {
			if (ans[j] == 0)
				list.add(j + 1);
		}
		return list;
	}

	// hashtable solution
	public List<Integer> findDisappearedNumbers2(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		if (nums == null || nums.length == 0)
			return list;
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for (int i : nums) {
			map.put(i, true);
		}
		for (int i = 1; i <= nums.length; i++) {
			if (!map.containsKey(i))
				list.add(i);
		}
		return list;

	}

	// space in place modification
	public List<Integer> findDisappearedNumbers3(int[] nums) {
		List<Integer> list = new LinkedList<Integer>();
		if (nums.length == 0 || nums == null)
			return list;
		for (int i : nums) {
			int index = Math.abs(i) - 1;
			if (nums[index] > 0)
				nums[index] *= -1;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0)
				list.add(i + 1);
		}
		return list;
	}

	@Test
	public void test() {
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		System.out.println(findDisappearedNumbers3(nums));
	}

}
