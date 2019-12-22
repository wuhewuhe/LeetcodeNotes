package RealLifeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mac
 *LRUCache cache = new LRUCache( 2  );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
 */
public class LRU {
	private Node head = new Node(0, 0), tail = new Node(0, 0);
	private int capacity;
	private Map<Integer, Node> map;

	class Node {
		private int key, value;
		private Node prev, next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	public LRU(int capacity) {
		this.capacity = capacity;
		map = new HashMap<Integer, Node>();
		head.next = tail;
		tail.prev = head;
	}

	public static void print(Node node) {
		Node start = node.next;
		while (start.next.next != null) {
			System.out.println("node key : " + start.key + ", node value : " + start.value);
			start = start.next;
		}
		System.out.println("node key : " + start.key + ", node value : " + start.value);
		System.out.println("--------------------------------");
	}

	public void insertToHead(Node node) {
		Node headNext = head.next;
		node.next = headNext;
		head.next = node;
		headNext.prev = node;
		node.prev = head;
	}

	public void removeNode(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	public int get(int key) {
		int res = -1;
		if (map.containsKey(key)) {
			Node temp = map.get(key);
			removeNode(temp);
			insertToHead(temp);
			res = temp.value;
		}
		print(head);
		return res;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			Node temp = map.get(key);
			removeNode(temp);
			temp.value = value;
			insertToHead(temp);
		} else {
			if (map.size() == capacity) {
				map.remove(tail.prev.key);
				removeNode(tail.prev);
			}
			Node temp = new Node(key, value);
			insertToHead(temp);
			map.put(key, temp);
		}
		print(head);
	}

	public static void main(String[] args) {
		LRU cache = new LRU(2);

		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1); // returns 1
		cache.put(3, 3); // evicts key 2
		cache.get(2); // returns -1 (not found)
		cache.put(4, 4); // evicts key 1
		cache.get(1); // returns -1 (not found)
		cache.get(3); // returns 3
		cache.get(4); // returns 4
		print(cache.head);
	}
}
