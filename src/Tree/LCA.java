package Tree;

public class LCA {
	public Node findLCA(Node cur, Node a, Node b) {
		if(cur==null) {
			return null;
		}
		if (cur.data == a.data || cur.data == b.data) {
			return cur;
		}

		Node left = findLCA(cur.left, a, b);
		Node right = findLCA(cur.right, a, b);

		if (left != null && right != null) {
			return cur;
		}
		if (left == null) {
			return right;
		}

		if (right == null) {
			return left;
		}
		return null;
	}

	private class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
}
