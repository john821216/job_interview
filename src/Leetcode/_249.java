package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _249 {
	public static void main(String[] args) {
		_249 a = new _249();
		a.execute();
	}

	public void execute() {
		groupStrings(new String[] { "ba" });
	}

	public List<List<String>> groupStrings(String[] strings) {
		List<List<String>> ll = new ArrayList<List<String>>();
		HashMap<String, List<String>> h = new HashMap<String, List<String>>();
		for (String str : strings) {
			StringBuilder sb = new StringBuilder();
			int dis = -1;
			for (int i = 0; i < str.length(); i++) {
				if (i == 0) {
					dis = str.charAt(i) - 'a';
					sb.append("0,");
				} else {
					sb.append(((str.charAt(i) - 'a') - dis + 26) % 26 + ",");
				}
			}
			List<String> l;
			if (!h.containsKey(sb.toString())) {
				l = new ArrayList<String>();
			} else {
				l = h.get(sb.toString());
			}
			l.add(str);
			h.put(sb.toString(), l);
		}

		for (List<String> l : h.values()) {
			System.out.println(l);
			ll.add(l);

		}
		return ll;
	}
}
