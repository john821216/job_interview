package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _592 {
	public static void main(String[] args) {
		_592 a = new _592();
		a.execute();
	}

	public void execute() {
		System.out.println(fractionAddition("1/3-1/2"));
	}

	public String fractionAddition(String expression) {
		List<String> exp = new ArrayList<String>();
		List<Fraction> l = new ArrayList<Fraction>();
		boolean isNegative = false;
		int idx = 0;
		if (expression.charAt(0) != '-') {
			expression = "+" + expression;
		}

		StringBuilder temp = new StringBuilder();
		while (idx < expression.length()) {
			if (expression.charAt(idx++) == '-') {
				isNegative = true;
			}

			while (idx < expression.length() && expression.charAt(idx) != '-'
					&& expression.charAt(idx) != '+') {
				temp.append(expression.charAt(idx));
				idx++;
				System.out.println(temp);
			}
			if (isNegative) {
				exp.add("-" + temp.toString());
			} else {
				exp.add(temp.toString());
			}
			temp = new StringBuilder();
			isNegative = false;
		}

		for (String s : exp) {
			String[] sp = s.split("/");
			Fraction f = new Fraction(Integer.valueOf(sp[0]),
					Integer.valueOf(sp[1]));
			l.add(f);
		}
		Fraction cur = l.get(0);
		for (int i = 1; i < l.size(); i++) {
			cur = add(cur, l.get(i));
		}
		return cur.num + "/" + cur.den;
	}

	public Fraction add(Fraction a, Fraction b) {
		int denA = a.den;
		int denB = b.den;
		int numA = a.num;
		int numB = b.num;
		int newDen = denA * denB / gcd(denA, denB);
		int newNum = newDen / denA * numA + newDen / denB * numB;
		int gcdNew = gcd(newDen, newNum);	
		Fraction f = new Fraction(newNum / gcdNew, newDen / gcdNew);
		if(f.den < 0){
			f.den *= -1;
			f.num *= -1;
		}
		return f;

	}

	public int gcd(int a, int b) {
		while (b != 0) {
			a -= a / b * b;
			int temp = b;
			b = a;
			a = temp;
		}
		return a;
	}

	private class Fraction {
		int num;
		int den;

		public Fraction(int num, int den) {
			this.num = num;
			this.den = den;
		}
	}
}
