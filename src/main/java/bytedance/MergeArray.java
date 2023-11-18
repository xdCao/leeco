package bytedance;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/17 17:04
 */
public class MergeArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mIndex = m - 1;
        int nIndex = n - 1;
        int mergeIndex = m + n - 1;
        while (mergeIndex >= 0) {
            if (nIndex < 0) {
                nums1[mergeIndex] = nums1[mIndex];
                mergeIndex--;
                mIndex--;
                continue;
            }
            if (mIndex < 0) {
                nums1[mergeIndex] = nums2[nIndex];
                mergeIndex--;
                nIndex--;
                continue;
            }
            if (nums1[mIndex] >= nums2[nIndex]) {
                nums1[mergeIndex] = nums1[mIndex];
                mIndex--;
                mergeIndex--;
            } else {
                nums1[mergeIndex] = nums2[nIndex];
                nIndex--;
                mergeIndex--;
            }
        }
    }

}
