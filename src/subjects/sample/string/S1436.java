package subjects.sample.string;

import java.util.HashMap;
import java.util.List;

/**
 * @description: 旅行终点站
 * https://leetcode-cn.com/problems/destination-city/
 * @author: dsy
 * @date: 2020/11/26 16:43
 */
public class S1436 {
    public static String destCity(List<List<String>> paths) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (List<String> path : paths) {
            hashMap.put(path.get(0), path.get(1));
        }
        String key = paths.get(0).get(0);
        while (hashMap.containsKey(key)) {
            key = hashMap.get(key);
        }
        return key;
    }


    public static void main(String[] args) {
    }
}
