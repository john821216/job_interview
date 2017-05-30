package Leetcode;

import java.util.Arrays;

public class _322 {
	public int coinChange(int[] coins, int amount) {
		int[] moneyCount = new int[amount + 1];
		Arrays.fill(moneyCount, -1);
		moneyCount[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i - coins[j] >= 0 && moneyCount[i - coins[j]] != -1) {
				    if(moneyCount[i] == -1){
				        moneyCount[i] = moneyCount[i - coins[j]] + 1;
				    } else{
    					moneyCount[i] = Math.min(moneyCount[i - coins[j]] + 1,
    							moneyCount[i]);
				    }
				}
			}
		}
		return moneyCount[amount];
	}
}
