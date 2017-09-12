package Leetcode;

import java.util.Arrays;

public class _220 {
	public static void main(String[] args) {
		_220 a = new _220();
		a.execute();
	}
	
	public void execute() {
		containsNearbyAlmostDuplicate(new int[] {4,2}, 2,1);
	}
	
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k<0 || t <0){
            return false;
        }
		for (int i = 0; i < nums.length-1; i++) {
			int start = i + 1;
			int to = Math.min(i + k, nums.length-1);
            if(start > to){
                continue;
            }
			int target = nums[i] + t;

			int[] newNum = new int[to - start + 1];
			int tempIdx = start;
			for (int j = 0; j < newNum.length; j++) {
				newNum[j] = nums[tempIdx++];
			}
			Arrays.sort(newNum);
			System.out.println(target);
			
			boolean ok = binarySearch(newNum, 0 , newNum.length-1, target);

			if (ok) {
				return true;
			}
		}
		return false;
	}

	public boolean binarySearch(int[] arr, int from, int to, int target) {
		while (from <= to) {
			int mid = (to - from) / 2 + from;
			if (arr[mid] <= target) {
				return true;
			} else {
				to = mid - 1;
			}
		}
		return false;
	}
}
