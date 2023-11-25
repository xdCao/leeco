package bytedance.thd;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/25 11:16
 */
public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mergeIndex = nums1.length - 1;
        int idx1 = m - 1;
        int idx2 = n - 1;
        while (idx1 >= 0 || idx2 >= 0) {
            if (idx1 < 0) {
                nums1[mergeIndex] = nums2[idx2];
                idx2--;
                mergeIndex--;
                continue;
            }
            if (idx2 < 0) {
                nums1[mergeIndex] = nums1[idx1];
                idx1--;
                mergeIndex--;
                continue;
            }
            if (nums1[idx1] > nums2[idx2]) {
                nums1[mergeIndex] = nums1[idx1];
                idx1--;
                mergeIndex--;
            } else {
                nums1[mergeIndex] = nums2[idx2];
                idx2--;
                mergeIndex--;
            }
        }

    }

}
