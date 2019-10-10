package Math;

import org.junit.Test;

/**
 * @author he.wu Count the number of prime numbers less than a non-negative
 *         number, n.
 * 
 *         Example:
 * 
 *         Input: 10 Output: 4 Explanation: There are 4 prime numbers less than
 *         10, they are 2, 3, 5, 7.
 */
public class CountPrime204 {
	public boolean isPrime(int n) {
		// prime number is superior than 1, number 2 is only even prime number
		if (n < 2)
			return false;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	// brutal force time n^2
	public int countPrimes(int n) {
		int ans = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime(i))
				ans++;
		}
		return ans;
	}

	public int countPrimes2(int n) {
		if (n <= 2)
			return 0;
		boolean[] bool = new boolean[n + 1];
		bool[2] = true;
		//from 3 all of odd number is prime
		for (int i = 3; i < n; i += 2) {
			bool[i] = true;
		}
		//square of a number assuming the range
		for (int p = 3; p * p <= n; p++) {
			if (bool[p]) {
				//give prime two the multiple 
				for (int i = p + p; i <= n; i += p) {
					bool[i] = false;
				}
			}
		}
		int count = 1;
		for (int i = 3; i < n; i += 2) {
			count += bool[i] ? 1 : 0;
		}
		return count;
	}

	@Test
	public void test() {
		System.out.println(countPrimes2(10));
	}
}
