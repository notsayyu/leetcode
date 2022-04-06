package datastructure.jianzhioffer;

/**
 * @description:
 * @author: dsy
 * @date: 2022/2/2 09:04
 */
public class JZ20 {
    public boolean isNumeric(String str) {
        // write code here
        if (str == null || str.length() == 0) {
            return false;
        }
        //去掉首位空格
        str = str.trim();
        boolean numFlag = false;
        boolean dotFlag = false;
        boolean eFlag = false;
        for (int i = 0; i < str.length(); i++) {
            //判定为数字，则标记numFlag
            if (Character.isDigit(str.charAt(i))) {
                numFlag = true;
                //判定为.  需要没出现过.并且没出现过e// 点在e前面
            } else if (str.charAt(i) == '.' && !dotFlag && !eFlag) {
                dotFlag = true;
                //判定为e，需要没出现过e，并且出过数字了
            } else if ((str.charAt(i) == 'e' || str.charAt(i) == 'E') && !eFlag && numFlag) {
                eFlag = true;
                //为了避免123e这种请求，出现e之后就标志为false
                numFlag = false;
                //判定为+-符号，只能出现在第一位或者紧接e后面
            } else if ((str.charAt(i) == '+' || str.charAt(i) == '-') && (i == 0 || str.charAt(i - 1) == 'e' || str.charAt(i - 1) == 'E')) {
                //其他情况，都是非法的
            } else {
                return false;
            }
        }
        return numFlag;
    }
}