package bytedance.codetop;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/2 18:38
 */
public class CompareVersion {

    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        for (int i = 0; i < Math.max(arr1.length, arr2.length); i++) {
            String v1 = i >= arr1.length ? "0" : arr1[i];
            String v2 = i >= arr2.length ? "0" : arr2[i];
            int compare = compare(removeZero(v1), removeZero(v2));
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    private int compare(String s1, String s2) {

        if (s1.equals(s2)) {
            return 0;
        }
        return Integer.parseInt(s1) - Integer.parseInt(s2) > 0 ? 1 : -1;
    }

    private String removeZero(String v1) {
        for (int i = 0; i < v1.length(); i++) {
            if (v1.charAt(i) != '0') {
                return v1.substring(i);
            }
        }
        return "0";
    }

}
