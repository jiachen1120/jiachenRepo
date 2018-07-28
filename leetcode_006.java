class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int count1 = 0;
        int count2 = 0;
        String longest = new String();
        for (int i = 0; i < s.length() - 1; i++) {
            int a = longestPalindrome(s, i, i + 1);
            int b = longestPalindrome(s, i - 1, i + 1);
            count1 = 2*a;
            count2 = 2*b + 1;
            if (count1 > count2) {
                if (count1 > longest.length()) {
                    longest = s.substring(i - a + 1, i + a + 1);
                }
            } else {
                if (count2 > longest.length()) {
                    longest = s.substring(i - b, i + b + 1);
                }
            }
        }
        return longest;
    }
    public int longestPalindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}