package Leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class _403 {
	public boolean canCross(int[] stones) {
		HashMap<Integer, HashSet<Integer>> h = new HashMap<Integer, HashSet<Integer>>();
		for (int i = 1; i < stones.length; i++) {
			h.put(stones[i], new HashSet<Integer>());
		}
		h.put(0, new HashSet<Integer>());
		HashSet<Integer> hs = h.get(0);
		hs.add(1);
		h.put(0, hs);

		for (int i = 0; i < stones.length; i++) {
			int stone = stones[i];

			for (int step : h.get(stone)) {
				int maxReach = step + stone;
				if (maxReach == stones[stones.length - 1]) {
					return true;
				}

				hs = h.get(maxReach);
				if (hs != null) {
					hs.add(step);
					if (step - 1 > 0){
						hs.add(step - 1);
					}
					hs.add(step + 1);
					h.put(stone, hs);
				}
			}
		}
		return false;
	}
}
