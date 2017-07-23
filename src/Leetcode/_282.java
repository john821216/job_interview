package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _282 {
	public static void main(String[] args) {
		_282 a = new _282();
		a.execute();
	}

	public void execute() {
		addOperators("105", 5);
	}

	public List<String> addOperators(String num, int target) {
		List<String> l = new ArrayList<String>();
		addOperatorsHelper(l, "", num, 0, target, 0, 0);
		System.out.println(l);
		return l;
	}

	public void addOperatorsHelper(List<String> l, String path, String num,
			int pos, int target, long val, long mul) {
		if (pos == num.length()) {
			if (target == val) {
				l.add(path.toString());
			}
		}

		for (int i = pos; i < num.length(); i++) {
			if (i != pos && num.charAt(pos) == '0') {
				break;
			}
			long curVal = Long.valueOf(num.substring(pos, i + 1));
			if (pos == 0) {
				addOperatorsHelper(l, path + curVal, num, i + 1, target,
						curVal, curVal);
			} else {
				addOperatorsHelper(l, path + "+" + curVal, num, i + 1, target,
						val + curVal, curVal);
				addOperatorsHelper(l, path + "-" + curVal, num, i + 1, target,
						val - curVal, -curVal);

				addOperatorsHelper(l, path + "*" + curVal, num, i + 1, target,
						val - mul + mul * curVal, mul * curVal);
			}
		}
	}
}
