package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    		List<Integer> l = new ArrayList<Integer>();
        for(int i = 0 ; i < nums.length ; i++){
        		if(nums[nums[i]-1] > 0){
        			nums[nums[i]-1] = -1 * nums[nums[i]-1];
        		}
        }
        
        for(int i = 0 ; i < nums.length ; i++){
        		if(nums[i] > 0){
        			l.add(i+1);
        		}
        }
        return l;
    }
}
