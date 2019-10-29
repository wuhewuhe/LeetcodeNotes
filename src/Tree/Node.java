package Tree;

import java.util.List;

/**
 * @author he.wu
 *
 */
public class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}

	@Override
	public String toString() {
		return "Node [val=" + val + ", children=" + children + "]";
	}
	
}
