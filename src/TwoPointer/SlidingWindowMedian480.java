package TwoPointer;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

public class SlidingWindowMedian480 {
	public double[] medianSlidingWindow2(int[] nums, int k) {
		if (nums.length == 0 || k > nums.length)
			return new double[0];
		double[] res = new double[nums.length - k + 1];
		// idea is divide two heap, small and big, take these two top of the heap and
		// return medium
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();// java priority queue return the leatest number
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < nums.length; i++) {
			maxHeap.offer(nums[i]);
			minHeap.offer(maxHeap.poll());
			if (minHeap.size() > maxHeap.size()) {
				maxHeap.offer(minHeap.poll());
			}
			// record answer
			if (i >= k - 1) {
				//a condition judge k is odd or even 
				res[i - k + 1] = minHeap.size() < maxHeap.size() ? maxHeap.peek()
						: ((long) maxHeap.peek() + minHeap.peek()) * 0.5;

				if (maxHeap.contains(nums[i - k + 1])) {
					maxHeap.remove(nums[i - k + 1]);
				} else {
					minHeap.remove(nums[i - k + 1]);
				}
			}
		}
		return res;
	}
	
	public double[] medianSlidingWindow(int[] nums, int k) {
        MedianQueue window = new MedianQueue();
        double[] median = new double[nums.length - k + 1]; 
        for (int i = 0; i < nums.length; i++) {
            window.add(nums[i]);
            if (i >= k) window.remove(nums[i - k]);
            if (i >= k - 1) median[i - k + 1] = window.median();
        }   
        return median;
    }   

    static class MedianQueue {
        Queue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder()), minHeap = new PriorityQueue<>();

        public void add(long n) {
            maxHeap.add(n);
            minHeap.add(maxHeap.poll());
        }   

        public double median() {
            while (maxHeap.size() - minHeap.size() >= 2) minHeap.offer(maxHeap.poll());
            while (minHeap.size() - maxHeap.size() >= 1) maxHeap.offer(minHeap.poll());
            return maxHeap.size() == minHeap.size() ? (maxHeap.peek() + minHeap.peek()) / 2.0 : maxHeap.peek();
        }   

        public boolean remove(long n) {
            return maxHeap.remove(n) || minHeap.remove(n);
        }
    }

	@Test
	public void test() {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		System.out.println(medianSlidingWindow(nums, k));

	}
}
