package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class _430 {
	
	public static void main(String[] args){
		_430 a = new _430();
		a.exe();
	}
	
	public void exe(){
		Interval[] a = new Interval[3];
		a[0] = new Interval(3,4);
		a[1] = new Interval(2,3);
		a[2] = new Interval(1,2);
		int[] an = findRightInterval(a);
		
//		for(int i = 0; i < an.length ; i++){
//			System.out.println(an[i]);
//		}
	}
    public int[] findRightInterval(Interval[] intervals) {
    		IntervalWithIndex[] iw = new IntervalWithIndex[intervals.length];
    		int[] ia = new int[intervals.length];
        for(int i = 0 ; i < intervals.length ; i++){
        		iw[i] = new IntervalWithIndex(intervals[i] , i);
        }
        Arrays.sort(iw, new IntervalComparator());
		for(int i = 0; i < iw.length ; i++){
			System.out.println(iw[i].i.start +" " + iw[i].i.end +" " +iw[i].index);
		}
        for(int i = 0 ; i < iw.length ; i++){
        		int end = iw[i].i.end;
        		int minTargetIndex = binarySearch(iw, 0 , intervals.length-1, end);
        		if(iw[minTargetIndex].i.start >= end){
        			ia[iw[i].index] = iw[minTargetIndex].index;
        		} else{
        			ia[iw[i].index] = -1;
        		}
        }
        
        for(int i =0 ; i< ia.length; i++){
        		System.out.println(ia[i]);
        }
        return ia;
    }
    
    public int binarySearch(IntervalWithIndex[] i, int l , int r, int target){
    		while(l < r){
    			int mid = l + (r-l)/2;
    			if(target > i[mid].i.start){
    				l = mid + 1;
    			} else if (target <= i[mid].i.start){
    				r = mid;
    			} 
    		}
    		return r;
    }
}

class IntervalComparator implements Comparator<IntervalWithIndex>{

	@Override
	public int compare(IntervalWithIndex o1, IntervalWithIndex o2) {
		return o1.i.start - o2.i.start;
	}
	
}

class IntervalWithIndex{
	
	public IntervalWithIndex(Interval i, int index){
		this.i = i;
		this.index = index;
	}
	Interval i;
	int index;
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}
