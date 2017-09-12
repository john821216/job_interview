package Leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class _166 {

	public static void main(String[] args) {
		_166 a = new _166();
		a.execute();
	}

	public void execute() {
		System.out.println(fractionToDecimal(-1, -2147483648));
	}

	public String fractionToDecimal(int numerator, int denominator) {
		StringBuilder res = new StringBuilder();
		long num = Math.abs((long)numerator);
		long den = Math.abs((long)(denominator));
		if (numerator == 0) {
			return "0";
		}
		HashMap<Long, Integer> pos = new HashMap<Long, Integer>();
		if ((double)numerator / (double)denominator < 0) {
			res.append("-");
		}
		

		res.append(num / den);
		num -= num / den * den;
		if (num == 0) {
			return res.toString();
		}

		res.append(".");
		pos.put(num, res.length());
		num *= 10;
		while (true) {
			if (pos.containsKey(num)) {
				int prePos = pos.get(num);
				res.insert(prePos, "(");
				res.append(")");
				break;
			} else {
				pos.put(num, res.length());
				long newPos = num / den;
				num -= newPos * den;
				res.append(newPos);
				if (num == 0) {
					break;
				}
				num *= 10;
			}
		}
		return res.toString();
	}
}
