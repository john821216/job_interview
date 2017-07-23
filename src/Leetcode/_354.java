package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _354 {
	public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0 ){
            return 0;
        }
		Arrays.sort(envelopes, new envelopesComparator());
		int[] dp = new int[envelopes.length];
		Arrays.fill(dp, 1);
		int max = 1;
		for (int i = 0; i < envelopes.length; i++) {
			for (int j = 0; j < i; j++) {
				if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					if(dp[i] > max) {
						max = dp[i];
					}
				}
			}
		}
		return max;
	}

	private class envelopesComparator implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			} else {
				return o1[0] - o2[0];
			}
		}

	}
}
