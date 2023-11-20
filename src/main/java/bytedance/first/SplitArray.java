package bytedance.first;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * 3, 2, 4, 3, 6
 * @author buku.ch
 * @Desc
 * @date 2023/11/17 20:54
 */
public class SplitArray {

    public static void main(String[] args) {
        //5,4,2,2,1,4,6  4
        // 3, 2, 4, 3, 6  3
        // 3,2,4,3,6,1,5,4,2,5,6,1  7
        int i = splitArray(new int[]{3,2,4,3,6,1,5,4,2,5,6,1});
        System.out.println(i);
    }

    public static int splitArray(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        for (int i = sum; i >= 1; i--) {
            if (sum % i != 0) {
                continue;
            }
            // 看是否能分成i份
            boolean canSplit = canSplit(arr, i, sum);
            if (canSplit) {
                return i;
            }
        }
        return 1;
    }

    private static boolean canSplit(int[] arr, int partNum, int sum) {
        int eachSum = sum / partNum;

        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i1 = 0; i1 < arr.length; i1++) {
            if (visited.contains(i1)) {
                continue;
            }
            List<Integer> single = new ArrayList<>();
            single.add(arr[i1]);
            visited.add(i1);
            int curSum = arr[i1];
            boolean backTrack = backTrack(res, single, i1 + 1, curSum, eachSum, arr, visited);
            if (!backTrack) {
                visited.remove(i1);
            }
        }
        if (res.size() != partNum) {
            return false;
        }
        return true;
    }

    private static boolean backTrack(List<List<Integer>> res, List<Integer> single, int i, int curSum, int eachSum, int[] arr, Set<Integer> visited) {
        if (curSum > eachSum) {
            return false;
        }
        if (curSum == eachSum) {
            res.add(single);
            return true;
        }
        if (i > arr.length - 1) {
            return false;
        }
        for (int i1 = i; i1 < arr.length; i1++) {
            if (visited.contains(i1)) {
                continue;
            }
            List<Integer> tmp = new ArrayList<>(single);
            tmp.add(arr[i1]);
            curSum += arr[i1];
            visited.add(i1);
            boolean backTrack = backTrack(res, tmp, i1 + 1, curSum, eachSum, arr, visited);
            curSum -= arr[i1];
            if (!backTrack) {
                visited.remove(i1);
            }
        }
        return false;
    }

}
