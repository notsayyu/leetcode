package subjects.sample;

/**
 * @description: 根据大话数据结构正常思路解
 * @author: dsy
 * @date: 2020/4/2 14:37
 */
public class KMP2 {

    private static int[] getNext(String son) {
        //因为是自己跟自己比较，所以起始状态j 比 i小1。只是-1不存在，所以下方next[0]设置成了-1
        //配合判断条件j == -1，造成的结果就是i和j一起进一位。如果之前的步骤两个字符相同，那就是都进一位继续比较。
        // 如果不同，j置为-1然后自增变成0，i进一位，就开始了多一位字符的运算。
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
        return next;
    }

    /**
     * KMP算法
     */
    private static int match(String father, String son) {
        //通过子串计算next数组
        int[] next = getNext(son);
        int i = 0, j = 0;
        //一直循环到i等于father长度，或者j等于son长度
        while (i <= father.length() - 1 && j <= son.length() - 1) {
            //-1表示son需要从头匹配，||后面的语句表示字符相等，后移一位
            if (j == -1 || father.charAt(i) == son.charAt(j)) {
                i++;
                j++;
            } else {
                //字符不匹配，i不变，j回退到next[j]进行比较，或者说son右移j - next[j]位
                j = next[j];
            }
            if (j > son.length() - 1) {
                //匹配成功
                return i - son.length();
            }
        }
        return -1;
    }

    /**
     * 暴力算法
     */
    private static int violentMatch(String father, String son) {
        int fatherLength = father.length();
        int sonLength = son.length();
        //i记录在father中的位置
        int i = 0;
        //i记录在son中的位置
        int j = 0;
        while (i < fatherLength && j < sonLength) {
            if (father.charAt(i) == son.charAt(j)) {
                //如果父子当前的字符匹配成功，则同时前进以为，匹配下一个
                i++;
                j++;
            } else {
                //匹配不成功，则回退前进的长度
                //因为j每次都是从son的第一位开始，也就是0，所以i-j就是回到这一轮开始的位置，再+1则表示下一个字符（当前轮开始的字符匹配不成功）
                i = i - j + 1;
                j = 0;
            }
        }
        //如果跳出循环之后，j等于子串的长度（循环进行的条件之一是j < sonLength,匹配成功后j++ 就等于sonLength了）
        if (j == sonLength) {
            //此时i所在位置是son在father中的最后一个字符的后一位，所以起始位置要减去j，就是son在father中的第一位
            return i - j;
        }
        //没有匹配成功就返回-1
        return -1;
    }

    public static void main(String[] args) {
        String pat = "abcdabcdcab";
        int[] next = getNext(pat);
        for (int i : next) {
            System.out.println(i);
        }
//        String txt = "BADBCDABABCAB";
//        System.out.println(violentMatch(txt, pat));
//        System.out.println(getNext(pat));
//        System.out.println(match(txt, pat));
    }

}
