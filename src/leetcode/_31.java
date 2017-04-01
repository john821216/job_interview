package leetcode;

public class _31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length- 1;
        while( i >= 1 && nums[i-1] >= nums[i]){
        		i--;
        }
        
        if( i == 0){
        		//swap the whole array
        		int l = 0; 
        		int h = nums.length-1;
        		while( l < h){
        			int temp = nums[l];
        			nums[l] = nums[h];
        			nums[h] = temp;
        			l++;h--;
        		}
        } else{
        		i--;
        		int rIndex = nums.length - 1;
        		while(nums[i] >= nums[rIndex]){
        			rIndex--;
        		}
        		
        		int temp = nums[i];
        		nums[i] = nums[rIndex];
        		nums[rIndex] = temp;
        		
        		int l = i + 1;
        		int h = nums.length - 1;
        		while( l < h){
        			temp = nums[l];
        			nums[l] = nums[h];
        			nums[h] = temp;
        			l++;h--;
        		}
        }
    }
}
