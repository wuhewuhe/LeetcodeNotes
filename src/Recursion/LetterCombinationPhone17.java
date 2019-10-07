package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class LetterCombinationPhone17 {

	// recursion
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		if (digits == null || digits.length() == 0)
			return res;
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("2", "abc");
		map.put("3", "edf");
		map.put("4", "ghi");
		map.put("5", "jkl");
		map.put("6", "mno");
		map.put("7", "pqrs");
		map.put("8", "tuv");
		map.put("9", "wxyz");
		map.put("0", " ");
		map.put("1", " ");
		dfs(res, digits, map, "");
		return res;
	}

//	private void dfs(List<String> res, String digits, HashMap<String, String> map, String str) {
//		// exit
//		if (digits.length() == 0)
//			res.add(str);
//		else {
//			// recursion condition, iterator over all letter with map
//			String curr = digits.substring(0, 1);
//			String letters = map.get(curr);
//			for (int i = 0; i < letters.length(); i++) {
//				String letter = map.get(curr).substring(i, i + 1);
//				// append the current letter to the combination and proceed to the next digits
//				dfs(res, digits.substring(1), map, str + letter);
//			}
//		}
//	}
	
	private void dfs(List<String> res, String digits, HashMap<String, String> map, String str) {
		// exit
		if (digits.length() == 0)
			res.add(str);
		else {
			// recursion condition, iterator over all letter with map
			String letters = map.get(digits.substring(0, 1));
			for (int i = 0; i < letters.length(); i++) {
				String letter = map.get(digits.substring(0, 1)).substring(i, i + 1);
				// append the current letter to the combination and proceed to the next digits
				dfs(res, digits.substring(1), map, str + letter);
			}
		}
	}

	public List<String> letterCombinations2(String digits) {
		char[][] dict = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' }, { 'm', 'n', 'o' },
				{ 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
		List<String> ans = new ArrayList<>();
		if (digits.length() == 0)
			return ans;
		helper(dict, digits, 0, "", ans);
		return ans;
	}

	private void helper(char[][] dict, String digits, int index, String part, List<String> ans) {
		if(index == digits.length())
			ans.add(part);
		else {
			char curr = digits.charAt(index);
			int i = curr - '2';
			char[] options = dict[i];
			for(char c : options) {
				helper(dict,digits,index+1,part+c,ans);
			}
		}
	}

	@Test
	public void test() {
		System.out.println(letterCombinations("23"));
	}
}
