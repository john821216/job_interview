package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> l = new ArrayList<Integer>();
        for(int i = 0 ; i < nums.length ; i++){
        		if(nums[nums[i]-1] < 0){
        			l.add(nums[i]);
        		} else{
        			nums[nums[i]-1] = -1 * nums[nums[i]-1];
        		}
        }
        return l;
    }
}
