package LinkedList;

import org.junit.Test;

/**
 * @author mac Design your implementation of the linked list. You can choose to
 *         use the singly linked list or the doubly linked list. A node in a
 *         singly linked list should have two attributes: val and next. val is
 *         the value of the current node, and next is a pointer/reference to the
 *         next node. If you want to use the doubly linked list, you will need
 *         one more attribute prev to indicate the previous node in the linked
 *         list. Assume all nodes in the linked list are 0-indexed.
 * 
 *         Implement these functions in your linked list class:
 * 
 *         get(index) : Get the value of the index-th node in the linked list.
 *         If the index is invalid, return -1. addAtHead(val) : Add a node of
 *         value val before the first element of the linked list. After the
 *         insertion, the new node will be the first node of the linked list.
 *         addAtTail(val) : Append a node of value val to the last element of
 *         the linked list. addAtIndex(index, val) : Add a node of value val
 *         before the index-th node in the linked list. If index equals to the
 *         length of linked list, the node will be appended to the end of linked
 *         list. If index is greater than the length, the node will not be
 *         inserted. deleteAtIndex(index) : Delete the index-th node in the
 *         linked list, if the index is valid.
 * 
 * 
 *         Example:
 * 
 *         Input:
 *         ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
 *         [[],[1],[3],[1,2],[1],[1],[1]] Output: [null,null,null,null,2,null,3]
 * 
 *         Explanation: MyLinkedList linkedList = new MyLinkedList(); //
 *         Initialize empty LinkedList linkedList.addAtHead(1);
 *         linkedList.addAtTail(3); linkedList.addAtIndex(1, 2); // linked list
 *         becomes 1->2->3 linkedList.get(1); // returns 2
 *         linkedList.deleteAtIndex(1); // now the linked list is 1->3
 *         linkedList.get(1); // returns 3
 * 
 * 
 *         Constraints:
 * 
 *         0 <= index,val <= 1000 Please do not use the built-in LinkedList
 *         library. At most 2000 calls will be made to get, addAtHead,
 *         addAtTail, addAtIndex and deleteAtIndex.
 */

class Node { // public variables used for simplicity
	Node next = null;
	int val;

	public Node(int val) {
		this.val = val;

	}
}

public class DesignLinkedList707 {
	private Node head = null;
	private Node tail = null;
	private int size = 0;


	/** Initialize your data structure here. */
	public DesignLinkedList707() {

	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1. get time is o(n)
	 */
	public int get(int index) {
		if (index < 0 || index >= size)
			return -1;
		Node curr = head;
		for (int i = 0; i < index; i++) {
			curr = curr.next;
		}
		System.out.println(curr.val);
		return curr.val;
	}

	/**
	 * Add a node of value val before the first element of the linked list. After
	 * the insertion, the new node will be the first node of the linked list. add at
	 * head; time is o(1)
	 */
	public void addAtHead(int val) {
		Node n = new Node(val);
		if (size == 0) {
			head = n;
			tail = n;
		} else {
			n.next = head;
			head = n;
		}
		size++;
	}

	/**
	 * Append a node of value val to the last element of the linked list. add tail,
	 * time is o(1)
	 */
	public void addAtTail(int val) {
		Node n = new Node(val);
		if (size == 0) {
			head = n;
			tail = n;
		} else {
			tail.next = n;
			tail = n;
		}
		size++;
	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If index
	 * equals to the length of linked list, the node will be appended to the end of
	 * linked list. If index is greater than the length, the node will not be
	 * inserted. time is o(n)
	 */
	public void addAtIndex(int index, int val) {
		if (index > size)
			return;
		if (index <= 0)
			addAtHead(val);
		else if (index == size)
			addAtTail(val);
		else{
			Node n = new Node(val);
			Node prev = head;
			for (int i = 0; i < index - 1; i++) {
				prev = prev.next;
			}
			n.next = prev.next;
			prev.next = n;
			size++;
		}
		
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	/**
	 * @param index
	 */
	public void deleteHead() {
        if (size > 0) {
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size || size <= 0) {
            return;
        }

        if (index == 0) {
            deleteHead();
        } else {
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            if (curr.next == tail) {
                tail = curr;
            }
            curr.next = curr.next.next;
            size--;
        }
    }

	@Test
	public void test() {
		DesignLinkedList707 linkedList = new DesignLinkedList707(); // Initialize empty LinkedList
		linkedList.addAtHead(7);
		linkedList.addAtHead(2);
		linkedList.addAtHead(1);
		linkedList.addAtIndex(3,0); 
		linkedList.deleteAtIndex(2); 
		linkedList.addAtHead(6);
		linkedList.addAtTail(4);
		linkedList.get(4);          
		linkedList.addAtHead(4);
		linkedList.addAtIndex(5,0); 
		linkedList.addAtHead(6);
	}
}
