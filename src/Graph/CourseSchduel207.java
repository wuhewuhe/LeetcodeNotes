package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

/**
 * @author mac There are a total of n courses you have to take, labeled from 0
 *         to n-1.
 * 
 *         Some courses may have prerequisites, for example to take course 0 you
 *         have to first take course 1, which is expressed as a pair: [0,1]
 * 
 *         Given the total number of courses and a list of prerequisite pairs,
 *         is it possible for you to finish all courses?
 * 
 *         Example 1:
 * 
 *         Input: 2, [[1,0]] Output: true Explanation: There are a total of 2
 *         courses to take. To take course 1 you should have finished course 0.
 *         So it is possible. Example 2:
 * 
 *         Input: 2, [[1,0],[0,1]] Output: false Explanation: There are a total
 *         of 2 courses to take. To take course 1 you should have finished
 *         course 0, and to take course 0 you should also have finished course
 *         1. So it is impossible.
 */
public class CourseSchduel207 {

	// method1 BFS
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// corner case
		if (prerequisites == null) {
			return false;
		}

		if (numCourses < 0 || prerequisites.length == 0) {
			return true;
		}

		// 记录每个course的prerequisites的数量
		int[] pres = new int[numCourses];
		int len = prerequisites.length;
		for (int i = 0; i < len; i++) {
			pres[prerequisites[i][0]]++;
		}
		// record the direct course by queue
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < pres.length; i++) {
			if (pres[i] == 0) {
				queue.add(i);
			}
		}
		// 取出队列的course，判断
		int numNoPre = queue.size();
		while (!queue.isEmpty()) {
			int top = queue.poll();
			for (int i = 0; i < len; i++) {
				// 查看哪一个课程的必要条件是此刻课程
				if (prerequisites[i][1] == top) {
					pres[prerequisites[i][0]]--;
					if (pres[prerequisites[i][0]] == 0) {
						numNoPre++;
						queue.add(prerequisites[i][0]);
					}
				}
			}
		}

		// 判断可完成课程书是否等于课程总数
		return numNoPre == numCourses;
	}

	public boolean canFinish2(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++)
			graph[i] = new ArrayList<Integer>();

		boolean[] visited = new boolean[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			graph[prerequisites[i][1]].add(prerequisites[i][0]);
		}

		for (int i = 0; i < numCourses; i++) {
			if (!dfs(graph, visited, i))
				return false;
		}
		return true;
	}

	private boolean dfs(List<Integer>[] graph, boolean[] visited, int course) {
		if (visited[course])
			return false;
		else
			visited[course] = true;
		for (int i = 0; i < graph[course].size(); i++) {
			if (!dfs(graph, visited, (int) graph[course].get(i)))
				return false;
		}
		visited[course] = false;
		return true;
	}

	public boolean canFinish3(int numCourses, int[][] prerequisites) {
		List<List<Integer>> courseToPre = new ArrayList<List<Integer>>();
		for (int i = 0; i < numCourses; i++)
			courseToPre.add(new ArrayList<Integer>());
		for (int i = 0; i < prerequisites.length; i++)
			courseToPre.get(prerequisites[i][0]).add(prerequisites[i][1]);

		int used[] = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			if (used[i] == 0 && !traverse(courseToPre, i, used))
				return false;
		}
		return true;
	}

	public boolean traverse(List<List<Integer>> courseToPre, int index, int used[]) {
		used[index] = -1; // node is under visiting
		List<Integer> preList = courseToPre.get(index);
		for (int i = 0; i < preList.size(); i++) {
			int next = preList.get(i);
			if (used[next] == 1) // the node has been visited
				continue;
			if (used[preList.get(i)] == -1 || !traverse(courseToPre, preList.get(i), used))
				return false;
		}
		used[index] = 1; // visit finish
		return true;
	}

	@Test
	public void test() {
		int[][] prerequisites = { { 3, 0 }, { 3, 1 }, { 4, 1 }, { 4, 2 }, { 5, 3 }, { 5, 4 } };
		System.out.println(canFinish3(6, prerequisites));
	}

}
