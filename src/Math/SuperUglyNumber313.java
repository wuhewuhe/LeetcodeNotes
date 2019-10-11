package Math;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * @author he.wu Write a program to find the nth super ugly number.
 * 
 *         Super ugly numbers are positive numbers whose all prime factors are
 *         in the given prime list primes of size k.
 * 
 *         Example:
 * 
 *         Input: n = 12, primes = [2,7,13,19] Output: 32 Explanation:
 *         [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
 *         super ugly numbers given primes = [2,7,13,19] of size 4.
 */
public class SuperUglyNumber313 {
	// priority queue for searching the K th
	public int nthSuperUglyNumber2(int n, int[] primes) {
		if (n == 1)
			return 1;
		int[] ugly = new int[n];
		int[] idx = new int[primes.length];
		int[] val = new int[primes.length];
		Arrays.fill(val, 1);
		
		int next = 1;
		for (int i = 0; i < n; i++) {
			// find next
			ugly[i] = next;
			
			next = Integer.MAX_VALUE;
			for (int j = 0; j < primes.length; j++) {
				if (val[j] == ugly[i]) val[j] = ugly[idx[j]++] * primes[j];
				next = Math.min(next, val[j]);
			}
		}
		return ugly[n - 1];
	}

	public int nthSuperUglyNumber(int n, int[] primes) {
		if (n == 1)
			return 1;
		int[] ugly = new int[n];
		int[] idx = new int[primes.length];

		ugly[0] = 1;
		for (int i = 1; i < n; i++) {
			// find next
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < primes.length; j++) {
				int cur = primes[j] * ugly[idx[j]];
				min = Math.min(min, cur);
			}
			ugly[i] = min;
			for (int j = 0; j < idx.length; j++) {
				int cur = primes[j] * ugly[idx[j]];
				if (cur == min)
					idx[j]++;
			}
		}
		return ugly[n - 1];
	}
	
	public class Factor{
	    int index = 0;
	    final int val;
	    int factorVal;

	    public Factor(int val){
	        this.val = val;
	        factorVal = val;
	    }
	}

	public int nthSuperUglyNumber3(int n, int[] primes) {
	    if(primes == null || primes.length == 0) return -1;

	    Comparator<Factor> comparator = (a, b) -> Integer.compare( a.factorVal, b.factorVal);
	    PriorityQueue<Factor> queue = new PriorityQueue<>(comparator);
	    for (int prime : primes){
	        Factor factor = new Factor(prime);
	        queue.offer(factor);
	    }

	    int[] superUgly = new int[n];
	    superUgly[0] = 1;

	    for(int i=1;i<n;i++){
	        Factor factorNeeded = queue.poll();
	        if(factorNeeded.factorVal == superUgly[i-1]){
	            i--;
	        } else {
	            superUgly[i] = factorNeeded.factorVal;
	        }

	        factorNeeded.factorVal = factorNeeded.val * superUgly[++factorNeeded.index];
	        queue.offer(factorNeeded);
	    }
	    return superUgly[n-1];
	}

	@Test
	public void test() {
		int[] arr = { 2, 7, 13, 19 };
		System.out.println(nthSuperUglyNumber2(15, arr));
	}
}
