package bytedance.first;

import org.apache.commons.lang3.StringUtils;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/19 00:01
 */
public class CompareVersion {

    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < split1.length || idx2 < split2.length) {
            String tmp1 = idx1 > split1.length - 1 ? "0" : split1[idx1];
            String tmp2 = idx2 > split2.length - 1 ? "0" : split2[idx2];
            tmp1 = removePreZero(tmp1);
            tmp2 = removePreZero(tmp2);
            if (tmp2.equals(tmp1)) {
                idx1++;
                idx2++;
                continue;
            }
            if (Integer.parseInt(tmp1) > Integer.parseInt(tmp2)) {
                return 1;
            }
            return -1;
        }
        return 0;

    }

    private static String removePreZero(String tmp1) {
        StringBuilder sb = new StringBuilder();
        boolean meetNoZero = false;
        for (char c : tmp1.toCharArray()) {
            if (c == '0' && !meetNoZero) {
                continue;
            }
            if (c != '0') {
                meetNoZero = true;
            }
            sb.append(c);
        }
        if (!meetNoZero) {
            sb.append("0");
        }
        return sb.toString();
    }

}
