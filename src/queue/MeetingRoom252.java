package queue;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.Test;

public class MeetingRoom252 {
	@Test
	public void test() {
		int[][] room = { { 1, 5 }, { 2, 7 }, { 11, 14 }, { 8, 10 } };
		System.out.println(meetingRoom2(room));
	}

	// array method
	private boolean meetingRoom(int[][] room) {
		int[] start = new int[room.length];
		int[] end = new int[room.length];
		for (int i = 0; i < room.length; i++) {
			start[i] = room[i][0];
			end[i] = room[i][1];
		}
		Arrays.sort(start);
		Arrays.sort(end);
		for (int i = 1; i < start.length; i++) {
			if (start[i] < end[i - 1])
				return false;
		}
		return true;
	}

	// priority queue
	private boolean meetingRoom2(int[][] room) {
		Arrays.sort(room, (int[] n1, int[] n2) -> n1[0] - n2[0]);
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((int[] n1, int[] n2) -> n1[1] - n2[1]);
		pq.offer(room[0]);
		for (int i = 1; i < room.length; i++) {
			pq.offer(room[i]);
			if (pq.poll()[1] > room[i][0])
				return false;
		}
		return true;
	}
}
