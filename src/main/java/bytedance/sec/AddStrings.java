package bytedance.sec;

import java.util.ArrayList;
import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/23 10:05
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        List<Character> str1 = new ArrayList<>();
        List<Character> str2 = new ArrayList<>();
        for (int i = num1.length() - 1; i >= 0 ; i--) {
            str1.add(num1.charAt(i));
        }
        for (int i = num2.length() - 1; i >= 0 ; i--) {
            str2.add(num2.charAt(i));
        }
        boolean plus = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.max(str1.size(), str2.size()); i++) {
            int tmp1 = i > str1.size() - 1 ? 0 : str1.get(i) - '0';
            int tmp2 = i > str2.size() - 1 ? 0 : str2.get(i) - '0';
            int sum = tmp1 + tmp2;
            if (plus) {
                sum++;
            }
            if (sum > 9) {
                plus = true;
            } else {
                plus = false;
            }
            sb.append(sum % 10);
        }
        if (plus) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }

}
