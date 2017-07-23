package Leetcode;

public class _537 {
	public static void main(String[] args){
		_537 a = new _537();
		a.execute();
	}
	
	public void execute(){
		System.out.println(complexNumberMultiply("1+-1i", "1+-1i"));
	}
	
    public String complexNumberMultiply(String a, String b) {
    		//c+di;
    		int c;
    		int d;
    		System.out.println(a.split("\\+"));
    		int aI = Integer.parseInt(a.split("\\+")[0]);
    		int aZ = Integer.parseInt(a.split("\\+")[1].split("i")[0]);
    		
    		int bI = Integer.parseInt(b.split("\\+")[0]);
    		int bZ = Integer.parseInt(b.split("\\+")[1].split("i")[0]);
    		
    		c = aI * bI + aZ * bZ * -1;
    		d = aI * bZ + aZ * bI;
    		return c +"+" + d+"i";
    }
}
