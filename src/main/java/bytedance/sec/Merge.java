package bytedance.sec;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/20 16:25
 */
public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mergeIdx = nums1.length - 1;
        int idx1 = m - 1;
        int idx2= n - 1;
        while (mergeIdx >= 0) {
            if (idx1 < 0) {
                nums1[mergeIdx] = nums2[idx2];
                mergeIdx--;
                idx2--;
                continue;
            }
            if (idx2 < 0) {
                nums1[mergeIdx] = nums1[idx1];
                idx1--;
                mergeIdx--;
                continue;
            }
            if (nums1[idx1] > nums2[idx2]) {
                nums1[mergeIdx] = nums1[idx1];
                idx1--;
                mergeIdx--;
                continue;
            }
            nums1[mergeIdx] = nums2[idx2];
            idx2--;
            mergeIdx--;
        }

    }

}
