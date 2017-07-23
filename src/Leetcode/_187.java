package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class _187 {

	public static void main(String[] args) {
		_187 a = new _187();
		a.execute();
	}

	public void execute() {
		findRepeatedDnaSequences("AAAAAAAAAAAAA");
	}

	public List<String> findRepeatedDnaSequences(String s) {
		HashSet<String> seen = new HashSet<String>();
		HashSet<String> repeat = new HashSet<String>();
		for (int i = 0; i + 9 < s.length(); i++) {
			String str = s.substring(i,i+10);
			if(!seen.add(str)){
				repeat.add(str);
			}
		}
		return new ArrayList<String>(repeat);
	}
}
