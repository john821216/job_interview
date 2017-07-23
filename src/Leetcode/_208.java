package Leetcode;

public class _208 {
	Node root;

	public _208() {
		root = new Node();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		Node curNode = root;
		for (int i = 0; i < word.length(); i++) {
			int c = word.charAt(i)-'a';
			if (curNode.children[c] == null) {
				curNode.children[c] = new Node();
				curNode = curNode.children[c];
			} else {
				curNode = curNode.children[c];
			}

			if (i == word.length() - 1) {
				curNode.isLeaf = true;
			}
		}

	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		Node curNode = root;
		for (int i = 0; i < word.length(); i++) {
			int c = word.charAt(i)-'a';
			if (curNode.children[c] == null) {
				return false;
			} else {
				curNode = curNode.children[c];
			}
		}
		return curNode.isLeaf;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given
	 * prefix.
	 */
	public boolean startsWith(String prefix) {
		Node curNode = root;
		for (int i = 0; i < prefix.length(); i++) {
			int c = prefix.charAt(i)-'a';
			if (curNode.children[c] == null) {
				return false;
			} else {
				curNode = curNode.children[c];
			}
		}
		return true;
	}

	class Node {
		Node[] children = new Node[26];
		boolean isLeaf = false;
	}
}
