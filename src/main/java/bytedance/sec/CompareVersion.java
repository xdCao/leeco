package bytedance.sec;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/22 19:07
 */
public class CompareVersion {

    public static void main(String[] args) {
        CompareVersion compareVersion = new CompareVersion();
        System.out.println(compareVersion.compare("1.2.1", "1.2"));
        System.out.println(compareVersion.compare("1.2.2", "1.2.1"));
        System.out.println(compareVersion.compare("1.1.1", "1.2.1"));
        System.out.println(compareVersion.compare("2.1", "2.2.1.1"));
    }


    public int compare(String str1, String str2) {
        String[] arr1 = str1.split("\\.");
        String[] arr2 = str2.split("\\.");
        for (int i = 0; i < Math.max(arr1.length, arr2.length); i++) {
            String tmp1 = null;
            String tmp2 = null;
            if (i >= arr1.length) {
                tmp1 = "0";
            }
            if (i >= arr2.length) {
                tmp2 = "0";
            }
            if (tmp1 == null) {
                tmp1 = arr1[i];
            }
            if (tmp2 == null) {
                tmp2 = arr2[i];
            }
            int res = doCompare(tmp1, tmp2);
            if (res != 0) {
                return res;
            }
        }
        return 0;

    }

    private int doCompare(String tmp1, String tmp2) {
        return Integer.valueOf(removePreZero(tmp1)) - Integer.valueOf(removePreZero(tmp2));
    }

    private String removePreZero(String str) {
        int first = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                break;
            }
            first++;
        }
        if (first > str.length() - 1) {
            return "0";
        }
        return str.substring(first);
    }

}
