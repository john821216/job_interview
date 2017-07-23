package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _609 {
	public static void main(String[] args) {
		findDuplicate(new String[] { "root/a 1.txt(abcd) 2.txt(efgh)",
				"root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)",
				"root 4.txt(efgh)" });
	}

	public static List<List<String>> findDuplicate(String[] paths) {
		HashMap<String, List<String>> h = new HashMap<String, List<String>>();
		for (String s : paths) {
			for (int i = 1; i < s.split(" ").length; i++) {

				String path = s.split(" ")[0] + s.split(" ")[i].split("\\(")[0];
				String content = s.split(" ")[i].split("\\(")[1].split("\\)")[0];
				System.out.println(path +" " +content);
				List<String> l = h.get(content);
				if (l == null) {
					l = new ArrayList<String>();
				}
				l.add("/"+ path);
				h.put(content, l);
			}
		}

		List<List<String>> an = new ArrayList<List<String>>();
		for (Map.Entry<String, List<String>> e : h.entrySet()) {
			List<String> get= e.getValue();
			if(get.size() > 1){
				an.add(e.getValue());
			}
		}
		return an;
	}
}
