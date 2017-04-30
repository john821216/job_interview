package Leetcode;

public class _299 {
	public String getHint(String secret, String guess) {
		int bull = 0;
		int cow = 0;
		int[] number = new int[10];
		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				bull++;
			}
		}

		for (int i = 0; i < secret.length(); i++) {
			int curN = Character.getNumericValue(secret.charAt(i));
			number[curN]++;
		}

		for (int i = 0; i < guess.length(); i++) {
			int curN = Character.getNumericValue(guess.charAt(i));
			if (number[curN] > 0) {
				number[curN]--;
				cow++;
			}
		}
		return bull + "A" + (cow - bull) + "B";

	}

	public String getHint2(String secret, String guess) {
		int cows = 0;
		int bulls = 0;

		int[] numbers = new int[10];
		for (int i = 0; i < secret.length(); i++) {
			int s = Character.getNumericValue(secret.charAt(i));
			int g = Character.getNumericValue(guess.charAt(i));
			if (s == g)
				bulls++;
			else {
				if (numbers[s] < 0 || numbers[g] > 0){
					cows++;
				}
				numbers[s]++;
				numbers[g]--;
			}
		}
		return bulls + "A" + cows + "B";
	}

}
