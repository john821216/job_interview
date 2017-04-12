package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139 {
	public static void main(String[] args) {
		_139 a = new _139();
		a.execute();
	}

	public void execute() {
		List<String> dict = new ArrayList<String>();
		dict.add("leet");
		dict.add("code");
		System.out.println(wordBreak("leetcode", dict));
	}

	public boolean wordBreak(String s, List<String> dict) {
		boolean[] f = new boolean[s.length()+1];
		f[0] = true;
		
		for(int i = 1; i <=s.length() ; i++){
			for(int j = 0 ; j < i ; j++){
				if(f[j] == true && dict.contains(s.substring(j, i))){
					f[i] = true;
					break;
				}
			}
		}
		return f[s.length()];
	}
}
