package queue;

import java.util.HashMap;

import org.junit.Test;

/**
 * @author he.wu Given a string, find the first non-repeating character in it
 *         and return it's index. If it doesn't exist, return -1.
 * 
 *         Examples:
 * 
 *         s = "leetcode" return 0.
 * 
 *         s = "loveleetcode", return 2. Note: You may assume the string contain
 *         only lowercase letters.
 */
public class FindUniqueCharacterString287 {
	public int firstUniqChar(String s) {
		if (s == null || s.length() == 0)
			return -1;
		if (s.length() == 1)
			return 0;
		int[] hash = new int[26];
		for (char c : s.toCharArray()) {
			hash[c - 'a']++;
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(hash[c-'a'] == 1)
				return i;
		}
		return -1;
	}
	
	
	public int firstUniqChar2(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1) 
                return i;
        }
        return -1;
    }
	
	@Test
	public void test() {
		String s ="llee";
		System.out.println(firstUniqChar(s));
	}
}
