package org.example.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 */
public class FindAnagrams {

    public static void main(String[] args) {
        findAnagrams("cbaebabacd", "abc");
    }

    public static List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null) {
            return new ArrayList<Integer>();
        }
        if (p.length() > s.length()) {
            return new ArrayList<Integer>();
        }
        char[] targetArr = p.toCharArray();
        char[] sourceArr = s.toCharArray();
        int[] cmpP = new int[26];
        for (int i = 0; i < targetArr.length; i++) {
            cmpP[targetArr[i] - 'a']++;
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            int[] cmpS = new int[26];
            for (int j = i; j < i + p.length(); j++) {
                cmpS[sourceArr[j] - 'a']++;
            }
            if (Arrays.equals(cmpS, cmpP)) {
                result.add(i);
            }
        }
        return result;
    }

}
