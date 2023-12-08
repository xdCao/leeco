package bytedance.first;

import java.util.ArrayList;
import java.util.List;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/7 13:58
 */
public class RestoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            List<String> single = new ArrayList<>();
            String part = s.substring(0, i + 1);
            if (!isValid(part)) {
                continue;
            }
            String left = s.substring(i + 1);
            single.add(part);
            backTrack(result, single, left);
        }
        return result;
    }

    private void backTrack(List<String> result, List<String> single, String input) {
        if (single.size() == 3) {
            if (isValid(input)) {
                StringBuilder sb = new StringBuilder();
                for (String s : single) {
                    sb.append(s);
                    sb.append(".");
                }
                sb.append(input);
                result.add(sb.toString());
            }
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            List<String> tmp = new ArrayList<>(single);
            String part = input.substring(0, i + 1);
            if (!isValid(part)) {
                continue;
            }
            String left = input.substring(i + 1);
            tmp.add(part);
            backTrack(result, tmp, left);
        }
    }

    private boolean isValid(String part) {
        if (part == null || part.isEmpty() || part.length() > 3) {
            return false;
        }
        if (part.length() != 1 && part.charAt(0) == '0') {
            return false;
        }
        return Long.parseLong(part) <= 255L && Long.parseLong(part) >= 0;
    }


}
