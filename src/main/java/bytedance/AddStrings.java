package bytedance;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/18 23:36
 */
public class AddStrings {

    public static void main(String[] args) {
        String s = addStrings("1", "9");
        System.out.println(s);
    }


    private static Map<Character, Integer> map = new HashMap<>();
    static {
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('0', 0);
    }


    public static String addStrings(String num1, String num2) {
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();

        int index1 = arr1.length - 1;
        int index2 = arr2.length - 1;
        Stack<String> stack = new Stack<>();
        int plus = 0;
        while (true) {
            if (index1 < 0 && index2 < 0) {
                break;
            }
            if (index1 < 0) {
                int tmp = map.get(arr2[index2]) + plus;
                if (tmp > 9) {
                    tmp = tmp % 10;
                    plus = 1;
                } else {
                    plus = 0;
                }
                stack.push(String.valueOf(tmp));
                index2--;
                continue;
            }
            if (index2 < 0) {
                int tmp = map.get(arr1[index1]) + plus;
                if (tmp > 9) {
                    tmp = tmp % 10;
                    plus = 1;
                } else {
                    plus = 0;
                }
                stack.push(String.valueOf(tmp));
                index1--;
                continue;
            }
            int tmp = map.get(arr1[index1]) + map.get(arr2[index2]) + plus;
            if (tmp > 9) {
                tmp = tmp % 10;
                plus = 1;
            } else {
                plus = 0;
            }
            stack.push(String.valueOf(tmp));
            index1--;
            index2--;
        }

        StringBuilder sb = new StringBuilder();
        if (plus > 0) {
            sb.append("1");
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }



}
