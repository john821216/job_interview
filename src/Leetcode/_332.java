package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class _332 {
	public static void main(String[] args) {
		_332 a = new _332();
		a.execute();
	}

	public void execute() {
		// String[][] s = { { "EZE", "TIA" }, { "EZE", "HBA" }, { "AXA", "TIA"
		// },
		// { "JFK", "AXA" }, { "ANU", "JFK" }, { "ADL", "ANU" },
		// { "TIA", "AUA" }, { "ANU", "AUA" }, { "ADL", "EZE" },
		// { "ADL", "EZE" }, { "EZE", "ADL" }, { "AXA", "EZE" },
		// { "AUA", "AXA" }, { "JFK", "AXA" }, { "AXA", "AUA" },
		// { "AUA", "ADL" }, { "ANU", "EZE" }, { "TIA", "ADL" },
		// { "EZE", "ANU" }, { "AUA", "ANU" } };
		String[][] s = { { "C", "JFK" },{"A","JFK"}, { "JFK", "A" }, { "JFK", "B" } , {"JFK" , "C"}};
		findItinerary2(s);
	}

	public List<String> findItinerary(String[][] tickets) {
		HashMap<String, ArrayList<String>> h = new HashMap<String, ArrayList<String>>();
		List<String> l = new ArrayList<String>();
		for (int i = 0; i < tickets.length; i++) {
			ArrayList<String> p;
			if (h.get(tickets[i][0]) == null) {
				p = new ArrayList<String>();
			} else {
				p = h.get(tickets[i][0]);
			}
			p.add(tickets[i][1]);
			h.put(tickets[i][0], p);
		}

		for (String s : h.keySet()) {
			ArrayList<String> a = h.get(s);
			Collections.sort(a);
		}

		l.add("JFK");
		visit("JFK", h, l, tickets.length);

		System.out.println(l);
		return l;
	}

	public List<String> visit(String s, HashMap<String, ArrayList<String>> h,
			List<String> l, int count) {
		if (count == 0) {
			return l;
		}

		ArrayList<String> p = h.get(s);
		if (p == null) {
			return null;
		}
		for (int i = 0; i < p.size(); i++) {
			String ele = p.get(0);
			p.remove(0);
			l.add(ele);
			List<String> v = visit(ele, h, l, count - 1);
			if (v == null) {
				p.add(ele);
				l.remove(l.size() - 1);
			} else {
				return l;
			}
		}
		return null;
	}

	Map<String, PriorityQueue<String>> targets = new HashMap<>();
	List<String> route = new LinkedList();

	public List<String> findItinerary2(String[][] tickets) {
		for (String[] ticket : tickets)
			targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(
					ticket[1]);
		visit2("JFK");
		System.out.println("Route: " + route);
		return route;
	}

	void visit2(String airport) {
		while (targets.containsKey(airport) && !targets.get(airport).isEmpty()) {
			String poll2 = targets.get(airport).poll();
			System.out.println(poll2);
			visit2(poll2);
		}
		System.out.println("101" + airport);
		route.add(0, airport);
	}
}
