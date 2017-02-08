package Tries;

public class HashMap_Array {
	TriesNode_Array root;
	
	public HashMap_Array(){
		root = new TriesNode_Array();
	}
	public void insert(String words){
		TriesNode_Array curNode= root;
		
		for(int i = 0 ; i < words.length() ; i++){
			char curC = words.charAt(i);
			int index = curC -'a';
			if(curNode.children[index] == null){
				TriesNode_Array t= new TriesNode_Array();
				curNode.children[index] = t;
				curNode = curNode.children[index];
			} else{
				curNode = curNode.children[index];
			}
			
			if(i == words.length()-1){
				curNode.isLeaf = true;
			}
		}
	}
	
	public boolean startsWith(String prefix){
		TriesNode_Array result = searchNode(prefix);
		if(result != null){
			return true;
		} else{
			return false;
		}
	}
	
	public boolean search(String s){
		TriesNode_Array result = searchNode(s);
		if(result==null){
			return false;
		} else if(result!= null && result.isLeaf){
			return true;
		}
		return false;
	}
	
	public TriesNode_Array searchNode(String s){
		TriesNode_Array curNode =root;
		for(int i = 0 ; i < s.length() ; i++){
			int curC = s.charAt(i) -'a';
			if(curNode.children[curC] != null){
				curNode = curNode.children[curC];
			} else{
				return null;
			}
		}
		
		if(curNode ==root){
			return null;
		}
		return curNode;
	}
	
}

class TriesNode_Array{
	char c;
	TriesNode_Array[] children = new TriesNode_Array[26];
	boolean isLeaf = false;
	
	public TriesNode_Array(){}
	
	public TriesNode_Array(char c){
		this.c = c;
	}
}
