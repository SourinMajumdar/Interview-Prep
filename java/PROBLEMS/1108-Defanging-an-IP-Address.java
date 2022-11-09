// Link: https://leetcode.com/problems/defanging-an-ip-address/

class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}

// TC: O(n)



class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();

        for (char c : address.toCharArray()) {
            if (c != '.') sb.append(c);
            else sb.append("[.]");
        }

        return sb.toString();
    }
}

// TC: O(n)


