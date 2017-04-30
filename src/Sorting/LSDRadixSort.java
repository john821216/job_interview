package Sorting;

public class LSDRadixSort {
	int[] arr = { 43, 9, 817, 412, 51, 33, 71 };

	public static void main(String[] args) {
		new LSDRadixSort().execute();
	}

	public void execute() {
		int[] an =countingSort(arr,1);
		for(int i = 0; i <an.length ; i++){
			System.out.print(an[i] +" ");
		}
		System.out.println();
	}

	public int[] countingSort(int[] arr, int place) {
		if (place >= 10000) {
			return arr;
		}
		int[] c = new int[10];
		int[] newArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int digit = arr[i] / place % 10;
			c[digit]++;
		}
		for (int i = 1; i < c.length; i++) {
			c[i] += c[i - 1];
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			int ele = arr[i] / place % 10;
			int index = c[ele] - 1;
			newArr[index] = arr[i];
			c[ele]--;
		}
		return countingSort(newArr,place*10);
	}
}
