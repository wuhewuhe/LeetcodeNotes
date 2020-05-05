package Graph;

import java.util.ArrayList;
import java.util.List;

public class DFS210 {
	class Solution {

		public int[] findOrder(int numCourses, int[][] prerequisites) {
			List<Integer>[] graph = new ArrayList[numCourses];
			for (int i = 0; i < numCourses; i++) {
				graph[i] = new ArrayList<>();
			}
			for (int[] prerequisite : prerequisites) {
				graph[prerequisite[0]].add(prerequisite[1]);
			}
			// 0: unvisited; 1: visiting 2: visited
			int[] visited = new int[numCourses];
			List<Integer> tempRes = new ArrayList<>();
			for (int i = 0; i < numCourses; i++) {
				if (!dfs(graph, i, visited, tempRes)) {
					return new int[0];
				}
			}
			int[] res = new int[numCourses];
			for (int i = 0; i < numCourses; i++) {
				res[i] = tempRes.get(i);
			}
			return res;
		}

		private boolean dfs(List<Integer>[] graph, int currentCourse, int[] visited, List<Integer> temp) {
			if (visited[currentCourse] == 1) {
				return false;
			}
			if (visited[currentCourse] == 2) {
				return true;
			}
			visited[currentCourse] = 1;
			for (int preCourse : graph[currentCourse]) {
				if (!dfs(graph, preCourse, visited, temp)) {
					return false;
				}
			}
			visited[currentCourse] = 2;
			temp.add(currentCourse);
			return true;
		}
	}
}
