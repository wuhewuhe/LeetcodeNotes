package HashMap;

import java.util.TreeMap;

public class Iterator {

	public static void main(String[] args) {
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		map.put(0, 0);
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		java.util.Iterator<Integer> iterator = map.keySet().iterator(); 
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
