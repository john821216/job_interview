package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _636 {

	public static void main(String[] args) {
		_636 a = new _636();
		a.execute();
	}

	public void execute() {
		int[] an = exclusiveTime(2, Arrays.asList(new String[] { "0:start:0", "1:start:2", "1:end:5", "0:end:6" }));
		for(int i : an) {
			System.out.println(i);
		}
	}

	// ["0:start:0",
	// "1:start:2",
	// "1:end:5",
	// "0:end:6"]
	public int[] exclusiveTime(int n, List<String> logs) {
		int[] an = new int[n];
		Stack<Integer> s = new Stack<Integer>();
		int time = 0;
		for (String str : logs) {
			String[] split = str.split(":");
			int id = Integer.valueOf(split[0]);
			String tag = split[1];
			int timeStamp = Integer.valueOf(split[2]);

			if (s.isEmpty()) {
				s.push(id);
				time = timeStamp;
			} else {
				if (tag.equals("start")) {
					an[s.peek()] += timeStamp - time;
					time = timeStamp;
					s.push(id);
				} else if (tag.equals("end")) {
					an[s.peek()] += timeStamp - time + 1;
					time = timeStamp + 1;
					s.pop();
				}
				
			}
		}
		return an;

	}
}
