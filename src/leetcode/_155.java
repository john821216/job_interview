package leetcode;

import java.util.Stack;

public class _155 {
	public static void main(String[] args){
		_155 a = new _155();
		a.execute();
	}
	
	public void execute(){
		push(5);
		push(1);
		push(3);
		push(0);
		System.out.println(top());
		System.out.println(getMin());
		pop();
		System.out.println(getMin());
		pop();
		System.out.println(getMin());
		pop();
		System.out.println(getMin());
		pop();
		System.out.println(getMin());
	}
	int min = Integer.MAX_VALUE;
	Stack<Integer> s = new Stack<Integer>();
    public void push(int x) {
    		if(x <= min){
    			s.push(min);
    			min = x;
    		}
    		s.push(x);
    }

    public void pop() {
    		int topEle = s.peek();
    		s.pop();
    		if(topEle == min){
    			min = s.peek();
    			s.pop();
    		}
    }

    public int top() {
       return s.peek();
    }

    public int getMin() {
       return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

