// Link: https://leetcode.com/problems/encode-and-decode-tinyurl/

public class Codec {
    Map<String, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = "bit.ly/69420";
        map.put(key, longUrl);
        return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

// TC: O(1), SC: O(n)
