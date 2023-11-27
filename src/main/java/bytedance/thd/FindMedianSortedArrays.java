package bytedance.thd;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/27 11:11
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length + nums2.length];
        int mergeIndex = 0;
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < nums1.length || idx2 < nums2.length) {
            if (idx1 >= nums1.length) {
                merge[mergeIndex] = nums2[idx2];
                mergeIndex++;
                idx2++;
                continue;
            }
            if (idx2 >= nums2.length) {
                merge[mergeIndex] = nums1[idx1];
                mergeIndex++;
                idx1++;
                continue;
            }

            if (nums1[idx1] < nums2[idx2]) {
                merge[mergeIndex] = nums1[idx1];
                idx1++;
                mergeIndex++;
            } else {
                merge[mergeIndex] = nums2[idx2];
                idx2++;
                mergeIndex++;
            }
        }

        if (merge.length % 2 == 1) {
            return merge[merge.length / 2];
        }
        return ((double) (merge[merge.length / 2] + merge[merge.length / 2 - 1])) / 2;
    }

}
