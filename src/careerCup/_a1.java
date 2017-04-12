package careerCup;

//https://www.careercup.com/question?id=5185036367167488
public class _a1 {
	public static int getMaxLen(int[] arr, int k) {
		int oneCount = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				oneCount++;
			}
		}
		int WL = 0;
		int WR = 0;
		int zeroCount = 0;
		int max = -1;
		if (arr[0] == 0) {
			zeroCount = 1;
		}
		while (WR < arr.length - 1) {
			if (zeroCount <= k) {
				WR++;
				if (arr[WR] == 0) {
					zeroCount++;
				}
			}
			while (zeroCount > k) {
				if (arr[WL] == 0) {
					zeroCount--;
				}
				WL++;
			}
			if (WR - WL + 1 == oneCount) {
				return oneCount;
			} else {
				if (WR - WL + 1 > max) {
					max = WR - WL + 1;
					System.out.println(WL + " " + WR + " " + zeroCount);
				}
			}
		}
		System.out.println(max);
		return max;
	}

	public static void main(String[] args) {
		int[] arr = { 0,1,1,0,0,1,0,1,1,1,1,0,0,1,0,0,1 };
		System.out.println(getMaxLen(arr, 3));
	}
}
