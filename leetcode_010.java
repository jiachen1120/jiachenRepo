class Solution {
    public boolean isMatch(String s, String p) {
        if (s.isEmpty() && p.isEmpty()) {
            return true;
        }
        if (!s.isEmpty() && p.isEmpty()) {
            return false;
        }
        if (p.length() > 1 && p.charAt(1) == '*') {
            String remainingP = p.substring(2);
            String remainingS = s;
            for (int i = 0; i < s.length() + 1; i++) {
                if (isMatch(remainingS, remainingP)) {
                    return true;
                }
                if (remainingS.isEmpty()) {
                    return false;
                }
                if (p.charAt(0) != '.' && remainingS.charAt(0) != p.charAt(0)) {
                    return false;
                }
                remainingS = remainingS.substring(1);
            }
        }
        if (p.isEmpty() || s.isEmpty()) {
            return false;
        }
        if (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) {
            String remainingP = "";
            String remainingS = "";
            if (p.length() > 1) {
                remainingP = p.substring(1);
            }
            if (s.length() > 1) {
                remainingS = s.substring(1);
            }
            return isMatch(remainingS, remainingP);
        }
        return false;
    }
}