package LinkedList;

import java.util.Stack;

import org.junit.Test;

/**
 * @author he.wu Given a singly linked list, determine if it is a palindrome.
 * 
 *         Example 1:
 * 
 *         Input: 1->2 Output: false Example 2:
 * 
 *         Input: 1->2->2->1 Output: true
 */
public class PalindromeLinkedList234 {

	/**
	 * Definition for singly-linked list. public class ListNode { int val; ListNode
	 * next; ListNode(int x) { val = x; } }
	 */

	@Test
	public void test() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(2);
		ListNode n6 = new ListNode(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		System.out.println(isPalindrome(n1));
	}

	private boolean isPalindrome(ListNode n1) {
		if (n1 == null || n1.next == null)
			return true;
		Stack<Integer> stack = new Stack<Integer>();
		ListNode ptr = n1;
		while (ptr != null) {
			stack.push(ptr.val);
			ptr = ptr.next;
		}
		while (stack.size() > 0) {
			if (n1.val != stack.pop())
				return false;
			n1 = n1.next;
		}
		return true;
	}

}
