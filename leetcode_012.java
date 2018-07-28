class Solution {
    public String intToRoman(int num) {
        LinkedList<StringBuilder> roms = new LinkedList<> ();
        StringBuilder opt = new StringBuilder();
        List<pair> map = new ArrayList<> ();
        map.add(new pair('I', 'V'));
        map.add(new pair('X', 'L'));
        map.add(new pair('C', 'D'));
        map.add(new pair('M', ' '));
        int count = 0;
        while (num != 0) {
            StringBuilder res = new StringBuilder();
            int pop = num % 10;
            num = num / 10;
            if (pop == 9) {
                res.append(map.get(count).x);
                res.append(map.get(count + 1).x);
            }
            else if (pop > 4) {
                res.append(map.get(count).y);
                for (int i = 0; i < pop - 5; i++) {
                    res.append(map.get(count).x);
                }
            }
            else if (pop == 4) {
                res.append(map.get(count).x);
                res.append(map.get(count).y);
            }
            else if (pop < 4) {
                for (int i = 0; i < pop; i++) {
                    res.append(map.get(count).x);
                }
            }
            roms.addFirst(res);
            count++;
        }
        while (!roms.isEmpty()) {
            opt.append(roms.removeFirst());
        }
        return opt.toString();
    }
}

class pair {
    public char x;
    public char y;
    public pair(char x, char y) {
        this.x = x;
        this.y = y;
    }
}