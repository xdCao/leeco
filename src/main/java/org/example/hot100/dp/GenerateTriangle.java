package org.example.hot100.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * @author buku.ch
 * @Desc
 * @date 2023/11/15 16:13
 */
public class GenerateTriangle {

    public static void main(String[] args) {
        GenerateTriangle generateTriangle = new GenerateTriangle();
        generateTriangle.generate(5);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                List<Integer> level = new ArrayList<>();
                level.add(1);
                res.add(level);
                continue;
            }
            List<Integer> level = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    level.add(0, res.get(i - 1).get(0));
                    continue;
                }
                if (j == i) {
                    level.add(j, res.get(i - 1).get(j - 1));
                    continue;
                }
                level.add(j, res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            res.add(level);
        }
        return res;
    }

}
