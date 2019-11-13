package TwoPointer;

import org.junit.Test;

/**
 * @author he.wu Today, the bookstore owner has a store open for
 *         customers.length minutes. Every minute, some number of customers
 *         (customers[i]) enter the store, and all those customers leave after
 *         the end of that minute.
 * 
 *         On some minutes, the bookstore owner is grumpy. If the bookstore
 *         owner is grumpy on the i-th minute, grumpy[i] = 1, otherwise
 *         grumpy[i] = 0. When the bookstore owner is grumpy, the customers of
 *         that minute are not satisfied, otherwise they are satisfied.
 * 
 *         The bookstore owner knows a secret technique to keep themselves not
 *         grumpy for X minutes straight, but can only use it once.
 * 
 *         Return the maximum number of customers that can be satisfied
 *         throughout the day.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X =
 *         3 Output: 16 Explanation: The bookstore owner keeps themselves not
 *         grumpy for the last 3 minutes. The maximum number of customers that
 *         can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 * 
 * 
 *         Note:
 * 
 *         1 <= X <= customers.length == grumpy.length <= 20000 0 <=
 *         customers[i] <= 1000 0 <= grumpy[i] <= 1
 */
public class GrumpyBookStoreOwner1052 {
	public int maxSatisfied(int[] customers, int[] grumpy, int X) {
		int satisfied = 0, maxMakeSatisfied = 0;
		for (int i = 0, win = 0; i < grumpy.length; ++i) {
			if (grumpy[i] == 0) {
				satisfied += customers[i];
			} else {
				win += customers[i];
			}
			if (i >= X) { // window's size > X.
				win -= grumpy[i - X] * customers[i - X]; // to maintain the size as X, remove unsastified customers from
															// left end of the window.
			}
			maxMakeSatisfied = Math.max(win, maxMakeSatisfied);
		}
		return satisfied + maxMakeSatisfied;
	}

	public int maxSatisfied2(int[] customers, int[] grumpy, int X) {
		// 1. 计算原本就开心的客户数量 n base
		int baseCount = 0;
		for (int i = 0; i < customers.length; i++) {
			if (grumpy[i] == 0) {
				baseCount += customers[i];
			}
		}

		// 2. 生成 不开心客户的数组
		int[] sadCustomers = new int[customers.length];
		for (int i = 0; i < customers.length; i++) {
			if (grumpy[i] == 1) {
				sadCustomers[i] = customers[i];
			}
		}

		// 3. 计算 X 分钟板蓝根 所带来的最大收益
		// 3.1 先计算 前 X 分钟的收益
		int gain = 0;
		for (int i = 0; i < X; i++) {
			gain += sadCustomers[i];
		}

		// 3.2 采用 改变量 计算接下来每个区间的 收益并 记录最大值
		int maxGain = gain;
		for (int i = X; i < sadCustomers.length; i++) {
			gain += sadCustomers[i];
			gain -= sadCustomers[i - X];
			if (gain > maxGain) {
				maxGain = gain;
			}
		}

		// 4. 求和
		return baseCount + maxGain;
	}

	@Test
	public void test() {
		int[] customers = { 1, 0, 1, 2, 1, 1, 7, 5 }, grumpy = { 0, 1, 0, 1, 0, 1, 0, 1 };
		int x = 3;
		System.out.println(maxSatisfied2(customers, grumpy, x));
	}
}
