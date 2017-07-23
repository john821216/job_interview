package Leetcode;

import java.util.HashMap;

public class _535 {
	HashMap<String, String> idx = new HashMap<String, String>();
	HashMap<String, String> revIdx = new HashMap<String, String>();
	String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHJIKLMNOPQRSTUVWXYZ0123456789";
	final String BASE_HOST = "http://tinyurl.com/4e9iAk";

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		if (revIdx.containsKey(longUrl)) {
			return BASE_HOST + revIdx.get(longUrl);
		}
		String urlIdx = "";
		while (true) {
			urlIdx = "";
			for (int i = 0; i < 6; i++) {
				urlIdx += charSet.charAt((int) (Math.random() * charSet
						.length()));
			}
			if (!idx.containsKey(urlIdx)) {
				idx.put(urlIdx, longUrl);
				revIdx.put(longUrl, urlIdx);
				break;
			}
		}
		return BASE_HOST + urlIdx;
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		shortUrl = shortUrl.replace(BASE_HOST, "");
		return idx.get(shortUrl);
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));

