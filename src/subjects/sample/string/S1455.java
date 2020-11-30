package subjects.sample.string;

/**
 * @description: 检查单词是否为句中其他单词的前缀
 * https://leetcode-cn.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
 * @author: dsy
 * @date: 2020/11/30 11:28
 */
public class S1455 {
    public static int isPrefixOfWord(String sentence, String searchWord) {
        if (sentence == null || searchWord == null) {
            return -1;
        }
        String[] strings = sentence.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() >= searchWord.length()) {
                if (strings[i].substring(0, searchWord.length()).equals(searchWord)) {
                    return i + 1;
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        System.out.println(isPrefixOfWord("hello from the other side", "they"));
    }
}
