package Leetcode;

import java.util.Stack;

public class _71 {
	public static void main(String[] args) {
		_71 a = new _71();
		a.execute();
		System.out.println("/////adfasdf///".split("/")[4]);
	}

	public void execute() {
		System.out.println(simplifyPath("/a/b/c"));
	}

	public String simplifyPath(String path) {
		Stack<String> s = new Stack<String>();
		for(int i = 0 ; i < path.split("/").length ; i++){
			String curStr = path.split("/")[i];
			if(curStr.equals("..")){
				if(!s.isEmpty()){
					s.pop();
				}
			} else if(!(curStr.equals(".")|| curStr.equals(""))){
				s.push(curStr);
			}
		}
		String an ="";
		if(s.isEmpty()) {
			return "/";
		}
		for(String str : s){
			an = an + "/" + str;
		}
		return an;
	}
}
