package bytedance.sec;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/21 14:56
 */
public class PartArr {

    public static void main(String[] args) {

        //5,4,2,2,1,4,6  4
        // 3, 2, 4, 3, 6  3
        // 3,2,4,3,6,1,5,4,2,5,6,1  7
        int part = part(new int[]{3,2,4,3,6,1,5,4,2,5,6,1});
        System.out.println(part);
    }

    public static int part(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        for (int i = arr.length; i > 1; i--) {
            if (sum % i != 0) {
                continue;
            }
            List<Integer> res = new ArrayList<>();
            backTrack(res, sum / i, arr);
            if (res.size() == i) {
                return i;
            }
        }
        return 1;
    }

    private static void backTrack(List<Integer> res, int target, int[] arr) {
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            doBackTrack(res, target, i, arr, 0, used);
        }
    }

    private static boolean doBackTrack(List<Integer> res, int target, int i, int[] arr, int sum, Set<Integer> used) {
        if (sum == target) {
            res.add(sum);
            return true;
        }
        if (i > arr.length - 1) {
            return false;
        }
        for (int j = i; j < arr.length; j++) {
            if (used.contains(j)) {
                continue;
            }
            sum += arr[j];
            used.add(j);
            boolean suc = doBackTrack(res, target, j + 1, arr, sum, used);
            sum -= arr[j];
            if (!suc) {
                used.remove(j);
            }
        }
        return false;
    }

}
