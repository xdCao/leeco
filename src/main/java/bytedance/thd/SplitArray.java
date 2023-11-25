package bytedance.thd;

import java.util.*;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/25 11:53
 */
public class SplitArray {

    public static void main(String[] args) {
        //5,4,2,2,1,4,6  4
        // 3, 2, 4, 3, 6  3
        // 3,2,4,3,6,1,5,4,2,5,6,1  7
        SplitArray splitArray = new SplitArray();
        int part = splitArray.splitArray(new int[]{5, 4, 2, 2, 1, 4, 6});
        System.out.println(part);

        part = splitArray.splitArray(new int[]{3, 2, 4, 3, 6});
        System.out.println(part);

        part = splitArray.splitArray(new int[]{3, 2, 4, 3, 6, 1, 5, 4, 2, 5, 6, 1});
        System.out.println(part);
    }

    public int splitArray(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        Arrays.sort(arr);
        for (int i = arr.length; i >= 1; i--) {
            if (sum % i != 0) {
                continue;
            }
            boolean check = check(arr, i, sum / i);
            if (check) {
                return i;
            }
        }
        return 1;
    }

    private boolean check(int[] arr, int cnt, int eachSum) {
        List<List<Integer>> res = new ArrayList<>();

        Set<Integer> visited = new HashSet<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (visited.contains(i)) {
                continue;
            }
            List<Integer> single = new ArrayList<>();
            single.add(arr[i]);
            visited.add(i);
            if (!backTrack(arr, eachSum, res, single, visited)) {
                visited.remove(i);
            }
        }
        return res.size() == cnt;
    }

    private boolean backTrack(int[] arr, int eachSum, List<List<Integer>> res, List<Integer> single, Set<Integer> visited) {
        if (getSum(single) == eachSum) {
            res.add(single);
            return true;
        }
        boolean ret = false;
        for (int i = 0; i < arr.length; i++) {
            if (visited.contains(i)) {
                continue;
            }
            single.add(arr[i]);
            visited.add(i);
            if (!backTrack(arr, eachSum, res, single, visited)) {
                visited.remove(i);
                single.remove(single.size() - 1);
            } else {
                ret = true;
            }
        }
        return ret;
    }

    private int getSum(List<Integer> single) {
        int sum = 0;
        for (Integer integer : single) {
            sum += integer;
        }
        return sum;
    }

}
