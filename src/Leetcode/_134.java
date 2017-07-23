package Leetcode;

public class _134 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int length = gas.length;
		int sumGas = 0;
		int sumCost = 0;
		int curGas = 0;
		int start = 0;
		for (int i = 0; i < length; i++) {
			sumGas += gas[i];
			sumCost += cost[i];
			curGas += gas[i] - cost[i];
			if (curGas < 0) {
				start = i + 1;
				curGas = 0;
			}
		}
		if(sumGas < sumCost){
			return -1;
		} else{
			return start;
		}
	}
}
