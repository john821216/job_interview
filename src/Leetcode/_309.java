package Leetcode;

public class _309 {
	public int maxProfit(int[] prices) {
		int[] havestock = new int[prices.length];
		int[] cooldown = new int[prices.length];
		int[] sell = new int[prices.length];
		if(prices.length == 0 ) return 0;
		havestock[0] = -prices[0];
		cooldown[0] = 0;

		for (int i = 1; i < prices.length; i++) {
			havestock[i] = Math.max(havestock[i - 1], cooldown[i - 1]
					- prices[i]);
			if (i == 1) {
				cooldown[i] = cooldown[i - 1];
			} else {
				cooldown[i] = Math.max(cooldown[i - 1], sell[i - 1]);
			}
			sell[i] = havestock[i - 1] + prices[i];
		}
		return Math.max(sell[prices.length - 1], cooldown[prices.length - 1]);
	}
	
	public int maxProfit2(int[] prices) {
		int preHaveStock;
		int curHaveStock;
		int preCooldown;
		int curCooldown;
		int preSell;
		int curSell;
		if(prices.length == 0 ) return 0;

		preHaveStock = -prices[0];
		preCooldown = 0;
		preSell = 0;

		for (int i = 1; i < prices.length; i++) {
			curHaveStock = Math.max(preHaveStock, preCooldown-prices[i]);
			if (i == 1) {
				curCooldown = preCooldown;
			} else {
				curCooldown = Math.max(preCooldown, preSell);
			}
			curSell = preHaveStock + prices[i];
			
			preHaveStock = curHaveStock;
			preCooldown = curCooldown;
			preSell = curSell;
		}
		return Math.max(preCooldown,preSell);
	}
}
