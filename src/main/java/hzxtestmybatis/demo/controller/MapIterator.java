package hzxtestmybatis.demo.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author:HeZhengXing
 * @Descripton:
 * @Date: Created in 16:50 2018/7/10
 * @Modify By:
 */
public class MapIterator {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");
        map.put(5, "d");
        map.put(3,"a");
        System.out.println(map.size());
        for (Integer in:map.keySet()){
            String str = map.get(in);
            System.out.println(in + ":" +str);
        }
        Iterator<Map.Entry<Integer, String>> iterable = map.entrySet().iterator();
        while (iterable.hasNext()) {
            Map.Entry<Integer,String> map1 = iterable.next();
            System.out.println(map1);
//            System.out.println(map1.getKey() + " : " + map1.getValue());
        }
        for (Map.Entry<Integer,String> entry:map.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        for (String s: map.values()) {
            System.out.println(s);
        }
        Character a = new Character('1');
        System.out.println(1%3);
    }
}
