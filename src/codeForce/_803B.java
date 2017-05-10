package CodeForce;

import java.util.Arrays;
import java.util.Scanner;

public class _803B {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int len = input.nextInt();
		int[] arr = new int[len];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.nextInt();
		}

		int d = 0;
		int[] dis = new int[arr.length];
		Arrays.fill(dis, Integer.MAX_VALUE);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				if (d != 0) {
					dis[i] = Math.min(dis[i], d);
					d++;
				}
			} else {
				dis[i] = 0;
				d = 1;
			}
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] != 0) {
				if (d != 0) {
					dis[i] = Math.min(dis[i], d);
					d++;
				}
			} else {
				dis[i] = 0;
				d = 1;
			}
		}

		for (int i : dis) {
			System.out.print(i + " ");
		}
	}
}
