package HashTable;

import java.util.HashMap;

import org.junit.Test;

public class findDuplicate {

	public String[] recordNumber(String[] strs) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		if (strs.length == 0 || strs == null)
			return null;
		for (int i = 0; i < strs.length; i++) {
			if (map.containsKey(strs[i])) {
				map.put(strs[i], map.get(strs[i]) + 1);
				strs[i] += String.valueOf(map.get(strs[i]) - 1);
			} else
				map.put(strs[i], 1);
		}
		return strs;
	}

	@Test
	public void test() {
		String[] strs = { "aa", "aa", "cc", "bb" };
		String[] s = recordNumber(strs);
		for(String str : s)
			System.out.print(str + " ");
	}
	
	public static void main(String[] args) {
		String[] strs = { "aa", "aa", "cc", "bb" };
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < strs.length; i++) {
			if (map.containsKey(strs[i])) {
				map.put(strs[i], map.get(strs[i]) + 1);
				strs[i] += String.valueOf(map.get(strs[i]) - 1);
			} else
				map.put(strs[i], 1);
		}
		for(String str : strs)
			System.out.print(str + " ");
	}
}
