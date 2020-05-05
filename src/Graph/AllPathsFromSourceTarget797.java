package Graph;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AllPathsFromSourceTarget797 {
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		if (graph == null || graph.length == 0) {
			return null;
		}
		int n = graph.length;

		List<Integer> curr = new ArrayList<>();
		List<List<Integer>> answer = new ArrayList<>();
		curr.add(0);
		dfs(graph, 0, n - 1, curr, answer);

		return answer;
	}

	private void dfs(int[][] graph, int source, int target, List<Integer> curr, List<List<Integer>> answer) {
		if (source == target) {
			answer.add(new ArrayList<>(curr));
			return;
		}

		for (int child : graph[source]) {
			curr.add(child);
			dfs(graph, child, target, curr, answer);
			curr.remove(curr.size() - 1);
		}
	}

	@Test
	public void test() {
		int[][] t = { { 1, 2, 4 }, { 3, 4 }, { 3, 4 }, { 4 }, {} };
		System.out.println(allPathsSourceTarget(t));
	}

}
