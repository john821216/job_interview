package bfs;

import java.util.Scanner;

//http://codeforces.com/problemset/problem/57/A
public class _57A {
	static int n, x1, x2, y1, y2;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		x1 = input.nextInt();
		y1 = input.nextInt();
		x2 = input.nextInt();
		y2 = input.nextInt();
		System.out.println(Math.min(Math.abs(dis(x1, y1) - dis(x2, y2)),
				4 * n - (Math.abs(dis(x1, y1) - dis(x2, y2)))));
	}

	public static int dis(int x, int y) {
		if (x == 0 && y <= n) 
			return y;
		if (x <= n && y == n)
			return n + x;
		if (x == n && y <= n)
			return 3 * n - y;
		else
			return 4 * n - x;
	}
}
