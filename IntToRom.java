package jiachen.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IntToRom {
    public static String intToRoman(int num) {
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
            System.out.println(pop);
            if (pop == 9) {
                res.append(map.get(count).x);
                res.append(map.get(count + 1).x);
            }
            if (pop > 4) {
                res.append(map.get(count).y);
                for (int i = 0; i < num - 5; i++) {
                    res.append(map.get(count).x);
                }
            }
            if (pop == 4) {
                res.append(map.get(count).x);
                res.append(map.get(count).y);
            }
            if (pop < 4) {
                for (int i = 0; i < num; i++) {
                    res.append(map.get(count).x);
                    System.out.println(123);
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
