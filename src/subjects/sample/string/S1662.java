package subjects.sample.string;

/**
 * @description: 检查两个字符串数组是否相等
 * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 * <p>
 * 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
 * 输出：true
 * 解释：
 * word1 表示的字符串为 "ab" + "c" -> "abc"
 * word2 表示的字符串为 "a" + "bc" -> "abc"
 * 两个字符串相同，返回 true
 * 示例 2：
 * <p>
 * 输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= word1.length, word2.length <= 103
 * 1 <= word1[i].length, word2[i].length <= 103
 * 1 <= sum(word1[i].length), sum(word2[i].length) <= 103
 * word1[i] 和 word2[i] 由小写字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-two-string-arrays-are-equivalent
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: dsy
 * @date: 2020/11/26 14:50
 */
public class S1662 {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        for (String s1 : word1) {
            sb1.append(s1);
        }
        StringBuilder sb2 = new StringBuilder();
        for (String s2 : word2) {
            sb2.append(s2);
        }
        return sb1.toString().equals(sb2.toString());
    }

    public static boolean arrayStringsAreEqual1(String[] word1, String[] word2) {
        return String.join("", word1).toString().equals(String.join("", word2));
    }

    public static void main(String[] args) {
        String[] word1 = {"abc", "d", "defg"};
        String[] word2 = {"abcddefg"};
        System.out.println(arrayStringsAreEqual(word1, word2));
    }
}
