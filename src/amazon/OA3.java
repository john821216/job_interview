package amazon;

import java.util.LinkedList;
import java.util.Queue;

public class OA3 {
	public static void main(String[] args) {
		
		OA3 i = new OA3();
		i.execute();
	}
	
	public void execute() {
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);
		root.left.right.right = new Node(45);
		System.out.println("Distance between 45 and 20 is : " + findDistance(root, 45, 20));

	}

	public int findDistance(Node root, int a, int b) {
		int lengthA = length(root, a);
		int lengthB = length(root, b);
		int lengthLCA = length(root, findLCA(root, a, b).data);
		System.out.println(lengthB);
		return lengthA + lengthB - 2 * lengthLCA;
	}

	public int length(Node root, int a) {
		int length = 0;
		Node cur = root;
		Queue<Node> q = new LinkedList<Node>();
		q.add(cur);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node pop = q.poll();
				if (pop.data == a) {
					return length;
				} else {
					if (pop.left != null) {
						q.add(pop.left);
					}

					if (pop.right != null) {
						q.add(pop.right);
					}
				}
			}
			length++;
		}
		return length;
	}

	public Node findLCA(Node cur, int a, int b) {
		if (cur == null) {
			return null;
		}
		if (cur.data == a || cur.data == b) {
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
