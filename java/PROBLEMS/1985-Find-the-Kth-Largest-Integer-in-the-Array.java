// Link: https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/description/

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> (a.length() == b.length())?
             a.compareTo(b) : Integer.compare(a.length(), b.length())
        );

        for (String s : nums) {
            pq.offer(s);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.poll();
    }
}

// TC: O(n * logk), SC: O(n)



import java.math.BigInteger;
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<BigInteger> pq = new PriorityQueue<>();
        for (String s : nums) {
            pq.offer(new BigInteger(s));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.poll().toString();
    }
}

// TC: O(n * logk), SC: O(n)