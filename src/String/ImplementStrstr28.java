package String;

import org.junit.Test;

/**
 * @author mac Implement strStr().
 * 
 *         Return the index of the first occurrence of needle in haystack, or -1
 *         if needle is not part of haystack.
 * 
 *         Example 1:
 * 
 *         Input: haystack = "hello", needle = "ll" Output: 2 Example 2:
 * 
 *         Input: haystack = "aaaaa", needle = "bba" Output: -1 Clarification:
 * 
 *         What should we return when needle is an empty string? This is a great
 *         question to ask during an interview.
 * 
 *         For the purpose of this problem, we will return 0 when needle is an
 *         empty string. This is consistent to C's strstr() and Java's
 *         indexOf().
 */
public class ImplementStrstr28 {
	public int strStr(String haystack, String needle) {
		return haystack.indexOf(needle);
	}

	// realise index of manuel
	public int strStr2(String s, String t) {
		if (t.isEmpty())
			return 0; // edge case: "",""=>0 "a",""=>0
		for (int i = 0; i <= s.length() - t.length(); i++) {
			for (int j = 0; j < t.length() && s.charAt(i + j) == t.charAt(j); j++)
				if (j == t.length() - 1)
					return i;
		}
		return -1;
	}
	
	//kmp pattern matching solution
	public int strStr3(String haystack, String needle) {
		 // empty needle appears everywhere, first appears at 0 index
        if (needle.length() == 0)
            return 0;
        if (haystack.length() == 0)
            return -1;
        
        
        for (int i = 0; i < haystack.length(); i++) {
            // no enough places for needle after i
            if (i + needle.length() > haystack.length()) break;
            
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j))
                    break;
                if (j == needle.length()-1)
                    return i;
            }
        }
        
        return -1;
	}
	

	@Test
	public void test() {
		System.out.println(strStr2("hello", "ll"));
	}
}
