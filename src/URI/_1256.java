package URI;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class _1256 {
	static int testCase;
	static int mod;
	static int length;
	static LList[] l;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		testCase = input.nextInt();
		for (int i = 0; i < testCase; i++) {
			mod = input.nextInt();
			length = input.nextInt();
			l = new LList[mod];
			for (int j = 0; j < mod; j++) {
				l[j] = new LList();
			}

			for (int j = 0; j < length; j++) {
				int number = input.nextInt();
				int index = number % mod;
				// System.out.println(number +" " + index + " 27");

				if (l[index].root == null) {
					l[index].root = new Node(number);
				} else {
					Node cNode = l[index].root;
					while (cNode.next != null) {
						cNode = cNode.next;
					}
					cNode.next = new Node(number);
				}
			}

			for (int j = 0; j < mod; j++) {
				System.out.print(j + " ->");
				Node curNode = l[j].root;
				while (curNode != null) {
					System.out.print(" " + curNode.val + " ->");
					curNode = curNode.next;
				}
				System.out.print(" \\");
				System.out.println();
			}
			if (i != testCase - 1) {
				System.out.println("");
			}

		}
	}
}

class LList {
	Node root;
}

class Node {
	public Node(int val) {
		this.val = val;
	}

	int val;
	Node next;
}
