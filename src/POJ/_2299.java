package POJ;

import java.util.Scanner;

public class _2299 {
	static int[] a;;
	static int[] c_a;
	static int an;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			int length = input.nextInt();
			
			if (length == 0){
				break;
			}
			a = new int[length];
			an= 0;
			for (int i = 0; i < a.length; i++) {
				a[i] = input.nextInt();
			}
			c_a = new int[a.length];
			

			mergeSort(0, a.length - 1);
			System.out.println(an);
		}
	}

	public static void mergeSort(int s, int e) {
		if (s < e) {
			int mid = (s + e) / 2;
			mergeSort(s, mid);
			mergeSort(mid + 1, e);
			merge(s, mid, e);
		}
	}

	public static void merge(int s, int mid, int e) {
		int s1 = s;
		int s2 = mid + 1;
		int sIndex = s;
		while (s1 <= mid && s2 <= e) {
			if (a[s1] > a[s2]) {
				an += mid-s1+1;
				c_a[sIndex++] = a[s2++];
			} else {
				c_a[sIndex++] = a[s1++];		
			}
		}

		while (s1 <= mid) {
			c_a[sIndex++] = a[s1++];
		}

		while (s2 <= e) {
			c_a[sIndex++] = a[s2++];
		}

		for (int i = s; i <= e; i++) {
			a[i] = c_a[i];
		}

	}
}
