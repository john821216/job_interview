package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _93 {
	public static void main(String[] args) {
		_93 a = new _93();
		a.execute();
	}

	public void execute() {
		restoreIpAddresses("");
	}

	public List<String> restoreIpAddresses(String s) {
		List<String> l = new ArrayList<String>();
		restoreIpAddresses(l, "25525511135", "", 0, 4);
		return l;
	}

	public void restoreIpAddresses(List<String> l, String s, String temp,
			int start, int count) {
		if (count == 0 && start == s.length()) {
			l.add(temp);
			System.out.println(temp);
			return;
		}
		if (count != 0) {
			for (int len = 1; len <= 4; len++) {
				if(start+len >s.length()) break;
				String curStr = s.substring(start, start+len);
				if ((curStr.startsWith("0") && curStr.length() > 1)
						|| Integer.parseInt(curStr) > 255) {
					continue;
				}
				String store = temp;
				if (count != 4) {
					temp += "." + curStr;
				} else {
					temp += curStr;
				}
				restoreIpAddresses(l, s, temp, start+len, count - 1);
				temp = store;
			}
		}
	}
}
