
public class RandomNumber {
	public static void main(String[] args){
		int left = -1;
		int right = -1;
		int range = right - left + 1;
		int randomIndex = (int)(Math.random() * range) + left;
		System.out.println(randomIndex);
	}
}
