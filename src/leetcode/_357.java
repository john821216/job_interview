package Leetcode;

public class _357 {
    public int countNumbersWithUniqueDigits(int n) {
    		if(n == 0) return 1;
    		
    		int result = 0;
    		int base = 81;
    		for(int i = 1 ; i <= n ; i++){
    			if(i == 1) result += 10;
    			if(i == 2) result += 81;
    			if(i >= 2) result += base * (10 - i + 1);
    			base = base * (10 - i + 1);
    		}
    		return result;
    }
}
