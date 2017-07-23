package Leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _373 {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
	    List<int[]> s = new ArrayList<int[]>();
		PriorityQueue<int[]> p = new PriorityQueue<int[]>(new sum());
		for(int i = 0 ; i < nums1.length ; i++){
			for(int j = 0 ; j < nums2.length ; j++){
				int[] pair = new int[2];
				pair[0] = nums1[i];
				pair[1] = nums2[j];
				p.add(pair);
			}
		}
	
		while(k != 0){
		    int[] pE = p.poll();
		    if(pE == null){
		        break;
		    }
			s.add(pE);
			k--;
		}
		return s;
	}

	private class sum implements Comparator<int[]> {
		@Override
		public int compare(int[] o1, int[] o2) {
			int o1Sum = o1[0] + o1[1];
			int o2Sum = o2[0] + o2[1];
			return o1Sum - o2Sum;
		}
	}
}
