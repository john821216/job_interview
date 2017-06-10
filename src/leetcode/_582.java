package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _582 {
	public static void main(String[] args) {
		_582 a = new _582();
		a.execute();
	}

	public void execute() {
		List<Integer> pid = new ArrayList<Integer>(Arrays.asList(6, 1, 3, 9, 5,
				8, 7, 4, 10));
		List<Integer> ppid = new ArrayList<Integer>(Arrays.asList(5, 8, 4, 5,
				10, 5, 3, 8, 0));
		int kill = 10;
		killProcess(pid, ppid, kill);
	}

	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid,
			int kill) {
		HashMap<Integer, List<Integer>> m  = new HashMap<Integer, List<Integer>>();
		
		for(int i = 0 ; i < ppid.size() ; i++){
			m.putIfAbsent(ppid.get(i), new LinkedList<Integer>());
			m.get(ppid.get(i)).add(pid.get(i));
		}
		
		List<Integer> killList = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();	
		killList.add(kill);
		q.add(kill);
		List<Integer> child = m.get(kill);
	
		while(!q.isEmpty()){
			child = m.get(q.poll());
			if(child == null) continue;
			for(int i : child){
			    q.add(i);
				killList.add(i);
			}
		}
		
		return killList;
	}
}
