package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _554 {

	public static void main(String[] args) {
		_554 a = new _554();
		a.execute();
	}

	public void execute() {
	}

	public int leastBricks(List<List<Integer>> wall) {
		int length;
		for (int i = 0; i < wall.size(); i++) {
			int sum = 0;
			for (int j = 0; j < wall.get(i).size(); j++) {
				sum += wall.get(i).get(j);
				wall.get(i).set(j, sum);
			}
		}

		length = wall.get(0).get(wall.get(0).size() - 1);
		int max = 0;
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		for (int i = 0; i < wall.size(); i++) {
			for (int j = 0; j < wall.get(i).size(); j++) {
				int cur = wall.get(i).get(j);
				if (cur != length) {
					int val;
					if (h.containsKey(cur)) {
						val = h.get(cur) + 1;
					} else {
						val = 1;
					}
					h.put(cur, val);
					if(val > max){
						max = val;
					}
				}
			}
		}
		return wall.size() - max;
	}
}
