package BitManipulation;

import org.junit.Test;

public class PowerofFour342 {
	public boolean isPowerOfFour(int n) {
		return (Math.log10(n) / Math.log10(4)) % 1 == 0;
	}

	public boolean isPowerOfFour2(int num) {
		return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
		// 0x55555555 is to get rid of those power of 2 but not power of 4
		// so that the single 1 bit always appears at the odd position
	}

	public boolean isPowerOfFour3(int num) {
		return Integer.toString(num, 4).matches("10*");
	}

	@Test
	public void test() {
		System.out.println(Integer.toString(8, 4));
	}
}
