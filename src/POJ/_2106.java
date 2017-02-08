package POJ;

import java.util.Scanner;
import java.util.Stack;

public class _2106 {
	static String exp;
	static Stack<Integer> op;
	static Stack<Integer> val;
	static int count = 1;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			exp = input.nextLine();
			op = new Stack<Integer>();
			val = new Stack<Integer>();
			for (int i = 0; i < exp.length(); i++) {
				if (exp.charAt(i) == '(') {
					op.push(0);
				} else if (exp.charAt(i) == '|') {
					while (!op.isEmpty() && (op.peek() == 1 || op.peek() == 2)) {
						cal(val.pop(), val.pop(), op.pop());
					}
					op.push(1);
				} else if (exp.charAt(i) == '&') {
					while (!op.isEmpty() && op.peek() == 2) {
						cal(val.pop(), val.pop(), op.pop());
					}
					op.push(2);
				} else if (exp.charAt(i) == ')') {
					while (!op.isEmpty() && op.peek() != 0) {
						cal(val.pop(), val.pop(), op.pop());
					}
					op.pop();
					if (!op.isEmpty() && op.peek() == 3) {
						op.pop();
						int v = val.pop();
						v = ~v;
						val.push(v);
					}
				} else if (exp.charAt(i) == '!') {
					op.push(3);
				} else if (exp.charAt(i) == 'V' || exp.charAt(i) == 'F') {
					if (op.peek() == 3) {
						op.pop();
						if (exp.charAt(i) == 'V')
							val.push(0);
						else if (exp.charAt(i) == 'F')
							val.push(1);
					} else {
						if (exp.charAt(i) == 'V')
							val.push(1);
						else if (exp.charAt(i) == 'F')
							val.push(0);
					}
				} else if (exp.charAt(i) == ' ') {

				}
			}
			while (!op.isEmpty()) {
				cal(val.pop(), val.pop(), op.pop());
			}
			if (val.peek() == 0) {
				System.out.println("Expression " + count + ": F");
			} else {
				System.out.println("Expression " + count + ": V");

			}
			count++;
		}
		
	}

	public static void cal(int a, int b, int op) {
		if (op == 2) {
			val.push(a & b);
		} else if (op == 1) {
			val.push(a | b);
		}
	}
}
