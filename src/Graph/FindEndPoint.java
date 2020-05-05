package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class FindEndPoint {

	public static int findNetworkEndpoint(final int startNodeId, final int[] fromIds, final int[] toIds) {
		// Write your code here
		// To debug: System.err.println("Debug messages...");
		Map<Integer, List<Integer>> map = new HashMap<>();
		int[] pres = new int[fromIds.length];
		int len = pres.length;
		for (int i = 0; i < len; i++) {
			pres[toIds[i] - 1]++;
		}

		for (int i = 0; i < pres.length; i++) {
			if (map.containsKey(fromIds[i])) {
				List<Integer> l = map.get(fromIds[i]);
				l.add(toIds[i]);
				map.put(fromIds[i], l);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(toIds[i]);
				map.put(fromIds[i], list);
			}
		}

		// check if the startnode no edge to exit
		if (pres[startNodeId] == 0) {
			return startNodeId;
		}

		if (map.containsKey(startNodeId)) {
			List<Integer> curr = new ArrayList<>();
			curr.add(startNodeId);
			return help(startNodeId, map);

		} else {
			// startnode not exists
			return 0;
		}

	}

	private static int help(int startNodeId, Map<Integer, List<Integer>> map) {
		if (!map.containsKey(startNodeId)) {
			return startNodeId;
		} else {
			List<Integer> list = map.get(startNodeId);
			startNodeId = list.get(0);
			return help(startNodeId, map);
		}
	}
	
	//print all paths to end
	

	@Test
	public void test() {
		int startNodeId = 1;
		int fromIds[] = { 1, 1, 2, 3, 4, 5, 6 };
		int toIds[] = { 2, 3, 4, 4, 7, 5, 7 };
		System.out.println(findNetworkEndpoint(startNodeId, fromIds, toIds));

	}
}
