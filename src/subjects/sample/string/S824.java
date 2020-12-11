package subjects.sample.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description: 山羊拉丁文
 * https://leetcode-cn.com/problems/goat-latin/
 * @author: dsy
 * @date: 2020/12/11 10:40
 */
public class S824 {
    public static String toGoatLatin(String S) {
        List<Character> characters = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        if (S == null || S.length() == 0) {
            return "";
        }
        String[] strings = S.split(" ");
        StringBuilder sb;
        for (int i = 0; i < strings.length; i++) {
            sb = new StringBuilder();
            if (characters.contains(strings[i].charAt(0))) {
                sb.append(strings[i]).append("ma");
            } else {
                sb.append(strings[i].substring(1)).append(strings[i].substring(0, 1)).append("ma");
            }

            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }
            strings[i] = sb.toString();
        }

        return String.join(" ", strings);
    }


    private static Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u',
            'A', 'E', 'I', 'O', 'U'));

    public String toGoatLatin1(String S) {
        int lens = S.length();
        char[] sArr = S.toCharArray();
        int startIndex = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        StringBuilder word = new StringBuilder();
        int wordStart = 0;
        boolean isOwel = false;
        while (startIndex < lens) {
            char curChar = sArr[startIndex];
            if (wordStart == 0) {
                if (set.contains(curChar)) {
                    isOwel = true;
                } else {
                    isOwel = false;
                }
            }
            if (curChar == ' ') {
                appendWord(stringBuilder, count, word, isOwel);
                wordStart = 0;
                count++;
                word.setLength(0);
            } else {
                word.append(curChar);
                wordStart++;
            }
            startIndex++;
        }
        appendWord(stringBuilder, count, word, isOwel);
        return stringBuilder.toString().trim();
    }

    private void appendWord(StringBuilder stringBuilder, int count, StringBuilder word, boolean isOwel) {
        if (!isOwel) {
            String start = word.substring(0, 1);
            String subWord = word.substring(1);
            word = new StringBuilder(subWord);
            word.append(start).append("ma");
        } else {
            word.append("ma");
        }
        appendA(word, count);
        stringBuilder.append(word).append(" ");
    }

    public void appendA(StringBuilder word, int num) {
        for (int i = 0; i < num; i++) {
            word.append("a");
        }
    }


    public static void main(String[] args) {
        System.out.println(toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }
}
