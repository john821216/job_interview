package URI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _1424 {
	static int n;
	static int m;
	static ArrayList<ArrayList<Integer>> a;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			n = input.nextInt();
			m = input.nextInt();
			a = new ArrayList<ArrayList<Integer>>(Collections.nCopies(1000001,  new ArrayList<Integer>()));
			for (int i = 1; i <= n; i++) {
				int j = input.nextInt();
				ArrayList<Integer> ia = a.get(j);
				ia.add(i);
				a.set(j, ia);
				for(int ab = 0; ab < 10 ; ab++){
				System.out.println(a.get(ab)+ "  23");
				}
			}

			for (int im = 0; im < m; im++) {
				int k = input.nextInt();
				int v = input.nextInt();
				ArrayList<Integer> n = a.get(v);
				// System.out.println(n);
				if (n.size() < k) {
					System.out.println("0");
				} else {
					System.out.println(n.get(k - 1));
				}
			}
		}
	}
}
