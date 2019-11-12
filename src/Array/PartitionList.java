package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PartitionList {

	/*
	 * two direction one is iterative and another is recursion but if we use
	 * recursion that means we should waste some space and it is the same time
	 * complexity compare with iterative so we choose one loop iterative(one
	 * pointer)
	 * 
	 * T o(n) = n/k, best case = 1 when k is bigger than the half of the length of
	 * list worst case = n when k is 1, so we should loop all of the list
	 * 
	 * S o(n) = N, we create an temperate list in the memory, it depends on the
	 * length of k, so if consider the infinitive, we can ignore k
	 */
	public static List<List<Integer>> PartitionList(List<Integer> list, int k) {
		// set a variable for returning, this is a arraylist, bc we use it for getting
		// an element by index
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		// corner case
		if (list == null || list.size() == 0)
			return res;
		if (k > list.size()) {
			res.add(list);
			return res;
		}
		// Optimism time
		if (k > list.size() / 2) {
			res.add(list.subList(0, k));
			res.add(list.subList(k, list.size()));
			return res;
		}
		// one pointer for loop the list, one by one for recording index
		int ptr = 0;
		List<Integer> tem = new LinkedList<Integer>();
		while (ptr < list.size()) {
			tem.add(list.get(ptr++));// add an element to tem list and then pointer to next index
			if (ptr % k == 0 || ptr == list.size()) {// just two condition, one is arrive at k or his multi time,
														// another is at end
				res.add(tem);
				tem = new LinkedList<Integer>();
			}

		}
		return res;
	}

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
		int k = 2;
		System.out.println(PartitionList(nums, k));
	}
}
