package URI;

import java.util.Scanner;

public class _1278 {
	static int lineCount;
	static String[] str;
	static int maxLength = -1;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			lineCount = input.nextInt();
			maxLength=-1;
			if(lineCount ==0) break;
			str = new String[lineCount];
			input.nextLine();
			for (int i = 0; i < lineCount; i++) {
				str[i] = input.nextLine();
				String newStr = "";
				boolean first = false;
				for (int j = 0; j < str[i].split("\\s+").length; j++) {
					String spStr = str[i].split("\\s+")[j];
					if (!spStr.equals(" ")) {
						if (!first) {
							newStr += spStr;
							first = true;
						} else {
							newStr += " " + spStr;
						}
					}
				}
//				System.out.println(newStr);
				if (newStr.length() > maxLength) {
					maxLength = newStr.length();
				}
				str[i] = newStr;
			}
			for (int i = 0; i < str.length; i++) {
				if (str[i].length() < maxLength) {
					String space = "";
					for (int j = 0; j < maxLength - str[i].length(); j++) {
						space += " ";
					}
					str[i] = space + str[i];
				}
				System.out.println(str[i]);
			}
			System.out.println();
		}
	}
}
