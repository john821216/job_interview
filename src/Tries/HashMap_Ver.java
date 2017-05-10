package Tries;

import java.util.HashMap;

public class HashMap_Ver {
	TrieNode_HashMap root;

	public HashMap_Ver() {
		root = new TrieNode_HashMap();
	}

	public void insert(String word) {
		TrieNode_HashMap curNode = root;
		for (int i = 0; i < word.length(); i++) {
			char curC = word.charAt(i);
			TrieNode_HashMap t = new TrieNode_HashMap();
			if (curNode.children.containsKey(curC)) {
				curNode = curNode.children.get(curC);
			} else {
				curNode.children.put(curC, t);
			}
			if (i == word.length() - 1) {
				t.isLeaf = true;
			}
		}
	}

	public boolean search(String word) {
		TrieNode_HashMap t = searchNode(word);
		if (t != null && t.isLeaf) {
			return true;
		} else {
			return false;
		}
	}

	public boolean startsWith(String prefix) {
		if (searchNode(prefix) == null) {
			return false;
		} else {
			return true;
		}
	}

	public TrieNode_HashMap searchNode(String str) {
		TrieNode_HashMap curNode = root;
		for (int i = 0; i < str.length(); i++) {
			char curC = str.charAt(i);
			if (curNode.children.containsKey(curC)) {
				curNode = curNode.children.get(curC);
			} else {
				return null;
			}
		}
		if(curNode == root){
			return null;
		}
		return curNode;
	}
}

class TrieNode_HashMap {
	char c;
	HashMap<Character, TrieNode_HashMap> children = new HashMap<Character, TrieNode_HashMap>();
	boolean isLeaf = false;

	public TrieNode_HashMap() {

	}

	public TrieNode_HashMap(char c) {
		this.c = c;
	}
}
