package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class OA2 {

	public static void main(String[] args) {
		OA2 a = new OA2();

		a.execute();
	}

	public void execute() {
		assert true == Arrays.equals(new String[] { "friend1", "friend2" },
				findLargestFriendCircle(new String[][] { { "friend1", "friend2" }, { "friend3", "friend4" } }));
		findLargestFriendCircle(new String[][] { { "friend1", "friend2" }, { "friend3", "friend4" } });
	}

	/*
	 * new String[] {"friend3", "friend4", "friend5"}. , new
	 * FriendFriendCircle().findLargestFriendCircle(new String[][]{ {"friend1",
	 * "friend2"}, {"friend3", "friend4"}, {"friend4", "friend5"}, }));
	 */
	public String[] findLargestFriendCircle(String[][] f) {
		HashSet<String> h = new HashSet<String>();
		HashMap<String, String> parent = new HashMap<String, String>();
		HashMap<String, Integer> size = new HashMap<String, Integer>();

		for (int i = 0; i < f.length; i++) {
			if (!h.contains(f[i][0])) {
				h.add(f[i][0]);
				size.put(f[i][0], 1);
				parent.put(f[i][0], f[i][0]);
			}

			if (!h.contains(f[i][1])) {
				h.add(f[i][1]);
				size.put(f[i][1], 1);
				parent.put(f[i][1], f[i][1]);
			}
		}

		for (int i = 0; i < f.length; i++) {
			connect(parent, size, f[i][0], f[i][1]);
		}
		int maxCount = 0;
		HashMap<String, Integer> count = new HashMap<String, Integer>();
		ArrayList<String> a = new ArrayList<String>();
		for (String p : parent.values()) {
			if (!count.containsKey(p)) {
				count.put(p, 1);
			} else {
				count.put(p, count.get(p) + 1);
			}
			maxCount = Math.max(maxCount, count.get(p));
		}

		for (String p : parent.keySet()) {
			a.add(p);
		}

		Collections.sort(a);
		String maxP = "";
		for (int i = 0; i < a.size(); i++) {
			if (count.get(parent.get(a.get(i))) == maxCount) {
				maxP = a.get(i);
				break;

			}
		}

		for (String p : parent.keySet()) {
			if (parent.get(p).equals(maxP)) {
				System.out.println(p);
			}
		}
		return "";

	}

	public void connect(HashMap<String, String> parent, HashMap<String, Integer> size, String p, String q) {
		String pParent = find(parent, parent.get(p));
		String qParent = find(parent, parent.get(q));
		if (pParent.equals(qParent)) {
			return;
		}

		int pSize = size.get(p);
		int qSize = size.get(q);
		if (pSize < qSize) {
			parent.put(p, qParent);
			size.put(q, size.get(q) + size.get(p));
		} else {
			parent.put(q, pParent);
			size.put(p, size.get(q) + size.get(p));
		}
	}

	public String find(HashMap<String, String> parent, String p) {
		if (parent.get(p).equals(p)) {
			return p;
		}

		String parentP = find(parent, parent.get(p));
		parent.put(p, parentP);
		return parentP;
	}
}
