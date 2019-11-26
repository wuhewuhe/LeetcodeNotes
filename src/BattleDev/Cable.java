package BattleDev;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Cable {
	public static void main(String[] argv) throws Exception {
		String line;
		Scanner sc = new Scanner(System.in);
		String[] global = sc.nextLine().split(" ");
		int number = Integer.valueOf(global[0]);
		int request = Integer.valueOf(global[1]);
		if (number < 1 || number > 500 || request < 1 || request > 3 * number)
			System.out.println("pas possible");
		int[][] ints = new int[request][2];
		int i = 0;
		while (sc.hasNextLine() && i < request) {
			line = sc.nextLine();
			String[] tem = line.split(" ");
			ints[i][0] = Integer.valueOf(tem[0]);
			ints[i][1] = Integer.valueOf(tem[1]);
			i++;
		}
		int[] ans = new int[request];
		ans[0] = 1;
		Arrays.sort(ints, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[0] > o2[0])
					return o2[0];
				else if (o1[0] < o2[0])
					return o1[0];
				else {
					return Integer.compare(o1[1], o2[1]);
				}
			}
		});
		i = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((int[] n1, int[] n2) -> n1[1] - n2[1]);
		pq.offer(ints[0]);
		int res = 1;
		for (int j = 1; j < ans.length; j++) {
			pq.offer(ints[j]);
			if (pq.peek()[1] > ints[j][0]) {
				res++;
				ans[j] = res;
			} else {
				if (res > number) {
					System.out.println("pas possible");
					return;
				}
				ans[j] = (j + 1) % number;
				pq.poll();
			}
		}
		for (int ii : ans)
			System.out.println(ii);
	}
}
