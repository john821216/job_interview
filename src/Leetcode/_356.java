package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class _356 {
	public boolean isReflected(int[][] points) {
		HashSet<String> h = new HashSet<String>();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int[] p : points) {
			min = Math.min(min, p[0]);
			max = Math.max(max, p[0]);
			h.add(p[0] + "/" + p[1]);
		}
		
		int sum = min + max;
		for(int[] p : points) {
			String target = (sum-p[0])+"/"+p[1];
			if(!h.contains(target)) {
				return false;
			}
		}
		return true;
	}
}
