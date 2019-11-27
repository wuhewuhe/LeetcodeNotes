package queue;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.Test;

public class MeetingRoom253 {
	@Test
	public void test() {
		int[][] room = { { 1, 5 }, { 2, 7 }, { 11, 14 }, { 7, 10 } };
		System.out.println(meetingRoom(room));
	}

	// priority queue
	private int meetingRoom(int[][] room) {
		if (room == null || room.length == 0)
			return 0;
		if (room.length == 1)
			return 1;
		Arrays.sort(room, (int[] n1, int[] n2) -> n1[0] - n2[0]);
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((int[] n1, int[] n2) -> n1[1] - n2[1]);
		pq.offer(room[0]);
		int res = 1;
		for (int i = 1; i < room.length; i++) {
			pq.offer(room[i]);
			if (pq.poll()[1] > room[i][0])
				res++;
		}
		return res;
	}

	// two array
	private int meetingRoom2(int[][] room) {
		if (room == null || room.length == 0)
			return 0;
		if (room.length == 1)
			return 1;
		int res = 1;
		Arrays.sort(room, (int[] n1, int[] n2) -> n1[0] - n2[0]);
		int[] start = new int[room.length];
		int[] end = new int[room.length];
		for (int i = 0; i < room.length; i++) {
			start[i] = room[i][0];
			end[i] = room[i][1];
		}
		for (int i = 1; i < end.length; i++) {
			if (start[i] < end[i - 1])
				res++;
		}
		return res;
	}
}
