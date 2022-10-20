// Link: https://leetcode.com/problems/integer-to-roman/
// Solution: https://www.youtube.com/watch?v=y_4njlFOz5c

class Solution {
    public String intToRoman(int num) {
        TreeMap<Integer, String> map = new TreeMap<>(){{
            put(1, "I");
            put(5, "V");
            put(4, "IV");
            put(9, "IX");
            put(10, "X");
            put(40, "XL");
            put(50, "L");
            put(90, "XC");
            put(100, "C");
            put(400, "CD");
            put(500, "D");
            put(900, "CM");
            put(1000, "M");
        }};

        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            int closest = map.floorKey(num);
            sb.append(map.get(closest));
            num -= closest;
        }

        return sb.toString();
    }
}


// https://www.youtube.com/watch?v=f_F9ItFyiEg


class Solution {
    public String intToRoman(int num) {
        int[] intCode = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] code = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < intCode.length; i++) {
            while (num >= intCode[i]) {
                sb.append(code[i]);
                num -= intCode[i];
            }
        }

        return sb.toString();
    }
}

