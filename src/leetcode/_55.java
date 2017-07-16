package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _55 {
	
	public static void main(String[] args){
		_55 a = new _55();
		a.execute();
	}
	
	public void execute(){
		System.out.println(canJump2(new int[]{2,3,1,1,4}));
	}
	public boolean canJump(int[] nums) {
		int maxIndex = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (i <= maxIndex) {
				if (i + nums[i] > maxIndex) {
					maxIndex = i + nums[i];
				}
			}
		}
		if (maxIndex >= nums.length - 1)
			return true;
		else
			return false;
	}

	public boolean canJump2(int[] nums) {
		boolean[] isVisited = new boolean[nums.length];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		isVisited[0] = true;
		while (!q.isEmpty()) {
			int curIdx = q.poll();
			for (int i = 1; i <= nums[curIdx] && i + curIdx < nums.length; i++) {
				if (!isVisited[i + curIdx]) {
					q.add(i + curIdx);
					isVisited[i + curIdx] = true;
				}
			}
		}
		return isVisited[nums.length - 1];
	}

}
