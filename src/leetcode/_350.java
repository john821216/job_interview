package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class _350 {
	public static void main(String[] args) {
		_350 a = new _350();
		a.execute();
	}

	public void execute() {
		int[] n1 = { 1, 2, 2, 1 };
		int[] n2 = { 2, 2 };
		int[] an = intersect(n1, n2);
		for (int i = 0; i < an.length; i++) {
			System.out.print(an[i] + " ");
		}
		System.out.println();
	}

	public int[] intersect(int[] nums1, int[] nums2) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int n1Index = 0;
		int n2Index = 0;
		while (n1Index < nums1.length && n2Index < nums2.length) {
			if (nums1[n1Index] > nums2[n2Index]) {
				n2Index++;
			} else if (nums1[n1Index] < nums2[n2Index]) {
				n1Index++;
			} else {
				al.add(nums1[n1Index]);
				n1Index++;
				n2Index++;
			}
		}
		int[] an = new int[al.size()];
		for (int i = 0; i < al.size(); i++) {
			an[i] = al.get(i);
		}
		return an;
	}

	public int[] intersect2(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		int[] an;
		for (int i = 0; i < nums1.length; i++) {
			if (h.get(nums1[i]) == null) {
				h.put(nums1[i], 1);
			} else {
				h.put(nums1[i], h.get(nums1[i]) + 1);
			}
		}
		for (int i = 0; i < nums2.length; i++) {
			if(h.get(nums2[i]) == null){
				continue;
			} else{
				if(h.get(nums2[i]) > 0){
					al.add(nums2[i]);
					h.put(nums2[i], h.get(nums2[i])-1);
				} else{
					continue;
				}
			}
		}
		
		an = new int[al.size()];
		
		for(int i = 0; i < an.length ; i++){
			an[i] = al.get(i);
		}
		return an;

	}
}
