package ListNode;

import java.util.ArrayList;
import java.util.List;

import ListNode.LinkedList.Node;

/**
 * @author he.wu *You are given two non-empty linked lists representing two
 *         non-negative integers. The digits are stored in reverse order and
 *         each of their nodes contain a single digit. Add the two numbers and
 *         return it as a linked list. You may assume the two numbers do not
 *         contain any leading zero, except the number 0 itself.
 * 
 *         Example:
 * 
 *         Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation:
 *         342 + 465 = 807.
 */
public class AddTwoNumbers2 {
	
	 public static Node addTwoNumbers(Node l1, Node l2) {
		 return getSum(l1, l2, 0);
	    }

//	public static Node addTwoNumbers(Node l1, Node l2) {
//		Node dummyHead =  new Node(0);
//		Node p = l1, q = l2;
//		Node curr = dummyHead;
//		int carry = 0;
//		List<Integer> list = new ArrayList<Integer>();
//		while (p != null && q != null) {
//			int x = (p != null) ? p.val : 0;
//			int y = (q != null) ? q.val : 0;
//			int sum = carry + x + y;
//			carry = sum / 10;
//			curr.next = new Node(sum % 10);
//			curr = curr.next;
//			if (p != null)
//				p = p.next;
//			if (q != null)
//				q = q.next;
//			list.add(sum);
//		}
//		if (carry > 0) {
//			curr.next = new Node(carry);
//		}
//		return dummyHead.next;
//	}

	 //recursive
	private static Node getSum(Node l1, Node l2, int overhead) {
		// TODO Auto-generated method stub
		if (l1 == null && l2 == null) return (overhead == 0) ? null : new Node(overhead);
		int sum = ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val) + overhead;
		Node result = new Node(sum % 10);
		result.next = getSum((l1 == null) ? null : l1.next, (l2 == null) ? null : l2.next, sum / 10);
		return result;
	}

	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		l1 = l1.insert(l1, 2);
		l1 = l1.insert(l1, 4);
		l1 = l1.insert(l1, 3);
		l2 = l2.insert(l2, 5);
		l2 = l2.insert(l2, 6);
		l2 = l2.insert(l2, 4);
		LinkedList.printList(l1);
		LinkedList.printList(l2);
		System.out.println();
		Node dummy = addTwoNumbers(l1.head,l2.head);
		while(dummy != null) {
			System.out.println(dummy.val);
			dummy = dummy.next;
		}
	}

}
