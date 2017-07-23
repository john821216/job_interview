package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class _398 {
	HashMap<Integer,List<Integer>> h;
    public _398(int[] nums) {
        h = new HashMap<Integer,List<Integer>>();
        for(int i = 0 ; i < nums.length ; i++){
        		h.putIfAbsent(nums[i], new ArrayList<Integer>());
        		h.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        Random r = new Random();
        List<Integer> l = h.get(target);
        int size = l.size();
        return l.get(r.nextInt(size));
    }
}
