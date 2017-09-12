package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OA1 {

	public static void main(String[] args) {
		OA1 a = new OA1();
		a.execute();
	}

	public void execute() {
		List<List<String>> ll = new ArrayList<List<String>>();
		ll.add(Arrays.asList("orange", "banana", "orange"));
		ll.add(Arrays.asList("apple", "apple"));
		List<String> shoppingList = Arrays.asList("orange", "apple", "apple", "orange", "banana", "orange");
		System.out.println(checkWinner(ll, shoppingList));
	}

	public int checkWinner(List<List<String>> codeList, List<String> shoppingCart) {
		Queue<List<Integer>> q = new LinkedList<List<Integer>>();
		int codeListSize = codeList.size();
		List<Integer> addL = new ArrayList<Integer>();
		addL.add(-1);
		for (int i = 0; i < codeListSize; i++) {
			addL.add(-1);
		}
		q.add(addL);
		while (!q.isEmpty()) {
			List<Integer> l = q.poll();
			System.out.println(l);
			boolean find = true;
			for (int i = 1; i < l.size(); i++) {
				if (l.get(i) != codeList.get(i - 1).size() - 1) {
					find = false;
				}
			}
			if (find) {
				return 1;
			}
			String shoppingNext = shoppingCart.get(l.get(0) + 1);
			boolean match = false;
			for (int i = 1; i < l.size(); i++) {
				int idx = l.get(i);
				if (idx + 1 == codeList.get(i - 1).size()) {
					continue;
				}
				if (codeList.get(i - 1).get(idx + 1).equals(shoppingNext) || shoppingNext.equals("anything")) {
					match = true;
					l.set(0, l.get(0) + 1);
					l.set(i, idx + 1);
					if (l.get(0) < shoppingCart.size()) {
						q.add(new ArrayList<Integer>(l));
					}
				}
			}

			if (!match) {
				l.set(0, l.get(0) + 1);
				if (l.get(0) < shoppingCart.size()) {
					q.add(new ArrayList<Integer>(l));
				}
			}
		}
		return 0;

	}

}
