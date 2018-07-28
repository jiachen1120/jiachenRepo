class Solution {
    public int romanToInt(String s) {
        int pre = Integer.MAX_VALUE;
        int cur = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<> ();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        for (char c : s.toCharArray()) {
            cur = map.get(c);
            if (cur <= pre) {
                res += cur;
            } else {
                res += cur - 2 * pre;
            }
            pre = cur;
        }
        return res;
    }
}