package Graph;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

/**
 * @author mac There are a total of n courses you have to take, labeled from 0
 *         to n-1.
 * 
 *         Some courses may have prerequisites, for example to take course 0 you
 *         have to first take course 1, which is expressed as a pair: [0,1]
 * 
 *         Given the total number of courses and a list of prerequisite pairs,
 *         return the ordering of courses you should take to finish all courses.
 * 
 *         There may be multiple correct orders, you just need to return one of
 *         them. If it is impossible to finish all courses, return an empty
 *         array.
 * 
 *         Example 1:
 * 
 *         Input: 2, [[1,0]] Output: [0,1] Explanation: There are a total of 2
 *         courses to take. To take course 1 you should have finished course 0.
 *         So the correct course order is [0,1] . Example 2:
 * 
 *         Input: 4, [[1,0],[2,0],[3,1],[3,2]] Output: [0,1,2,3] or [0,2,1,3]
 *         Explanation: There are a total of 4 courses to take. To take course 3
 *         you should have finished both courses 1 and 2. Both courses 1 and 2
 *         should be taken after you finished course 0. So one correct course
 *         order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 */
public class CourseScheduleII210 {
	// BFS
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		 // 参数检查
        if (prerequisites == null) {
            throw new IllegalArgumentException();
        }
        int len = prerequisites.length;
        if (len == 0) {
            int[] seq = new int[numCourses];
            for (int i = 0; i < seq.length; i++) {
                seq[i] = i;
            }
            return seq;
        }
        int[] seq = new int[numCourses];
        int c = 0;
        // 记录每个course的prerequisites的数量
        int[] pCounter = new int[numCourses];
        for (int i = 0; i < len; i++) {
            pCounter[prerequisites[i][0]]++;
        }
        // 用队列记录可以直接访问的course
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (pCounter[i] == 0) {
                queue.add(i);
            }
        }
        // 取出队列的course，判断
        int numNoPre = queue.size();
        while (!queue.isEmpty()) {
            int top = queue.remove();
            // 保存结果 +_+
            seq[c++] = top;
            for (int i = 0; i < len; i++) {
                // 该course是某个course的prerequisites
                if (prerequisites[i][1] == top) {
                    pCounter[prerequisites[i][0]]--;
                    if (pCounter[prerequisites[i][0]] == 0) {
                        numNoPre++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        if (numNoPre != numCourses) {
            return new int[] {};
        }
        return seq;
	}

	@Test
	public void test() {
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		int[] arr =findOrder(4, prerequisites);
		System.out.println(Arrays.toString(arr));
	}
}
