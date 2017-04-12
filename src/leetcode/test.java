package Leetcode;

import java.util.ArrayList;

public class test {
	public static void main(String[] args){
		new test().exe();
	}
	
	public void exe(){
		int a = 3;
		ArrayList<Integer> ab = new ArrayList<Integer>();
		ab.add(a);
		for(int i = 0 ; i < ab.size() ; i++){
			System.out.println(ab.get(i));
		}
		add(ab);
		for(int i = 0 ; i < ab.size() ; i++){
			System.out.println(ab.get(i));
		}
	}
	
	public void add(ArrayList<Integer> a){
		a.add(35);
	}
}
