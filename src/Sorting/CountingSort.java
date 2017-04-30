package Sorting;

public class CountingSort {
	public static void main(String[] args) {
		int[] A = CountingSort.countingSort(new int[] { 14, 1, 10, 14, 7, 9, 3,
				2, 8, 0 }, 20);
	}

	public static int[] countingSort(int[] arr, int k) {
		int[] c = new int[k];
		int[] an = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			c[arr[i]]++;
		}

		for (int i = 1; i < k; i++) {
			c[i] = c[i] + c[i - 1];
		}
		
		//print c[i]
		for(int i = 0 ; i < c.length ; i++){
			System.out.print(c[i] +" ");
		}
		System.out.println();

		for (int i = 0 ; i <= arr.length-1; i++) {
			int ele = arr[i];
			int index = c[ele] - 1;
			an[index] = ele;
			c[ele]--;
		}
		
		//print 
		for(int i = 0 ; i < arr.length ; i++){
			System.out.print(an[i] +" ");
		}
		System.out.println();
		return an;
	}
}
