package Tries;

import java.util.HashMap;

public class HashMap_Ver {
	TrieNode_HashMap root;
	public HashMap_Ver(){
		root = new TrieNode_HashMap();
	}
	
	public void insert(String word){
		HashMap<Character, TrieNode_HashMap> children = new HashMap<Character, TrieNode_HashMap>();
		for(int i = 0 ; i < word.length() ; i++){
			char curC = word.charAt(i);
			TrieNode_HashMap t;
			if(children.containsKey(curC)){
				t = children.get(curC);
			} else{
				t= new TrieNode_HashMap();
				children.put(curC, t);
			}
			children = t.children;
			
			if(i== word.length()-1){
				t.isLeaf = true;
			}
		}
	}
	
	public boolean search(String word){
		TrieNode_HashMap t= searchNode(word);
		if(t!=null && t.isLeaf){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean startsWith(String prefix){
		if(searchNode(prefix) == null){
			return false;
		} else{
			return true;
		}
	}
	
	public TrieNode_HashMap searchNode(String str){
		HashMap<Character, TrieNode_HashMap> children = root.children;
		TrieNode_HashMap t= null;
		for(int i = 0 ; i < str.length() ; i++){
			char curC = str.charAt(i);
			if(children.containsKey(i)){
				t = children.get(curC);
				children = t.children;
			} else{
				return null;
			}
		}
		return t;
	}
}

class TrieNode_HashMap{
	char c;
	HashMap<Character, TrieNode_HashMap> children = new HashMap<Character, TrieNode_HashMap>();
	boolean isLeaf = false;
	public TrieNode_HashMap(){
		
	}
	public TrieNode_HashMap(char c){
		this.c =c;
	}
}
