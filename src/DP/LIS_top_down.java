package DP;

import java.util.ArrayList;
import java.util.Arrays;

public class LIS_top_down {
	int[] arr = {3, 0, 20, 3, 4, 7, 2};
	int maxLength = -1;
	ArrayList<ArrayList<Integer>> d; 
	public static void main(String[] args){
		LIS_top_down l = new LIS_top_down();
		l.execute();
	}
	
	public void execute(){
		d = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> a = getAns();
		for(int i = 0 ; i < a.size() ; i++){
			System.out.print(a.get(i) +" ");
		}
	}
	
	public ArrayList<Integer> lis(int n){
		int length = 1;
		if(d.contains(n)){
			return d.get(n);
		}
		ArrayList<Integer> curL = new ArrayList<Integer>(Arrays.asList(arr[n]));
		for(int i = 0 ; i < n ; i++){
			if(arr[n] > arr[i] && lis(i).size() + 1 > length){
				length = lis(i).size() + 1;
				curL = lis(i);
				curL.add(arr[n]);
			}
		}
		return curL;
	}
	
	public ArrayList<Integer> getAns(){
		ArrayList<Integer> an = null;
		for(int i = 0 ; i < arr.length ; i++){
			if(maxLength < lis(i).size()){
				maxLength = lis(i).size();
				an = lis(i);
			}
		}
		return an;
	}
	
}

class Node {
    public final int value;
    public final Node left, right;

    Node(int value, Node left, Node right) {
        this.value = value; this.left = left; this.right = right;
    }
}
