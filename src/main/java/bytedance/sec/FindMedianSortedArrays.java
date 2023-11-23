package bytedance.sec;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/23 10:28
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length + nums2.length];
        int idx1 = 0;
        int idx2 = 0;
        int mergeIndex = 0;
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
                mergeIndex++;
                idx1++;
            } else {
                merge[mergeIndex] = nums2[idx2];
                mergeIndex++;
                idx2++;
            }
        }
        int length = merge.length;
        if (length % 2 == 1) {
            return merge[length / 2];
        } else {
            return ((double) (merge[length / 2] + merge[length / 2 - 1])) / 2;
        }
    }

}
