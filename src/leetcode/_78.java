package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _78 {
	
	public static void main(String[] args){
		_78 a = new _78();
		a.execute();
	}
	
	public void execute(){
		int[] arr = {1,2,3};
		subsets(arr);
	}
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		for(int i = 0 ; i < (1 << nums.length) ; i++){
			List<Integer> curL = new ArrayList<Integer>();
			
			//first way
			/*
			int number = 0;
			
			for(int j = 0 ; j < nums.length ; j++ ){
				if( (i & (1 << number))  > 0){
					curL.add(nums[j]);
				}
				number++;
			}*/
			
			//another way
			int index = 0;
			int j = i;
			while( j > 0){
				if( (j & 1) > 0){
					curL.add(nums[index]);
					System.out.print(nums[index] +" ");
				}
				index++;
				j = j>>1;
			}
			System.out.println();
			ll.add(curL);
		}
		return ll;
	}
}
