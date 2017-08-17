package Leetcode;

public class _564 {
	public static void main(String[] args) {
		_564 a = new _564();
		a.execute();
	}

	public void execute() {
		System.out.println(nearestPalindromic("11811"));
	}

	public String nearestPalindromic(String n) {
		// 9 9 => 10 1 99 9 => 100 1
		if (n.length() == 1) {
			return Integer.valueOf(n) - 1 + "";
		}
		long dif1 = Math.abs(Long.valueOf(n) - Long.valueOf(mirroring(n)));
		if (dif1 == 0) {
			dif1 = Long.MAX_VALUE;
		}

		Long firstHalf;
		String newDif2Str;
		if (n.length() % 2 == 0) {
			firstHalf = Long.valueOf(n.substring(0, n.length() / 2)) + 1;
			newDif2Str = firstHalf + n.substring(n.length() / 2);
		} else {
			firstHalf = Long.valueOf(n.substring(0, n.length() / 2 + 1)) + 1;
			newDif2Str = firstHalf + n.substring(n.length() / 2 + 1);
		}
		long dif2 = Math.abs(Long.valueOf(n) - Long.valueOf(mirroring(newDif2Str)));

		if (n.length() % 2 == 0) {
			firstHalf = Long.valueOf(n.substring(0, n.length() / 2)) - 1;
		} else {
			firstHalf = Long.valueOf(n.substring(0, n.length() / 2 + 1)) - 1;
		}

		String newDif3Str = "";
		boolean allNine = true;
		Long tempFirst = firstHalf;
		while (tempFirst  != 0) {
			if (tempFirst  % 10 != 9) {
				allNine = false;
			}
			tempFirst /= 10;
		}
		if (firstHalf == 0 || allNine) {
			for (int i = 0; i < n.length() - 1; i++) {
				newDif3Str += "9";
			}
		} else {
			if (n.length() % 2 == 1) {
				newDif3Str = firstHalf + n.substring(n.length() / 2 + 1);
			} else {
				newDif3Str = firstHalf + n.substring(n.length() / 2);
			}
		}
		System.out.println(newDif3Str + " " + mirroring(newDif3Str));

		long dif3 = Math.abs(Long.valueOf(n) - Long.valueOf(mirroring(newDif3Str)));

		if (dif3 <= dif1 && dif3 <= dif2) {
			return mirroring(newDif3Str);
		} else if (dif1 <= dif3 && dif1 <= dif2) {
			return mirroring(n);
		} else {
			return mirroring(newDif2Str);
		}
	}

	public String mirroring(String s) {
		String firstHalf = s.substring(0, s.length() / 2);
		StringBuilder newS = new StringBuilder(firstHalf);
		if (s.length() % 2 == 1) {
			newS.append(s.charAt(s.length() / 2));
		}
		newS.append(new StringBuilder(firstHalf).reverse());
		return newS.toString();
	}
}
