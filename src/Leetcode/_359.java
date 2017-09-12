package Leetcode;

import java.util.HashMap;

public class _359 {
	HashMap<String,Integer> h;
    public _359() {
        h = new HashMap<String, Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!h.containsKey(message)) {
        		h.put(message, timestamp);
        		return true;
        } else {
        		int preTime = h.get(message);
        		if(timestamp-preTime < 10) {
        			return false;
        		} else {
            		h.put(message, timestamp);
            		return true;
        		}
        }
    }
}
