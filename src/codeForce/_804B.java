package CodeForce;

import java.util.Scanner;

public class _804B {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.next();
		int bCount = 0;
		int changeCount = 0;
		for (int i = str.length() - 1; i >= 0; i--) {
			if(str.charAt(i) == 'b'){
				bCount++;
			} else{
				changeCount = (changeCount + bCount) % (1000000007);
				bCount = (bCount * 2) % (1000000007);
			}
		}
		System.out.println(changeCount);
	}
}
