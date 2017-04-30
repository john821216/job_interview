package Leetcode;

import java.math.BigInteger;
import java.util.ArrayList;

public class _372 {
	public static void main(String[] args) {
		_372 a = new _372();
		a.execute();
	}

	public void test(int a, String b) {
		BigInteger i = new BigInteger(a + "");
		BigInteger j = new BigInteger(b + "");
		System.out.println("AN: " + i.modPow(j, new BigInteger("1337")));
	}

	public void execute() {
		int[] arr = { 1, 2, 5 };
		int a = 2;
		String s = "";
		for (int i = 0; i < arr.length; i++) {
			s += arr[i];
		}
		test(a, s);
		System.out.println(superPow(a, arr) + " AN");
	}

	public int superPow(int a, int[] b) {
		return superPow(a, b, b.length - 1, 1337);
	}

	public int superPow(int a, int[] b, int index, int k) {
		System.out.println(b[index] );
		if (index == 0) {
			return powMod(a, b[0], k);
		}
		return (powMod(superPow(a, b, index - 1, k), 10, k) * powMod(a, b[index],
				k)) % k;
	}

	public int powMod(int a, int b, int k) {
		int result = 1;
		a %= k;
		for (int i = 0; i < b; i++) {
			result = (result * a) % k;
		}
		System.out.println(a +" " + b +" " + result);
		return result;
	}

}
