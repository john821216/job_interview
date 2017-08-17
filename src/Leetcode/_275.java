package Leetcode;

public class _275 {
	public int hIndex(int[] citations) {
		int left = 0;
		int right = citations.length;
		while (left < right) {
			int mid = (right - left) / 2 + left;
			if (citations[mid] >= citations.length - mid) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return citations.length-right;
	}
	
	public int hIndex2(int[] citations) {
		int left = 0;
		int right = citations.length-1;
		while (left <= right) {
			int mid = (right - left) / 2 + left;
			if (citations[mid] >= citations.length - mid) {
				right = mid-1;
			} else {
				left = mid + 1;
			}
		}
		return citations.length-left;
	}
}
