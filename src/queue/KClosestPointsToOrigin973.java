package queue;

import java.util.Collections;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * @author he.wu We have a list of points on the plane. Find the K closest
 *         points to the origin (0, 0).
 * 
 *         (Here, the distance between two points on a plane is the Euclidean
 *         distance.)
 * 
 *         You may return the answer in any order. The answer is guaranteed to
 *         be unique (except for the order that it is in.)
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: points = [[1,3],[-2,2]], K = 1 Output: [[-2,2]] Explanation:
 *         The distance between (1, 3) and the origin is sqrt(10). The distance
 *         between (-2, 2) and the origin is sqrt(8). Since sqrt(8) < sqrt(10),
 *         (-2, 2) is closer to the origin. We only want the closest K = 1
 *         points from the origin, so the answer is just [[-2,2]]. Example 2:
 * 
 *         Input: points = [[3,3],[5,-1],[-2,4]], K = 2 Output: [[3,3],[-2,4]]
 *         (The answer [[-2,4],[3,3]] would also be accepted.)
 */
public class KClosestPointsToOrigin973 {
	private int dis(int[] p) { // square
		return p[0] * p[0] + p[1] * p[1];
	}

	public int[][] kClosest(int[][] points, int k) {
		int[][] res = new int[k][2];
		PriorityQueue<int[]> pq = new PriorityQueue<>((int[] n1, int[] n2) -> dis(n2) - dis(n1));
		for (int[] point : points) {
			pq.offer(point);
			if (pq.size() > k)
				pq.poll();
		}
		int i = 0;
		for (int[] ele : pq)
			res[i++] = ele;
		return res;

	}

	public int[][] kClosest2(int[][] points, int k) {
		int[][] res = new int[k][2];
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
				(int[] n1, int[] n2) -> (n2[0] * n2[0] + n2[1] * n2[1]) - (n1[0] * n1[0] + n1[1] * n1[1]));
		for (int[] point : points) {
			pq.offer(point);
			if(pq.size()>k)
				pq.poll();
		}
		int i = 0;
		for(int[] point : pq)
			res[i++] = point;
		return res;
	}

	@Test
	public void test() {
		int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 }, { 9, 3 } };
		int k = 2;
		System.out.println(kClosest2(points, k));
	}
}
