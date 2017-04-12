package CodeForce;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _520B {
	static int start;
	static int end;
	static Queue<Button> q;
	static boolean[] hasEnter;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		start = input.nextInt();
		end = input.nextInt();
		hasEnter = new boolean[20000];
		q = new LinkedList<Button>();
		q.add(new Button(0, start));
		while (true) {
			Button b = q.poll();
//			System.out.println(b.value);
			if (b.value == end) {
				System.out.println(b.time);
				break;
			}
			if (b.value < end) {
				if (hasEnter[b.value * 2] == false) {
					hasEnter[b.value * 2] = true;
					q.add(new Button(b.time + 1, b.value * 2));
				}
			}
			if (hasEnter[b.value - 1] == false) {
				hasEnter[b.value - 1] = true;
				q.add(new Button(b.time + 1, b.value - 1));
			}

			// }
		}
	}
}

class Button {

	Button(int time, int value) {
		this.time = time;
		this.value = value;
	}

	int time;
	int value;
}
