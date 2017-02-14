package ZOJ;

import java.util.Scanner;

public class _2962 {
	static int N;
	static int[] C;
	static int X;
	static int Y;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			N = input.nextInt();
			C = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				C[i] = input.nextInt();
			}
			X = input.nextInt();
			Y = input.nextInt();
			System.out.println(solve(X, Y, N));
		}
	}

	public static int solve(int x, int y, int loc) {
		if (loc == 1) {
			return (y + x) * (y - x + 1) / 2;
		} else {
			int mul = (y - x + 1) / C[loc - 1];
			x = x + C[loc - 1] * mul;
			int restX;
			int restY;
			if (y % C[loc - 1] == 0) {
				restY = 1;
			} else {
				restY = C[loc - 1] - y % C[loc - 1] + 1;
			}

			if (x % C[loc - 1] == 0) {
				restX = 1;
			} else {
				restX = C[loc - 1] - x % C[loc - 1] + 1;
			}
			// System.out.println(restX + " " + restY);
			if (y - x == restY - restX) {
				return mul * solve(1, C[loc - 1], loc - 1)
						+ solve(restX, restY, loc - 1);
			} else {
				return mul * solve(1, C[loc - 1], loc - 1)
						+ solve(1, restX, loc - 1)
						+ solve(restY, C[loc - 1], loc - 1);
			}
		}
	}
}
