package Leetcode;

public class _264 {
	public static void main(String[] args){
		_264 a = new _264();
		a.execute();
	}
	
	public void execute(){
		System.out.println(nthUglyNumber(1));
	}
	
	public int nthUglyNumber(int n) {
		int[] an = new int[n];
		an[0] = 1;
		int twoIndex = 0;
		int threeIndex = 0;
		int fiveIndex = 0;
		for (int i = 1; i < n; i++) {
			an[i] = Math.min(2 * an[twoIndex],
					Math.min(3 * an[threeIndex], 5 * an[fiveIndex]));
			if(an[i] == 2 * an[twoIndex]){
				twoIndex++;
			}
			if(an[i] == 3 * an[threeIndex]){
				threeIndex++;
			}
			if(an[i] == 5 * an[fiveIndex]){
				fiveIndex++;
			}
		}
		return an[n-1];
	}
}
