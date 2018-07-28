class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int num = 0;
        while (num < strs[0].length()) {
            char first = strs[0].charAt(num);
            for (int i = 1; i < strs.length; i++) {
                if (num >= strs[i].length() || strs[i].charAt(num) != first) {               
                    return strs[0].substring(0, num);
                }
            }
            num++;
        }
        return strs[0].substring(0,num);
    }
}