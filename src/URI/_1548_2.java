package URI;

import java.util.Arrays;
import java.util.Scanner;

public class _1548_2 {
	static int testCase;
	static int[] pp;
	static int[] copy_pp;
	static int dontChange;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		testCase = input.nextInt();
		for (int i = 0; i < testCase; i++) {
			pp = new int[input.nextInt()];
			copy_pp = new int[pp.length];
			dontChange = 0;
			for(int j = 0; j < pp.length ; j++){
				pp[j] = input.nextInt();
			}
			System.arraycopy(pp, 0, copy_pp, 0, pp.length);
			Arrays.sort(pp);
			
			for(int j = 0; j < pp.length ; j++){
				if(pp[pp.length-1-j] == copy_pp[j]){
					dontChange++;
				}
			}
			System.out.println(dontChange);
		}
	}
}
