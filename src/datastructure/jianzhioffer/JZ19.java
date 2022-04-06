package datastructure.jianzhioffer;

/**
 * @description:
 * @author: dsy
 * @date: 2022/1/26 12:52
 */
public class JZ19 {

    public static boolean match(String str, String pattern) {
        // write code here
        //'*'表示它前面的字符可以出现任意次（包含0次）

        return match(str.toCharArray(), 0, pattern.toCharArray(), 0);
//        for (int i = 0, j = 0; i < str.length() && j < pattern.length(); i++, j++) {
//            //先判断当前字符是否相等或后者等于. 相等就一定符合，不相等再去判断下一位是否是*
//            if (str.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.') {
//                continue;
//            } else {
//                if (j >= pattern.length() - 1) {
//                    //最后一位不符合，
//                    return false;
//                } else {
//                    j++;
//                    //正则进入下一位，判断是否是*，如果是*就可以满足，且需要继续看str的后面几位
//                    if (pattern.charAt(j) == '*') {
//                        continue;
//                    } else {
//                        return false;
//                    }
//                }
//            }
//
//        }
//
//        return true;
    }

    private static boolean match(char[] s, int si, char[] p, int pi) {
        //如果正则串走完了，原字符串没有走完就false，走完了就true
        if (pi >= p.length) {
            return si >= s.length;
        }
        //如果下一个是*
        if (pi + 1 < p.length && p[pi + 1] == '*') {
            //如果满足当前两边字符相等，就匹配0、1、多次
            if (si < s.length && (s[si] == p[pi] || p[pi] == '.')) {
                return match(s, si + 1, p, pi) || match(s, si, p, pi + 2);
            }
            //不相等就匹配0次
            return match(s, si, p, pi + 2);
        }
        //没有*，就相等或者p等于.

        if (si < s.length && (s[si] == p[pi] || p[pi] == '.')) {
            return match(s, si + 1, p, pi + 1);
        }

        return false;
    }

    public static void main(String[] args) {
//        System.out.println(match("aaab", "a*a*a*c"));
        String son = "abcdabcdcab";
        int i = 0, j = -1;
        int[] next = new int[son.length()];
        next[0] = -1;
        while (i < son.length() - 1) {
            //以son = "ababd"为例
            //起始的时候j=-1,令i = 1， j = 0，所以next[1] = 0，而且不管是什么字符串，都会是0，
            // 因为next 数组考虑的是除当前字符外的最长相同前缀后缀。所以i = 1的时候，next数组考虑的只有son[0]这一个字符
            //而当i=1了，j=0，son[1]和son[0]不相等，则j就要回退，回退到next[j],此处原理与match时候的j = next[j]的原理很相似。
            if (j == -1 || son.charAt(i) == son.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                //son[i]和son[j]不相等，则j就要回退，回退到next[j],此处原理与match时候的j = next[j]的原理很相似。
                // 回退到j = 0时就相当于此时的字符与son[0]开始比较，不相等则j=next[0]=-1,紧接着就各自加1，开始多一位字符长度的比较
                j = next[j];
            }
        }
        //感兴趣的可以再用son="abcdabcdcab"等进行debug观察计算和回溯过程
        System.out.println(next);

    }
}