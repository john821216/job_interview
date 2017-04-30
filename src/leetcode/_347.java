package Leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

public class _347 {
	public static void main(String[] args){
		_347 a = new _347();
		a.execute();
	}
	
	public void execute(){
		int[] arr ={ 1,1,1,2,2,2,3,3,3};
		topKFrequent2(arr,2);
	}
	
	public List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		for (int i : nums) {
			if (h.get(i) != null) {
				h.put(i, h.get(i) + 1);
			} else {
				h.put(i, 1);
			}
		}
		PriorityQueue<Num> p = new PriorityQueue<Num>(new Num());
		Set<Integer> s = h.keySet();
		Iterator<Integer> it = s.iterator();
		while (it.hasNext()) {
			int key = it.next();
			int value = h.get(key);
			Num n = new Num(key, value);
			p.add(n);
		}

		List<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i < k; i++) {
			l.add(p.poll().n);
		}
		return l;

	}

	private class Num implements Comparator<Num> {
		int count;
		int n;

		public Num() {

		}

		public Num(int n, int count) {
			this.count = count;
			this.n = n;
		}

		@Override
		public int compare(Num o1, Num o2) {
			return o1.count - o2.count;
		}
	}

	public List<Integer> topKFrequent2(int[] nums, int k) {
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		ArrayList<ArrayList<Integer>> aa = new ArrayList<ArrayList<Integer>>();
		List<Integer> an = new ArrayList<Integer>();
		for(int i = 0 ; i < nums.length+1 ; i++){
			//bucket
			aa.add(new ArrayList<Integer>());
		}
		int left = k;
		for (int num : nums) {
			hm.put(num, hm.getOrDefault(num, 0) + 1);
		}
		for (int key : hm.keySet()) {
			int freq = hm.get(key);
			aa.get(freq).add(key);
		}
		for (int pos = nums.length ; pos >= 0; pos--) {
			if (aa.get(pos).size() > 0) {
				for (int i = 0; i < aa.get(pos).size() && left > 0; i++){
					left--;
					an.add(aa.get(pos).get(i));
					//print an 
					System.out.println(aa.get(pos).get(i));
				}
			}
		}
		return an;
	}

}
