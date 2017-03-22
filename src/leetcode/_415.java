package leetcode;

public class _415 {
	
	public static void main(String[] args){
		_415 a = new _415();
		a.execute();
	}
	
	public void execute(){
		addStrings("330","89");
	}
	public String addStrings(String num1, String num2) {
		int carry = 0;
		String newStr ="";
		if(num1.length() > num2.length()){
			String zero="";
			for(int i = 0 ; i < num1.length()-num2.length() ; i++){
				zero += "0";
			}
			num2 = zero + num2;
		} else{
			String zero="";
			for(int i = 0 ; i < num2.length()-num1.length() ; i++){
				zero += "0";
			}
			num1 = zero + num1;
		}

		for (int i = num1.length() - 1; i >=0 ; i--) {
			int n1 = Integer.parseInt(num1.charAt(i)+"");
			int n2 = Integer.parseInt(num2.charAt(i)+"");
			newStr = (n1+n2+carry)%10 + newStr;
			if(n1 + n2 + carry >= 10){
				carry = 1;
			} else{
				carry = 0;
			}
		}
		
		if(carry == 1){
			newStr = "1" + newStr;
		}
		return newStr;
	}
}
