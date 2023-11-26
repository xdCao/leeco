package bytedance.thd;

import java.util.ArrayList;
import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/26 21:18
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        for (int i = arr1.length - 1; i >= 0; i--) {
            list1.add(arr1[i]);
        }

        for (int i = arr2.length - 1; i >= 0; i--) {
            list2.add(arr2[i]);
        }

        int plus = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.max(list1.size(), list2.size()); i++) {
            int tmp1 = i >= list1.size() ? 0 : list1.get(i) - '0';
            int tmp2 = i >= list2.size() ? 0 : list2.get(i) - '0';
            int sum = tmp1 + tmp2 + plus;
            if (sum > 9) {
                plus = 1;
            } else {
                plus = 0;
            }
            sb.append(sum % 10);
        }
        if (plus > 0) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }

}
