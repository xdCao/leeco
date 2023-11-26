package bytedance.thd;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/26 18:51
 */
public class CompareVersion {

    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        for (int i = 0; i < Math.max(arr1.length, arr2.length); i++) {
            String str1 = i >= arr1.length ? "0" : arr1[i];
            String str2 = i >= arr2.length ? "0" : arr2[i];
            int res = compare(removePreZero(str1), removePreZero(str2));
            if (res != 0) {
                return res;
            }
        }
        return 0;
    }

    private int compare(String s1, String s2) {
        int int1 = Integer.parseInt(s1);
        int int2 = Integer.parseInt(s2);
        if (int1 > int2) {
            return 1;
        } else if (int1 < int2) {
            return -1;
        }
        return 0;
    }

    private String removePreZero(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != '0') {
                return input.substring(i);
            }
        }
        return "0";
    }

}
