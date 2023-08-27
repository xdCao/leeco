package org.example.hot100;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 */
public class MinContainSubString {

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        char[] sourceArr = s.toCharArray();
        char[] targetArr = t.toCharArray();
        Map<Character, Integer> sourceCharMap = new HashMap<Character, Integer>();
        Map<Character, Integer> targetCharMap = new HashMap<Character, Integer>();
        for (int i = 0; i < targetArr.length; i++) {
            if (targetCharMap.containsKey(targetArr[i])) {
                targetCharMap.put(targetArr[i], targetCharMap.get(targetArr[i]) + 1);
            } else {
                targetCharMap.put(targetArr[i], 1);
            }
        }

        int beginIndex = 0;
        int endIndex = 0;
        int minBegin = 0;
        int minLen = s.length() + 1;
        while (endIndex < sourceArr.length) {
            if (sourceCharMap.containsKey(sourceArr[endIndex])) {
                sourceCharMap.put(sourceArr[endIndex], sourceCharMap.get(sourceArr[endIndex]) + 1);
            } else {
                sourceCharMap.put(sourceArr[endIndex], 1);
            }
            // 比较两个子串
            boolean cover = isCover(sourceCharMap, targetCharMap);
            if (cover) {
                int curLen = endIndex - beginIndex + 1;
                if (curLen < minLen) {
                    minLen = curLen;
                    minBegin = beginIndex;
                }
                while (beginIndex <= endIndex) {
                    sourceCharMap.put(sourceArr[beginIndex], sourceCharMap.get(sourceArr[beginIndex]) - 1);
                    boolean isCover = isCover(sourceCharMap, targetCharMap);
                    if (isCover) {
                        int newLen = endIndex - beginIndex;
                        if (newLen < minLen) {
                            minLen = newLen;
                            minBegin = beginIndex + 1;
                        }
                        beginIndex++;
                    } else {
                        beginIndex++;
                        break;
                    }
                }
            }
            endIndex++;
        }
        if (minLen == s.length() + 1) {
            return "";
        }
        return s.substring(minBegin, minBegin + minLen);
    }

    private static boolean isCover(Map<Character, Integer> sourceCharMap, Map<Character, Integer> targetCharMap) {
        for (Character character : targetCharMap.keySet()) {
            if (sourceCharMap.containsKey(character) && sourceCharMap.get(character) >= targetCharMap.get(character)) {
                continue;
            }
            return false;
        }
        return true;
    }

}
