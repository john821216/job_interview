package URI;

import java.util.Scanner;

public class _1276 {
	static String str;
	static boolean[] al;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// input.nextLine();
		while (input.hasNext()) {
			str = input.nextLine().replaceAll("\\s+", "");
			// System.out.println(str);
			al = new boolean[26];
			for (int i = 0; i < str.length(); i++) {
				al[str.charAt(i) - 'a'] = true;
			}
			boolean first = false;
			String start = "";
			String end = "";
			for (int i = 0; i < al.length; i++) {
				if (al[i]) {
					if (start.equals("")) {
						start = (char) (i + 97) + ":";
						end = (char) (i + 97) + "";
					} else {
						end = (char) (i + 97) + "";
					}
				} else{
					if(!end.equals("")) {
						if(!first){
							System.out.print(start+end);
							first =true;
						} else{
							System.out.print(", "+start+end);
						}
						start=""; end="";
					}
				}
			}
			if(!end.equals("")) {
				if(!first){
					System.out.print(start+end);
					first =true;
				} else{
					System.out.print(", "+start+end);
				}
//				start=""; end="";
			}
			System.out.println();
		}

	}
}
