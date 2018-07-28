class Solution {
    public int myAtoi(String str) {
        int rst = 0;
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        } 
        boolean isNegative = false;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
                isNegative = (str.charAt(0) == '-') ? true : false; 
                str = str.substring(1);
            }
        if (str.length() == 0 || str.charAt(0) < '0' || str.charAt(0) > '9') {
            return 0;
        }
        for (char c : str.toCharArray()) {
            if (c < '0' || c > '9') {
                break; 
            }
            int value = c - '0';
            if (!isNegative) {
                if (rst > Integer.MAX_VALUE / 10 || (rst == Integer.MAX_VALUE / 10 && value > 7)) return Integer.MAX_VALUE;
                rst = rst * 10 + value;
            } else {
                if (rst < Integer.MIN_VALUE / 10 || (rst == Integer.MIN_VALUE / 10 && value > 8)) return Integer.MIN_VALUE;
                rst = rst * 10 - value;
            }
        }
        return rst;
    }
}