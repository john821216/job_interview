package POJ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _1706 {
	static ref[] r;
	static int newCount = 1;
	static String line;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		r = new ref[1000];

		for (int i = 0; i < 1000; i++) {
			r[i] = new ref();
		}
		while (input.hasNext()) {
			line = input.nextLine();
			System.out.println("21 " + line);
			while (isBlank(line)) {
				line = input.nextLine();

			}

			if (line.charAt(0) == '[') {
				int j = 1;
				String number = "";
				while (line.charAt(j) != ']') {
					number += line.charAt(j);
					j++;
				}
				int iNumber = Integer.parseInt(number);
				System.out.println("34 " +iNumber);

				r[iNumber].desc += line;
				r[iNumber].desc += "\n";
				line = input.nextLine();
				while (!isBlank(line)) {
					r[iNumber].desc += line;
					r[iNumber].desc += "\n";
					line = input.nextLine();
				}
//				System.out.println(r[iNumber].desc);
			} else {
				String des = line;
				String newDes = "";
				while (true) {
					for (int i = 0; i < des.length(); i++) {
						if (des.charAt(i) == '[') {
							int j = i+1;
							String number = "";
							newDes += '[';
							while (des.charAt(j) != ']') {
								number += des.charAt(j);
								j++;
							}
//							System.out.println(number);
							i = j;
							int iNumber = Integer.parseInt(number);
							if(r[iNumber].newN ==1001){
								r[iNumber].newN = newCount;
							}
							newDes += r[iNumber].newN+ "]";
							newCount++;
//							System.out.println("65 " +newCount);
						} else {
							newDes += des.charAt(i);
						}
					}
					System.out.println(newDes);
					newDes = "";
					des = input.nextLine();
					if (isBlank(des))
						break;
				}
				System.out.println();
			}
		}
		Arrays.sort(r , new refComparator());
		for(int i = 0; i < r.length ; i++){
			if(r[i].newN == 1001){
				break;
			} else{
				String newS = "[" + (i+1) +"]" +r[i].desc.split("]")[1];
				System.out.println(newS);
			}
		}
		
	}

	public static boolean isBlank(String s) {
		boolean isB = true;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				isB = false;
			}
		}
		return isB;
	}
}

class refComparator implements Comparator<ref>{

	@Override
	public int compare(ref o1, ref o2) {
		return o1.newN - o2.newN;
	}
	
}

class ref {
	String desc="";
	int newN = 1001;
}
