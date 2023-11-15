package org.example.hot100.erfen;

/**
 * 4. 寻找两个正序数组的中位数
 * @author buku.ch
 * @Desc
 * @date 2023/11/15 15:53
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = new int[nums2.length + nums1.length];
        int mergeIndex = 0;
        int i = 0;
        int j = 0;
        while (i <= nums1.length && j <= nums2.length) {
            if (i == nums1.length && j == nums2.length) {
                break;
            }
            if (i == nums1.length && j < nums2.length) {
                merge[mergeIndex] = nums2[j];
                j++;
                mergeIndex++;
                continue;
            }
            if (j == nums2.length && i < nums1.length) {
                merge[mergeIndex] = nums1[i];
                i++;
                mergeIndex++;
                continue;
            }
            int num1 = nums1[i];
            int num2 = nums2[j];
            if (num1 < num2) {
                merge[mergeIndex] = num1;
                i++;
                mergeIndex++;
                continue;
            }
            merge[mergeIndex] = num2;
            j++;
            mergeIndex++;
        }
        if (mergeIndex % 2 == 0) {
            return ((double) (merge[mergeIndex / 2] + merge[mergeIndex / 2 - 1])) / 2;
        } else {
            return merge[mergeIndex / 2];
        }

    }

}
