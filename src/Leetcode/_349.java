package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _349 {
	public static void main(String[] args) {
		_349 a = new _349();
		a.execute();
	}

	public void execute() {
		int[] n1 = { 1, 3, 2, 1 };
		int[] n2 = { 3, 2 };
		int[] an = intersection(n1, n2);
		for (int i = 0; i < an.length; i++) {
			System.out.print(an[i] + " ");
		}
		System.out.println();
	}

	
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> s = new HashSet<Integer>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int nums1Index = 0;
		int nums2Index = 0;
		while(nums1Index < nums1.length && nums2Index < nums2.length){
			int n1 = nums1[nums1Index];
			int n2 = nums2[nums2Index];
			if(n1 > n2){
				nums2Index++;
			} else if(n1 < n2){
				nums1Index++;
			} else{
				s.add(n1);
				nums1Index++;
				nums2Index++;
			}
		}
		int[] an = new int[s.size()];
		int index =0;
		for(Integer i : s){
			an[index++] = i;
		}
		return an;
	}
}
