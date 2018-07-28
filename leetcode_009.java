class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int rev = 0;
        int pop = 0;
        int org = x;
        while (x != 0) {
            pop = x % 10;
            x = x / 10;
            rev = rev * 10 + pop;
        }
        if (rev == org) {
            return true;
        }
        return false;
    }
}