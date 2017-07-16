package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class _599 {
	public String[] findRestaurant(String[] list1, String[] list2) {
		HashMap<String, Integer> h = new HashMap<String, Integer>();

		for (int i = 0; i < list1.length; i++) {
			h.put(list1[i], i);
		}
		ArrayList<String> an = new ArrayList<String>();
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < list2.length; i++) {
			if (h.containsKey(list2[i])) {
				int getItem = h.get(list2[i]);
				if (getItem + i < min) {
					an = new ArrayList<String>();
					an.add(list2[i]);
                    min = getItem + i;
				} else if (getItem + i == min) {
					an.add(list2[i]);
				}
			}
		}
		return an.toArray(new String[0]);
	}
}
