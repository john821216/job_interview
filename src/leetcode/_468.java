package Leetcode;

public class _468 {

	public static void main(String[] args) {
		_468 a = new _468();
		a.execute();
	}

	public void execute() {
		System.out.println(validIPAddress("20EE:Fb8:85a3:0:0:8A2E:0370:7334"));
		System.out.println("0370".matches("[0-9a-eA-E]+"));
	}

	public String validIPAddress(String IP) {
		if (IP.split("\\.").length == 4 && IP.charAt(IP.length()-1) != '.') {
			return IPv4Checker(IP);
		} else if (IP.split(":").length == 8 && IP.charAt(IP.length()-1) != ':') {
			return IPv6Checker(IP);
		} else {
			return "Neither";
		}
	}

	public String IPv4Checker(String IP) {
		boolean isValid = true;
		for (int i = 0; i < 4; i++) {
			String part = IP.split("\\.")[i];
			if ((part.length() > 1 && part.charAt(0) == '0')
					|| (part.length() > 3) || !part.matches("\\d+")) {
				return "Neither";
			}
			int val = Integer.valueOf(part);
			if (!(val >= 0 && val <= 255)) {
				isValid = false;
			}
		}
		if (isValid) {
			return "IPv4";
		} else {
			return "Neither";
		}
	}

	public String IPv6Checker(String IP) {
		for (int i = 0; i < 8; i++) {
			String part = IP.split(":")[i];
			System.out.println(part);
			if ((part.length() > 4) || !part.matches("[0-9A-Fa-f]+")) {
				return "Neither";
			}
		}
		return "IPv6";
	}
}
