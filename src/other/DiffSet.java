package other;

import java.util.*;

/**
 * @author by dsy
 * @Classname DiffSet
 * @Description TODO
 * @Date 2022/10/18 16:59
 */
public class DiffSet {
    public static void main(String[] args) {
        System.out.println(deDuplcate(Arrays.asList(1, 2, 3, 3), Arrays.asList(4, 2, 2, 3)));
    }

    // a = 1 2 3
    // b = 2 3 4
    // 1,4
    public static List<Integer> deDuplcate(List<Integer> a, List<Integer> b) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            }
        }
        for (int i : b) {
            if (map.containsKey(i) && (map.get(i) == 1 || map.get(i) == 2)) {
                map.put(i, 2);
            } else {
                map.put(i, 3);
            }
        }
        ArrayList<Integer> ret = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (2 != entry.getValue()) {
                ret.add(entry.getKey());
            }
        }

        return ret;
    }
}
