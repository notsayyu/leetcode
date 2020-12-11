package subjects.sample.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description: 数组中的字符串匹配
 * https://leetcode-cn.com/problems/string-matching-in-an-array/
 * @author: dsy
 * @date: 2020/12/10 18:21
 */
public class S1408 {
    public static List<String> stringMatching(String[] words) {
        Set<String> results = new HashSet<>();
        if (words == null || words.length == 0) {
            return new ArrayList<>(results);
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].contains(words[j])) {
                    results.add(words[j]);
                }
                if (words[j].contains(words[i])) {
                    results.add(words[i]);
                }

            }
        }

        return new ArrayList<>(results);
    }

    public static void main(String[] args) {
        String[] words = {"blue", "green", "bu"};

        System.out.println(stringMatching(words));


    }
}
