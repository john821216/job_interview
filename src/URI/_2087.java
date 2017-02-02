package URI;

import java.util.Scanner;

public class _2087 {
	static TriesNode root;
	static boolean hasAn = false;
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		root = new TriesNode();
		while(true){
			hasAn = false;
			root = new TriesNode();
			int number = input.nextInt();
			if(number ==0 ) break;
			else{
				for(int i = 0; i < number ; i++){
					insert(input.next());
				}
				if(hasAn){
					System.out.println("Conjunto Ruim");
				} else{
					System.out.println("Conjunto Bom");
				}
			}
		}
	}
	
	public static void insert(String s){
		TriesNode curNode = root;
		for(int i = 0; i < s.length() ; i++){
			int curC = s.charAt(i)-'a';
			if(curNode.children[curC] != null){
				if(i == s.length() -1 || curNode.children[curC].isLeaf){
					hasAn = true;
					break;
//					System.out.println("33" + curNode.children[curC] +" " + curC);
				}
				curNode = curNode.children[curC];
			} else{
				TriesNode t = new TriesNode();
				curNode.children[curC] = t;
				curNode = curNode.children[curC];
			}
		}
		curNode.isLeaf = true;
	}
}
class TriesNode{
	char c;
	TriesNode[] children = new TriesNode[26];
	boolean isLeaf = false;
	
	public TriesNode(){
		
	}
	
	public TriesNode(char c){
		this.c = c;
	}
}

