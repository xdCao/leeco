package bytedance;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/18 19:28
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length + nums2.length];
        int mIndex = 0;
        int nIndex = 0;
        int mergeIndex = 0;
        while (true) {
            if (mIndex >= nums1.length && nIndex >= nums2.length) {
                break;
            }
            if (mIndex >= nums1.length) {
                merge[mergeIndex] = nums2[nIndex];
                nIndex++;
                mergeIndex++;
                continue;
            }
            if (nIndex >= nums2.length) {
                merge[mergeIndex] = nums1[mIndex];
                mIndex++;
                mergeIndex++;
                continue;
            }
            if (nums1[mIndex] < nums2[nIndex]) {
                merge[mergeIndex] = nums1[mIndex];
                mIndex++;
                mergeIndex++;
                continue;
            }
            merge[mergeIndex] = nums2[nIndex];
            nIndex++;
            mergeIndex++;
        }
        if (merge.length % 2 == 0) {
            return ((double)merge[merge.length / 2] + (double)merge[(merge.length - 1) / 2]) / 2;
        }
        return merge[merge.length / 2];
    }

}
