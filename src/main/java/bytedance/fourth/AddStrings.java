package bytedance.fourth;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/7 08:22
 */
public class AddStrings {

    public static void main(String[] args) {
        addStrings("456", "77");
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder sb1 = new StringBuilder(num1);
        sb1.reverse();
        StringBuilder sb2 = new StringBuilder(num2);
        sb2.reverse();
        int plus = 0;
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < Math.max(sb1.length(), sb2.length()); i++) {
            int tmp1 = (i > sb1.length() -1 ? '0' : sb1.charAt(i)) - '0';
            int tmp2 = (i > sb2.length() -1 ? '0' : sb2.charAt(i)) - '0';
            int tmpSum = tmp1 + tmp2 + plus;
            if (tmpSum > 9) {
                plus = 1;
            } else {
                plus = 0;
            }
            result.append(tmpSum % 10);
        }
        if (plus == 1) {
            result.append("1");
        }
        return result.reverse().toString();
    }


}
