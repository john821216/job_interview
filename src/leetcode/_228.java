package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _228 {
	public static void main(String[] args){
		_228 a = new _228();
		a.execute();
		
	}
	
	public void execute(){
		int[] arr = {0,1,2,4,5,7};
		List<String> l = summaryRanges(arr);
		for(int i = 0 ; i < l.size() ; i++){
			System.out.println(l.get(i)+ " ");
		}
	}
	
    public List<String> summaryRanges(int[] nums) {
        List<String> s = new ArrayList<String>();
        int pre = -1;
        for(int i = 0 ; i < nums.length ; i++){
        		String curStr = "";
        		if(pre != -1 && nums[i]-pre == 1){
        			curStr = s.get(s.size()-1);
        			curStr = curStr.split("->")[0] + "->" + nums[i];
        			s.set(s.size()-1, curStr);
        		} else{
        			curStr = nums[i] +"";
        			s.add(curStr);
        		}
        		pre = nums[i];
//        		System.out.println(curStr);
        }
        return s;
    }
}
