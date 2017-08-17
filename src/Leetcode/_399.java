package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class _399 {
	public static void main(String[] args) {
		_399 a = new _399();
		a.execute();
	}

	public void execute() {
		calcEquation(new String[][] { { "a", "b" }, { "b", "c" } }, new double[] { 2.0, 3.0 },
				new String[][] { { "a", "c" }, { "b", "c" }, { "a", "e" }, { "a", "a" }, { "x", "x" } });
	}

	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		HashMap<String, List<Edge>> h = new HashMap<String, List<Edge>>();
		int len = equations.length;
		for (int i = 0; i < len; i++) {
			String from = equations[i][0];
			String to = equations[i][1];
			double val = values[i];

			if (!h.containsKey(from)) {
				List<Edge> l = new ArrayList<Edge>();
				l.add(new Edge(to, val));
				h.put(from, l);
			} else {
				List<Edge> l = h.get(from);
				l.add(new Edge(to, val));
				h.put(from, l);
			}

			if (!h.containsKey(to)) {
				List<Edge> l = new ArrayList<Edge>();
				l.add(new Edge(from, 1 / val));
				h.put(to, l);
			} else {
				List<Edge> l = h.get(to);
				l.add(new Edge(from, 1 / val));
				h.put(to, l);
			}
		}

		HashSet<String> visited;
		double[] res = new double[queries.length];

		for (int i = 0; i < queries.length; i++) {
			visited = new HashSet<String>();
			visited.add(queries[i][0]);
			dfs(queries[i][0], queries[i][1], visited, h, 1, res, i);
			if(res[i]==0) {
				res[i] = -1;
			}
		}
		
		return res;
	}

	public void dfs(String from, String to, HashSet<String> visited, HashMap<String, List<Edge>> h, double val,
			double[] res, int idx) {

		if (!h.containsKey(from) || !h.containsKey(to)) {
			res[idx] = -1.0;
			return;
		}

		if (from.equals(to)) {
			res[idx] = val;
			return;
		}

		List<Edge> l = h.get(from);
		for (int i = 0; i < l.size(); i++) {
			String t = l.get(i).to;
			if (!visited.contains(t)) {
				visited.add(t);
				dfs(t, to, visited, h, val * l.get(i).val, res, idx);
				visited.remove(t);
			}
		}
	}

	private class Edge {
		double val;
		String to;

		public Edge(String to, double val) {
			this.to = to;
			this.val = val;
		}
	}
}
