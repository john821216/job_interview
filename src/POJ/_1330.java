package POJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class _1330 {
	static int T;
	static int N;
	static ArrayList<ArrayList<Integer>> c;
	static int[] f;
	static int[] d;
	static int X;
	static int Y;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		T = input.nextInt();
		for (int i = 0; i < T; i++) {
			N = input.nextInt();

			c = new ArrayList<ArrayList<Integer>>(N + 1);
			
			for(int j = 0 ; j < N+1 ; j++){
				c.add(new ArrayList<Integer>());
			}
			f = new int[N + 1];
			d = new int[N + 1];

			for (int j = 0; j < N - 1; j++) {
				int _f = input.nextInt();
				int _c = input.nextInt();

				ArrayList<Integer> a = c.get(_f);
				a.add(_c);
				c.set(_f, a);
				f[_c] = _f;
			}

			X = input.nextInt();
			Y = input.nextInt();

			// find root
			int rootIndex = -1;
			for (int j = 1; j <= N; j++) {
				if (f[j] == 0) {
					rootIndex = j;
					break;
				}
			}
			findDepth(0, rootIndex);

			while (X != Y) {
				if (d[X] > d[Y]) {
					X = f[X];
				} else {
					Y = f[Y];
				}
			}
			System.out.println(X);
		}
	}

	public static void findDepth(int dep, int index) {
		d[index] = dep;
		ArrayList<Integer> a = c.get(index);

		for (int i = 0; i < a.size(); i++) {
			findDepth(dep+1, a.get(i));
		}
	}
}
