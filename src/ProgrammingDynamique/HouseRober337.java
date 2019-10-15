package ProgrammingDynamique;

import org.junit.Test;

/**
 * @author he.wu The thief has found himself a new place for his thievery again.
 *         There is only one entrance to this area, called the "root." Besides
 *         the root, each house has one and only one parent house. After a tour,
 *         the smart thief realized that "all houses in this place forms a
 *         binary tree". It will automatically contact the police if two
 *         directly-linked houses were broken into on the same night.
 * 
 *         Determine the maximum amount of money the thief can rob tonight
 *         without alerting the police.
 * 
 *         Example 1:
 * 
 *         Input: [3,2,3,null,3,null,1]
 * 
 *         3 
 *        / \ 
 *        2 3 
 *         \ \ 
 *          3 1
 * 
 *         Output: 7 Explanation: Maximum amount of money the thief can rob = 3
 *         + 3 + 1 = 7. Example 2:
 * 
 *         Input: [3,4,5,1,3,null,1]
 * 
 *         3 
 *        / \ 
 *        4 5 
 *        / \ \
 *        1 3 1
 * 
 *         Output: 9 Explanation: Maximum amount of money the thief can rob = 4
 *         + 5 = 9.
 */
public class HouseRober337 {
	
	public int Rob(int[] nums)
	{
		if(nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		return 0;
	}
	
	@Test
	public void test() {
		
	}

}
