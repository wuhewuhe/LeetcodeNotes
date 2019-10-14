package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author he.wu Given an array of strings, group anagrams together.
 * 
 *         Example:
 * 
 *         Input: ["eat", "tea", "tan", "ate", "nat", "bat"], Output: [
 *         ["ate","eat","tea"], ["nat","tan"], ["bat"] ]
 */
public class GroupAnagrams49 {
	// categorize by sorted string
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (strs == null || strs.length == 0)
			return res;
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			char[] c = str.toCharArray();
			Arrays.sort(c);
			String key = String.valueOf(c);
			if (!map.containsKey(key))
				map.put(key, new ArrayList<String>());
			map.get(key).add(str);
		}
		return new ArrayList<List<String>>(map.values());
	}

	// category by count
	public List<List<String>> groupAnagrams2(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (strs.length == 0)
			return res;
		int[] count = new int[128];
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			Arrays.fill(count, 0);
			for (char c : str.toCharArray())
				count[c]++;
			StringBuilder sb = new StringBuilder("");
			for (int i = 97; i < 123; i++) {
				sb.append('#');
				sb.append(count[i]);
			}
			String key = sb.toString();
			if (!map.containsKey(key))
				map.put(key, new ArrayList<String>());
			map.get(key).add(str);
		}
		return new ArrayList<List<String>>(map.values());
	}

}
