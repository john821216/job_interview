package Leetcode;

public class _526 {
	public static void main(String[] args) {
		_526 a = new _526();
		a.execute();
	}

	public void execute() {
		System.out.println(countArrangement(3));
	}

	public int countArrangement(int N) {
		boolean[] isUsed = new boolean[N + 1];
		return countArrangementHelper(1, N, isUsed);
	}

	public int countArrangementHelper(int cur, int n, boolean[] isUsed) {
		if (cur > n){
			return 1;
		}
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			if (!isUsed[i] && i % cur == 0) {
				isUsed[i] = true;
				sum += countArrangementHelper(cur + 1, n, isUsed);
				isUsed[i] = false;
			}

			else if (!isUsed[i] && cur % i == 0) {
				isUsed[i] = true;
				sum += countArrangementHelper(cur + 1, n, isUsed);
				isUsed[i] = false;
			}
		}
		return sum;
	}
}
