package org.example.hot100.backTrack;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/16 14:54
 */
public class LetterCombinations {

    private static Map<Character, List<String>> map = new HashMap<>();
    static {
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> strings = letterCombinations.letterCombinations("234");
        System.out.println(strings);
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        char[] charArray = digits.toCharArray();
        if (digits.length() == 1) {
            return map.get(charArray[0]);
        }
        List<String> stringList = map.get(charArray[0]);
        for (String s : stringList) {
            StringBuilder sb = new StringBuilder();
            sb.append(s);
            backTrack(sb, 0, res, charArray);
        }
        return res;
    }

    private void backTrack(StringBuilder sb, int i, List<String> res, char[] charArray) {
        if (i >= charArray.length - 1) {
            res.add(sb.toString());
            return;
        }
        int j = i + 1;
        List<String> strings = map.get(charArray[j]);
        for (String string : strings) {
            StringBuilder tmp = new StringBuilder();
            tmp.append(sb);
            tmp.append(string);
            backTrack(tmp, j, res, charArray);
        }

    }


}
