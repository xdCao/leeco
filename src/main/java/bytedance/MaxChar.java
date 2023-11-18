package bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/17 17:24
 */
public class MaxChar {

    public static void main(String[] args) {
        maxChar("21313213213213dsdsdssdsxxxxxaaww");
    }

    public static void maxChar(String s) {
        char[] charArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int maxCnt = 0;
        Character maxC = null;
        for (char c : charArray) {
            if (map.containsKey(c)) {
                Integer newCnt = map.get(c) + 1;
                if (newCnt > maxCnt) {
                    maxCnt= newCnt;
                    maxC = c;
                }
                map.put(c, newCnt);
            } else {
                map.put(c, 1);
                if (maxCnt < 1) {
                    maxCnt = 1;
                    maxC = c;
                }
            }
        }
        System.out.println(maxC + " : " + maxCnt);

    }

}
