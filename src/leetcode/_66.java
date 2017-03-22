package leetcode;

import java.util.Arrays;

public class _66 {
	public int[] plusOne(int[] digits) {
		int carry = 0;
		digits[digits.length-1]++;
		for(int i = digits.length -1 ; i >= 0 ; i--){
			digits[i] += carry;
			carry = 0;
			if(digits[i] == 10){
				carry = 1;
				digits[i] = 0;
			}
		}
		
		if(carry == 1){
			int[] newArr = new int[digits.length+1];
			System.arraycopy(digits, 0, newArr, 0, digits.length);
			newArr[0] = 1;
			newArr[1] = 0;
			return newArr;
		}
		return digits;
	}
}
