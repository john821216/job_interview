package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _401 {
	public static void main(String[] args){
		_401 a = new _401();
//		List<String> binaryWatch = new ArrayList<String>();
		a.exe();
	}
	
	public void exe(){
		List<String> binaryWatch = readBinaryWatch(2);
		
		for(int i = 0 ; i < binaryWatch.size() ; i++){
			System.out.println(binaryWatch.get(i));
		}
	}
	
	public List<String> readBinaryWatch(int num) {

		// 1 2 4 8
		int[] hour = { 1, 2, 4, 8 };
		// 1 2 4 8 16 32
		int[] minute = { 1, 2, 4, 8, 16, 32 };
		ArrayList<Integer> hourArr = new ArrayList<Integer>();
		ArrayList<Integer> minuteArr = new ArrayList<Integer>();
		List<String> an = new ArrayList<String>();
		for(int i = 0 ; i <= num ; i++){
			hourArr = generateAllPossibleNumber(i, hour);
			minuteArr = generateAllPossibleNumber(num-i, minute);
			String anStr="";
			for(int j = 0 ; j < hourArr.size() ; j++){
				if(hourArr.get(j) < 12){
					anStr = hourArr.get(j) +":";
				} else {
					continue;
				}
				for(int k = 0 ; k < minuteArr.size() ; k++){
					if(minuteArr.get(k) < 10){
						anStr += "0" +minuteArr.get(k);
						an.add(anStr);
						anStr = hourArr.get(j) +":";
					} else if(minuteArr.get(k) >= 10 && minuteArr.get(k) < 60){
						anStr += minuteArr.get(k);
						an.add(anStr);
						anStr = hourArr.get(j) +":";
					}
					
				}
			}
		}
		return an;
	}

	public ArrayList<Integer> generateAllPossibleNumber(int count, int[] arr) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		generateAllPossibleNumber(l, count, 0, 0, arr);
		return l;
	}

	public void generateAllPossibleNumber(ArrayList<Integer> l, int count,
			int num, int startIndex, int[] arr) {
		if (count == 0) {
			l.add(num);
		} else {
			for (int i = startIndex; i < arr.length; i++) {
				generateAllPossibleNumber(l, count - 1, num + arr[i], i+1, arr);
			}
		}
	}
}
