package RealLifeProblem;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
	private Node head = new Node(0, 0);
	private Node tail = new Node(0, 0);
	private Map<Integer, Node> map;
	private int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<Integer, Node>(capacity);
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		int res = -1;
		if (map.containsKey(key)) {
			Node n = map.get(key);
			remove(n);
			insertToHead(n);
			res = n.value;
		}
		print(map);
		return res;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			remove(n);
			n.value = value;
			insertToHead(n);
		} else {

			if (map.size() == capacity) {
				map.remove(tail.prev.key);
				remove(tail.prev);
			}

			Node n = new Node(key, value);
			insertToHead(n);
			map.put(key, n);
		}
		print(map);
	}

	private void remove(Node n) {
		n.prev.next = n.next;
		n.next.prev = n.prev;
	}

	private void insertToHead(Node n) {
		Node headNext = head.next;
		head.next = n;
		headNext.prev = n;
		n.prev = head;
		n.next = headNext;
	}

	class Node {
		private Node prev, next;
		private int key, value;

		Node(int k, int v) {
			key = k;
			value = v;
		}
	}

	public static void print(Map<Integer, Node> map) {
		map.keySet().stream().forEach(key -> System.out.println("element key is " + key));
		System.out.println("finish one time");
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);

		cache.put(1, 1);
		cache.put(2, 2);
		print(cache.map);
		cache.get(1); // returns 1
		cache.put(3, 3); // evicts key 2
		cache.get(2); // returns -1 (not found)
		cache.put(4, 4); // evicts key 1
		cache.get(1); // returns -1 (not found)
		cache.get(3); // returns 3
		cache.get(4); // returns 4
		print(cache.map);
	}
}