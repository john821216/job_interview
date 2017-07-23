package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _46 {
	public static void main(String[] args){
		_46 a = new _46();
		a.execute();
	}
	
	public void execute(){
		int[] arr = {1,1,2,2};
		permute(arr);
	}
			
	
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		List<Integer> l = new ArrayList<Integer>();
		permuteHelper(ll,l,nums,0);
		return ll;
	}

	public void permuteHelper(List<List<Integer>> ll, List<Integer> l,
			int[] nums, int i) {
		
		//stop
		if(i == nums.length){
			ll.add(new ArrayList<Integer>(l));
			System.out.println(l);
			return;
		}
		
		int j = i;
		for(int a = j ; a < nums.length ; a++){
			//swap
			if(a != j && nums[i] == nums[a]) continue;
			int temp = nums[i];
			nums[i] = nums[a];
			nums[a] = temp;
			System.out.println(i +" " +j + " " +a );
			l.add(nums[i]);
			permuteHelper(ll,l,nums,i+1);
			
			//swap
			temp = nums[i];
			nums[i] = nums[a];
			nums[a] = temp;
			l.remove(l.size()-1);
		}
	}
}
