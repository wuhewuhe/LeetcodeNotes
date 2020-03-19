package Design;

import org.junit.Test;

public class TrieDictionary {
	public class TreeNode {
		public boolean endChar;
		public TreeNode[] children;

		public TreeNode() {
			this.endChar = false;
			this.children = new TreeNode[26];
		}
	}

	public TrieDictionary() {
		this.root = new TreeNode();
	}

	private TreeNode root;

	public void insert(String word) {
		TreeNode curr = root;
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (curr.children[index] == null) {
				curr.children[index] = new TreeNode();
			}
			curr = curr.children[index];
		}
		curr.endChar = true;
	}

	@Test
	public void test() {
		TrieDictionary trie = new TrieDictionary();
		trie.insert("apple");
		trie.search("apple"); // returns true
		trie.search("app"); // returns false
		trie.startsWith("app"); // returns true
		trie.insert("app");
		trie.search("app"); // returns true
	}

	private boolean startsWith(String string) {
		TreeNode node = searchEndNode(string);
		return node != null;
	}

	private boolean search(String string) {
		TreeNode node = searchEndNode(string);
		return node != null && node.endChar;
	}

	private TreeNode searchEndNode(String str) {
		TreeNode curr = root;
		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - 'a';
			curr = curr.children[index];
		}
		return curr;
	}
}
