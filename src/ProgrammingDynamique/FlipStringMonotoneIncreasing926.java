package ProgrammingDynamique;

import org.junit.Test;

public class FlipStringMonotoneIncreasing926 {
	public int minFlipsMonoIncr(String S) {
		if (S == null || S.length() <= 0)
			return 0;

		char[] sChars = S.toCharArray();
		int flipCount = 0;
		int onesCount = 0;

		for (int i = 0; i < sChars.length; i++) {
			if (sChars[i] == '0') {
				if (onesCount != 0) {
					// change zero to one
					flipCount++;
				}
			} else {
				onesCount++;
			}
			// change zero to one
			if (flipCount > onesCount) {
				flipCount = onesCount;
			}
		}
		return flipCount;
	}

	

	@Test
	public void test() {
		String s = "000110000";
		System.out.println(minFlipsMonoIncr(s));
	}

}
