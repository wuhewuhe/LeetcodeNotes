package Interview;

import org.junit.Test;

public class SplitString {
	@Test
	public void test() {
		String s = "sdsd fds";
		String[] strs = s.split("#");
		System.out.println(strs);
	}
}
