package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AddArrayFormInteger989 {
	public List<Integer> addToArrayForm(int[] A, int K) {
		int n = A.length - 1, cur = K;
		List<Integer> list = new ArrayList<Integer>();

		int i = n;
		while (i >= 0 || cur > 0) {
			if (i > 0)
				cur += A[i];
			list.add(cur % 10);
			cur /= 10;
		}
		Collections.reverse(list);
        return list;
	}
}
