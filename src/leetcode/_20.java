package leetcode;

import java.util.Stack;

public class _20 {
	public static void main(String[] args){
		_20 a = new _20();
		a.execute();
	}
	
	public void execute(){
		System.out.println(isValid("([]{})"));
	}
	
	public boolean isValid(String s) {
		Stack<Character> st = new Stack<Character>();
		for(int i = 0 ; i < s.length() ; i++){
			char curChar = s.charAt(i);
			if(curChar == '{' || curChar == '[' || curChar == '('){
				st.push(curChar);
			} else if(curChar == '}'){
				if(st.isEmpty()) return false;
				if(!st.isEmpty()){
					if(st.peek() == '{'){
						st.pop();
					} else{
						st.push(curChar);
					}
				}
			} else if(curChar == ']'){
				if(st.isEmpty()) return false;
				if(!st.isEmpty()){
					if(st.peek() == '['){
						st.pop();
					} else{
						st.push(curChar);
					}
				}
			} else{
				if(st.isEmpty()) return false;
				if(!st.isEmpty()){
					if(st.peek() == '('){
						st.pop();
					} else{
						st.push(curChar);
					}
				}
			}
		}
		return st.isEmpty();
	}
}
