package Math;

import org.junit.Test;

/**
 * @author he.wu Given a positive integer num, write a function which returns
 *         True if num is a perfect square else False.
 * 
 *         Note: Do not use any built-in library function such as sqrt.
 * 
 *         Example 1:
 * 
 *         Input: 16 Output: true Example 2:
 * 
 *         Input: 14 Output: false
 */
public class ValidPerfectSquare367 {
	public boolean isPerfectSquare(int num) {
		double sqr = Math.sqrt(num);
		return sqr - Math.floor(sqr) == 0;
	}

	public boolean isPerfectSquare2(int num) {
		if (num == 1)
			return true;
		int left = 1, right = num / 2;
		 while(left <= right) {
	            int mid = left + (right - left) / 2;
	            if(mid == num / mid) return num % mid == 0;
	            if(mid < num / mid) {
	                left = mid + 1;
	            } else {
	                right = mid - 1;
	            }
	        }
	        return false;
	}

	@Test
	public void test() {
		System.out.println(isPerfectSquare2(64));
	}
}
