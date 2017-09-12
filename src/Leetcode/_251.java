package Leetcode;

import java.util.Iterator;
import java.util.List;

public class _251 implements Iterator<Integer> {
	int column;
	int row;
	List<List<Integer>> vec2d;

	public _251(List<List<Integer>> vec2d) {
			this.vec2d = vec2d;
			column = 0;
			row = 0;
	        while(row < vec2d.size() &&vec2d.get(row).size()==0) {
				row++;
			}
		}

	@Override
	public Integer next() {
		int ele = vec2d.get(row).get(column);
		if (column + 1 >= vec2d.get(row).size()) {
			row++;
			while (row < vec2d.size() && vec2d.get(row).size() == 0) {
				row++;
			}
			column = 0;
		} else {
			column++;
		}

		return ele;
	}

	@Override
	public boolean hasNext() {
		return row < vec2d.size() - 1 || row == vec2d.size() - 1 && column < vec2d.get(row).size();
	}
}
