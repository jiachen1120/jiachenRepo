class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
        if (s.length() == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int rst = 0;
        Set<Character> set = new HashSet<> ();
        while (i < s.length() && j < s.length()) {
            char c = s.charAt(j);
            if (!set.contains(c)) {
                set.add(c);
                rst = Math.max(rst, j - i + 1);
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return rst;
    }
}