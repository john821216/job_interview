package Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class Bucket_Sort {
	public static void main(String[] args) {
		Bucket_Sort b = new Bucket_Sort();
		b.execute();
	}

	public void execute() {
		int[] arr = { 60, 39, 59, 66, 66, 22, 81, 26, 56, 41 };
		bucket_sort(arr, 10);
		print(arr);
	}

	public void bucket_sort(int[] nums, int n) {
		ArrayList<ArrayList<Integer>> aa = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n + 1; i++) {
			aa.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < nums.length; i++) {
			int cur = nums[i] / 10;
			aa.get(cur).add(nums[i]);
			System.out.println(cur + " " + nums[i]);
		}

		for (int i = 0; i < n + 1; i++) {
			Collections.sort(aa.get(i));
			System.out.println(aa.get(i));
		}

		int count = 0;
		for (int i = 0; i < n + 1; i++) {
			ArrayList<Integer> curL = aa.get(i);
			for (int j = 0; j < curL.size(); j++) {
				nums[count++] = curL.get(j);
			}
		}
	}

	public void print(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}
}
