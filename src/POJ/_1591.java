package POJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1591 {
	static int N;
	static int X;
	static boolean[] number;
	static int index;
	static int memberNumber;
	static int count = 1;
	static int[] intervalArr;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			N = input.nextInt();
			X = input.nextInt();
			number = new boolean[51];
			intervalArr = new int[20];
			memberNumber = N;
			for (int i = 1; i <= N; i++) {
				number[i] = true;
			}
			
			for(int i = 0 ; i < intervalArr.length ; i++){
				intervalArr[i] = input.nextInt();
			}
			index = 1;
			int intervalCount= 0;
			while (memberNumber != X) {
				int interval = intervalArr[intervalCount++];
				int tempInterval = interval;
				while (index <= N) {
					while (!number[index] && index <= N) {
						index++;
					}
					if (index > N) {
						break;
					}
					tempInterval--;

					if (tempInterval == 0) {
						number[index] = false;
						tempInterval = interval;
						memberNumber--;

						if (memberNumber == X)
							break;
					}
					index++;
				}
				index = 1;
			}
			System.out.println("Selection #" + count++);
			boolean hasEnter = false;
			for (int i = 1; i <= N; i++) {
				if (number[i]) {
					if (!hasEnter) {
						hasEnter = true;
						System.out.print(i);
					} else {
						System.out.print(" " +i);
					}
				}
			}
			System.out.println();
			System.out.println();
		}
	}
}
