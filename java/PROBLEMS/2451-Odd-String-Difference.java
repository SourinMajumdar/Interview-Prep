// Link: https://leetcode.com/problems/odd-string-difference/

// biweekly 90, 29 oct 2022
// Q1

class Solution {
    public String oddString(String[] words) {
        Map<List<Integer>, List<String>> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            char[] ch = words[i].toCharArray();
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < ch.length - 1; j++) {
                list.add(ch[j + 1] - ch[j]);
            }

            if (map.containsKey(list)) {
                map.get(list).add(words[i]);
            }
            else {
                List<String> l = new ArrayList<>();
                l.add(words[i]);
                map.put(list, l);
            }
        }

        for (List<Integer> key : map.keySet()) {
            if (map.get(key).size() == 1) {
                return map.get(key).get(0);
            }
        }

        return "";
    }
}

// TC: O(n * k) => O(n) because k is constant
// n -> length of input array
// k -> length of strings in input array

// SC: O(1) - map size will always be 2