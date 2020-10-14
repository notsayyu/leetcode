package subjects.sample;

/**
 * @description: 字符串匹配算法--Sunday算法
 * @author: dsy
 * @date: 2020/4/8 18:39
 */
public class Sunday {

    /**
     * 判断子串中是否存在末尾下一个位置对应的父串的字符
     * 每次从后往前匹配，为了不遗漏可能的匹配，应该是跳到使得子串中最右一个字符与父串中的该字符对应，
     * 这样跳过的距离最小，且是安全的。
     */
    public static int contains(char[] sonArray, char ch) {
        for (int i = sonArray.length - 1; i >= 0; i--) {
            if (sonArray[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    public static int search(String father, String son) {
        //这里转为char数组要更方便些
        char[] fatherArray = father.toCharArray();
        char[] sonArray = son.toCharArray();

        int fatherLength = fatherArray.length;
        int sonLength = sonArray.length;
        int i = 0, j = 0;
        //+ j是可能会出现最后一次移动father剩余长度与son长度不一致的情况
        while (i <= fatherLength - sonLength + j) {
            if (fatherArray[i] != sonArray[j]) {
                //如果父串与子串当前字符不相等
                if (i == fatherLength - sonLength + j) {
                    //这里说明子串已经是在和父串中最后可能想等的字符比较过了，并且后面也没有可比较的了，所以返回
                    return -1;
                }

                //如果父串的中间部分与子串匹配，且结果不相等
                //就从子串最后面开始，找出子串最后一位的下一位对应父串的字符在子串中是否存在
                int pos = contains(sonArray, fatherArray[i - j + sonLength]);
                if (pos == -1) {
                    //不存在则直接跳到再下一位，子串从头开始
                    i = i - j + sonLength + 1;
                    j = 0;
                } else {
                    //存在则将这个字符与子串最右边与它相同的字符对其,并再次从头开始比较
                    i = i + sonLength - pos - j;
                    j = 0;
                }

            } else {
                //如果父串与子串当前字符相等
                if (j == sonLength - 1) {
                    //如果比较到了子串的最后一位，说明已经存在
                    return i - j;
                } else {
                    //不是子串最后一位，则进行下一个字符的对比
                    i++;
                    j++;
                }

            }


        }

        return -1;
    }

    public static void main(String[] args) {
        String father = "ABABEABABABABCBA";
        String son = "ABABC";
        System.out.println(search(father, son));
    }
}
