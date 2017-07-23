package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _524 {
	public static void main(String[] args) {
		_524 a = new _524();
		a.execute();
	}

	public void execute() {
		List<String> l = new ArrayList<String>();
		l.add("zz");
		// l.add("aea");
		// l.add("awefawfwaf");
		// l.add("ewafeffewafewf");
		findLongestWord("abpcplea", l);
	}

	public String findLongestWord(String s, List<String> d) {
		d.sort(new lexicographical_order());
		for (int i = 0; i < d.size(); i++) {
			String d_c = d.get(i);
			int sIndex = 0;
			int dIndex = 0;
			
			while (sIndex < s.length() && dIndex < d_c.length()) {
				if (s.charAt(sIndex) == d_c.charAt(dIndex)) {
					sIndex++;
					dIndex++;
					if (dIndex == d_c.length())
						return d.get(i);
				} else {
					sIndex++;
				}
			}
		}
		return "";

	}

	private class lexicographical_order implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
//			int o1I = 0;
//			int o2I = 0;
			if (o1.length() != o2.length()) {
				return o2.length() - o1.length();
			}
//			while (o1I < o1.length() && o2I < o2.length()) {
//				if (o1.charAt(o1I) - 'a' > o2.charAt(o2I) - 'a') {
//					return 1;
//				} else if (o1.charAt(o1I) - 'a' < o2.charAt(o2I) - 'a') {
//					return -1;
//				} else {
//					o1I++;
//					o2I++;
//				}
//			}
//			return 0;
			
			//better way
			return o1.compareTo(o2); 
		}
	}
}
