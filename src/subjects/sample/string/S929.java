package subjects.sample.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 独特的电子邮件地址
 * https://leetcode-cn.com/problems/unique-email-addresses/
 * @author: dsy
 * @date: 2020/11/27 17:00
 */
public class S929 {
    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        int index;
        for (String s : emails) {
            index = s.indexOf('+');
            String text;
            if (index > 0) {
                text = s.substring(0, index).replaceAll("\\.", "");
            } else {
                text = s.substring(0, s.indexOf('@')).replaceAll("\\.", "");
            }
            set.add(text + s.substring(s.indexOf('@')));
        }

        return set.size();
    }

    public static void main(String[] args) {
//        System.out.println("fghj.1".replaceAll("\\.", ""));
        String[] emails = {
                "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }
}
