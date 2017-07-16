package Leetcode;

public class _640 {
	public static void main(String[] args) {
		_640 a = new _640();
		a.execute();
	}

	public void execute() {
		System.out.println(solveEquation("-x=1"));
	}

	public String solveEquation(String equation) {
		String left =equation.split("=")[0];
		String right = equation.split("=")[1];
		if(left.charAt(0) != '-') left = "+" + left;
		if(right.charAt(0) != '-') right = "+" + right;

		int XCount = 0;
		int CofCount = 0;
		String temp = "";
		int idx = 0;
		while (idx < left.length()) {
			temp = "";
			if (left.charAt(idx) == '+') {
				while (idx + 1 < left.length() && left.charAt(idx + 1) != '+'
						&& left.charAt(idx + 1) != '-') {
					temp += left.charAt(++idx);
				}
			} else if (left.charAt(idx) == '-') {
				temp +="-";
				while (idx + 1 < left.length() && left.charAt(idx + 1) != '+'
						&& left.charAt(idx + 1) != '-') {
					temp += left.charAt(++idx);
				}
			}
			if (temp.contains("x")) {
				temp = temp.replace("x", "");
				if (temp.equals(""))
					XCount += 1;
				else if (temp.equals("-"))
					XCount += -1;
				else
					XCount += Integer.valueOf(temp);
			} else {
				if (temp.equals(""))
					CofCount += 1;
				else if (temp.equals("-"))
					CofCount += -1;
				else
					CofCount += Integer.valueOf(temp);
			}
			System.out.println(XCount +" "+ CofCount);

			idx++;
		}
		idx = 0;
		while (idx < right.length()) {
			temp = "";
			if (right.charAt(idx) == '+') {
				while (idx + 1 < right.length() && right.charAt(idx + 1) != '+'
						&& right.charAt(idx + 1) != '-') {
					temp += right.charAt(++idx);
				}

			} else if (right.charAt(idx) == '-') {
				temp +="-";
				while (idx + 1 < right.length() && right.charAt(idx + 1) != '+'
						&& right.charAt(idx + 1) != '-') {
					temp += right.charAt(++idx);
				}
			}

			if (temp.contains("x")) {
				temp = temp.replace("x", "");
				if (temp.equals(""))
					XCount -= 1;
				else if (temp.equals("-"))
					XCount -= -1;
				else
					XCount -= Integer.valueOf(temp);
			} else {
				if (temp.equals(""))
					CofCount -= 1;
				else if (temp.equals("-"))
					CofCount -= -1;
				else
					CofCount -= Integer.valueOf(temp);
			}
			idx++;
		}

		if (XCount == 0 && CofCount == 0) {
			return "Infinite solutions";
		} else if (XCount == 0 && CofCount != 0) {
			return "No solution";
		} else {
			return "x=" + (-1)*CofCount / XCount;
		}
	}
}
