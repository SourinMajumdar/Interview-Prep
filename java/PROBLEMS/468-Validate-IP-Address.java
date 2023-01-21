// Link: https://leetcode.com/problems/validate-ip-address/description/
// explanation in post

class Solution {
    public String validIPAddress(String queryIP) {
        return
            isIPv4(queryIP)? "IPv4" :
            isIPv6(queryIP)? "IPv6" : "Neither"
        ;
    }

    private boolean isIPv4(String s) {
        if (s.contains(":") || s.startsWith(".") || s.endsWith(".")) {
            return false;
        }

        String[] parts = s.split("\\.");
        if (parts.length != 4) {
            return false;
        }

        for (String p : parts) {
            for (char c : p.toCharArray()) {
                if (Character.isLetter(c)) {
                    return false;
                }
            }
            if (p.length() == 0 || p.length() > 3) {
                return false;
            }

            int num = Integer.parseInt(p);
            if (num < 0 || num > 255) {
                return false;
            }
            if (p.length() > 1 && (p.startsWith("0") || p.startsWith("00") || p.equals("000"))) {
                return false;
            }
        }

        return true;
    }

    private boolean isIPv6(String s) {
        if (s.contains(".") || s.startsWith(":") || s.endsWith(":")) {
            return false;
        }
        String[] parts = s.split(":");
        if (parts.length != 8) {
            return false;
        }

        for (String p : parts) {
            if (p.length() == 0 || p.length() > 4) {
                return false;
            }
            for (char c : p.toCharArray()) {
                if (Character.isLetter(c)) {
                    if (Character.isUpperCase(c) && c > 'F') {
                        return false;
                    }
                    if (Character.isLowerCase(c) && c > 'f') {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}

// TC: O(1), SC: O(1)
// We will either have a string array of size 4 (IPv4) or 8 (IPv6) which is constant