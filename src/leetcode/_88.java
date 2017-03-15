package leetcode;

import java.util.Arrays;

public class _88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int nums1Index = 0;
		int nums2Index = 0;
		int[] newArr = new int[m + n];
		int newIndex = 0;
		while (nums1Index < m && nums2Index < n) {
			if (nums1[nums1Index] > nums2[nums2Index]) {
				newArr[newIndex] = nums2[nums2Index++];
			} else {
				newArr[newIndex] = nums1[nums1Index++];
			}
		}

		for (int i = nums1Index; i < m; i++) {
			newArr[newIndex] = nums1[i];
		}

		for (int i = nums2Index; i < n; i++) {
			newArr[newIndex] = nums2[i];
		}

		System.arraycopy(newArr, 0, nums1, 0, newArr.length);
	}
	
	public void merge2(int[] nums1, int m, int[] nums2, int n) {
		int nums2Index = n-1;
		int nums1Index = m-1;
		int totalIndex = m+n-1;
		while(nums2Index >= 0 && nums1Index >= 0){
			if( nums2[nums2Index] > nums1[nums1Index] ){
				nums1[totalIndex--] = nums2[nums2Index--];
			} else{
				nums1[totalIndex--] = nums1[nums1Index--];
			}
		}
		
		while(nums2Index >=0){
			nums1[totalIndex--] = nums2[nums2Index--];
		}
	}
}
