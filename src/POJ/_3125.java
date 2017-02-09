package POJ;

import java.util.Scanner;

public class _3125 {
	static int numberOfTestcase;
	static int n;
	static int m;
	static int[] arr;
	static int start;
	static int end;
	static int time;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		numberOfTestcase = input.nextInt();
		for (int i = 0; i < numberOfTestcase; i++) {
			n = input.nextInt();
			m = input.nextInt();
			arr = new int[n + 1];
			start = 0;
			end = n;
			time = 0;
			for (int j = 0; j < n; j++) {
				arr[j] = input.nextInt();
			}
			arr[m] = arr[m] * -1;

			while (true) {
//				System.out.println("29");
				boolean biggest = true;
				int cur = arr[start];
				for (int k = (start + 1) %(n+1); k != end; k = (k + 1) % (n + 1)) {
					if (Math.abs(arr[k]) > Math.abs(cur)) {
						arr[end] = cur;
						end = (end + 1) %(n+1);
//						System.out.println(k +" " + cur +" " + " " +start+ "  "+ end);
						biggest = false;
						break;
					}
				}
				
				if(biggest){
					time++;
					if(cur < 0){
						System.out.println(time);
						break;
					}
				}
				
				start = (start+1) % (n+1);
			}
			System.out.println();
		}
	}
}
