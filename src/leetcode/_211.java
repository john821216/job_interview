package Leetcode;

public class _211 {
	Tries root;
	/** Initialize your data structure here. */
	public _211() {
		root = new Tries();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		Tries cur = root;
		for(int i = 0 ; i < word.length() ; i++){
			if(cur.children[word.charAt(i)-'a'] == null){
				cur.children[word.charAt(i)-'a'] = new Tries();
			}				
			cur = cur.children[word.charAt(i)-'a'];
			
			if(i == word.length() -1){
				cur.isLeaf = true;
			}
		} 
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the
	 * dot character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		Tries cur = root;
		for(int i = 0 ; i < word.length() ; i++){
			if(word.charAt(i) == '.'){
				for(int j = 0 ; j < 26 ; j++){
					boolean find = search(word.substring(0,i) + (char)(j+'a') + word.substring(i+1));
					if(find) return true;
				}
				return false;
			} else{
				if(cur.children[word.charAt(i)-'a'] == null){
					return false;
				} else{
					cur = cur.children[word.charAt(i)-'a'];
				}		
			}
		}
		return cur.isLeaf;			
	}

	private class Tries {
		boolean isLeaf = false;
		Tries[] children = new Tries[26];
	}

}
