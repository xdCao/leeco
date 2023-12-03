package bytedance.codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/3 09:50
 */
public class RestoreIpAddresses {

    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        restoreIpAddresses.restoreIpAddresses("25525511135");
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            List<String> tmp = new ArrayList<>();
            String cut = s.substring(0, i + 1);
            boolean valid = isValid(cut);
            if (valid) {
                tmp.add(cut);
                backTrack(result, tmp, s.substring(i + 1));
            }
        }
        return result;
    }

    private boolean isValid(String cut) {
        if (cut.isEmpty() || cut.length() > 3) {
            return false;
        }
        if (cut.charAt(0) == '0') {
            if (cut.length() == 1) {
                return true;
            }
            return false;
        }
        long parseInt = Long.parseLong(cut);
        return parseInt <= 255 && parseInt >= 0;
    }

    private void backTrack(List<String> result, List<String> input, String rest) {
        if (input.size() == 3) {
            if (!isValid(rest)) {
                return;
            }
            input.add(rest);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < input.size(); i++) {
                sb.append(input.get(i));
                if (i < input.size() - 1) {
                    sb.append(".");
                }
            }
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < rest.length(); i++) {
            String cut = rest.substring(0, i + 1);
            boolean valid = isValid(cut);
            if (valid) {
                List<String> tmp = new ArrayList<>(input);
                tmp.add(cut);
                backTrack(result, tmp, rest.substring(i + 1));
            }
        }
    }

}
