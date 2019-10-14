package Math;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author he.wu Implement pow(x, n), which calculates x raised to the power n
 *         (xn).
 * 
 *         Example 1:
 * 
 *         Input: 2.00000, 10 Output: 1024.00000 Example 2:
 * 
 *         Input: 2.10000, 3 Output: 9.26100 Example 3:
 * 
 *         Input: 2.00000, -2 Output: 0.25000 Explanation: 2-2 = 1/22 = 1/4 =
 *         0.25
 */
public class POW50 {

	public double myPowAuto(double x, int n) {
		return Math.pow(x, n);
	}

	// pass time limit
	public double myPow(double x, int n) {
		if (x <= -100 || x >= 100 || x == 0)
			return 0;
		double res = x;
		if (n > 0) {
			while (n - 1 > 0) {
				res = res * x;
				n--;
			}
		} else if (n == 0)
			return 1;
		else {
			n = -n;
			while (n - 1 > 0) {
				res = res * x;
				n--;
			}
			res = 1 / res;
		}
		return res;
	}

	// recursion
	public double myPow2(double x, int n) {
		Map<Long, Double> map = new HashMap<Long, Double>();
		long m = Math.abs(n);
		x = n > 0 ? x : 1 / x;
		return magic(x, m, map);
	}

	private double magic(double x, long m, Map<Long, Double> map) {
		// TODO Auto-generated method stub
		if (m == 0)
			return 1;
		if (m == 1)
			return x;
		double res = x;
		long count = 1l;
		// like 2^2 * 2^2 = 2^4
		while (count * 2 <= m) {
			res *= res;
			count *= 2;
			map.put(count, res);
		}
		return res * magic(x, m - count, map);
	}

	/*
	 * exponentiating by squaring time complex from o(n) to o(logn) for ex, we wanna
	 * calculate 2^11 -> 2^(1011) -> 2^8 * 2^2 * 2^1 >> operator can remove the last
	 * bit number, and & operator can know the last number is 1 or not
	 */
	double quick_pow(double base, int r) {
		double ans = 1;
		while (r != 0) {
			if ((r & 1) != 0)
				ans *= base;
			base *= base;
			r >>= 1;
		}
		return ans;
	}

	public double myPow3(double x, int n) {
		if (x <= -100 || x >= 100 || x == 0)
			return 0;
		
		if(n<0) {
			n = -n;
			return 1/quick_pow(x,n);
		}
		else if(n == 0)
				return 1;
		else return quick_pow(x,n);
	}
	
	//the best algo
	public double myPow4(double x, int n) {
		 if(n == 0)
           return 1;
       
       double temp = myPow(x,n/2);
       
       if((n%2 == 0)){
           return temp*temp;
       }
       else{
           if(n > 0)
               return x*temp*temp;
           else
               return (temp*temp)/x;
       }        
   }

	@Test
	public void test() {
		System.out.println(myPow3(2, 10));
	}

}
