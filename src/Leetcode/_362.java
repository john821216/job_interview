package Leetcode;

public class _362 {
	/** Initialize your data structure here. */
	int[] time;
	int[] hits;

	public _362() {
		time = new int[300];
		hits = new int[300];
	}

	/**
	 * Record a hit.
	 * 
	 * @param timestamp
	 *            - The current timestamp (in seconds granularity).
	 */
	public void hit(int timestamp) {
		int idx = timestamp % 300;
		if (time[idx] != timestamp) {
			hits[idx] = 1;
			time[idx] = timestamp;
		} else {
			hits[idx]++;
		}
	}

	/**
	 * Return the number of hits in the past 5 minutes.
	 * 
	 * @param timestamp
	 *            - The current timestamp (in seconds granularity).
	 */
	public int getHits(int timestamp) {
		int totalHit = 0;
		int count =300;
		while(count !=0 && timestamp >=0) {
			int idx = timestamp % 300;
			if(time[idx] == timestamp) {
				totalHit += hits[idx];
			}
			timestamp--;
			count--;
		}
		return totalHit;
	}
}
