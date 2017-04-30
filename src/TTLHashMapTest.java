import java.util.concurrent.TimeUnit;

public class TTLHashMapTest {
	static TTLHashMap<Integer, Integer> tm;
	
	public static void main(String[] args){
		 tm = new TTLHashMap<Integer, Integer>(
					TimeUnit.SECONDS, 3);
	}
}
