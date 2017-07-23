package Leetcode;

public class _121 {
    public int maxProfit(int[] prices) {
        int max = 0;
        if(prices.length == 0) return 0;
        int[] minPrice = new int[prices.length];
        minPrice[0] = prices[0];
        for(int i = 1 ; i < prices.length ; i++){
            if(prices[i] < minPrice[i-1]){
                minPrice[i] = prices[i];
            } else{
                minPrice[i] = minPrice[i-1];
                max = Math.max(prices[i]-minPrice[i-1],max);
            }
        }
        return max;
    }
}
