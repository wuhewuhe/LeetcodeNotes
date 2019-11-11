package Stack;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * @author mac Implement the following operations of a stack using queues.
 * 
 *         push(x) -- Push element x onto stack. pop() -- Removes the element on
 *         top of the stack. top() -- Get the top element. empty() -- Return
 *         whether the stack is empty. Example:
 * 
 *         MyStack stack = new MyStack();
 * 
 *         stack.push(1); stack.push(2); stack.top(); // returns 2 stack.pop();
 *         // returns 2 stack.empty(); // returns false Notes:
 * 
 *         You must use only standard operations of a queue -- which means only
 *         push to back, peek/pop from front, size, and is empty operations are
 *         valid. Depending on your language, queue may not be supported
 *         natively. You may simulate a queue by using a list or deque
 *         (double-ended queue), as long as you use only standard operations of
 *         a queue. You may assume that all operations are valid (for example,
 *         no pop or top operations will be called on an empty stack).
 */
public class ImplementStackusingQueues225 {

	class MyStack {
		private Queue<Integer> q1 = new LinkedList<>();
		private Queue<Integer> q2 = new LinkedList<>();
		private int top;

		// Push element x onto stack.
		public void push(int x) {
			q1.add(x);
			top = x;
		}

		// Removes the element on top of the stack.
		public void pop() {
			while (q1.size() > 1) {
				top = q1.remove();
				q2.add(top);
			}
			q1.remove();
			Queue<Integer> tem = new LinkedList<Integer>();
			tem = q1;
			q1 = q2;
			q2 = tem;
			//System.out.println(top);
		}

		public int top() {
			System.out.println(top);
			return top;
		}

		// Return whether the stack is empty.
		public boolean empty() {
			return q1.isEmpty();
		}

	}

	/**
	 * Your MyStack object will be instantiated and called as such: MyStack obj =
	 * new MyStack(); obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top();
	 * boolean param_4 = obj.empty();
	 */

	@Test
	public void test() {
		MyStack stack = new MyStack();

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.top(); // returns 2
		stack.pop(); // returns 2
		stack.empty(); // returns false
	}
}
