package com.segi.shang.interview.JVM;
import	java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author chenzx
 * @date 2020-03-09 下午 2:10
 */
public class WeakHashMapTest {

    public static void main(String[] args) {
//        hashMapTest();
        weakHashMapTest();
    }

    private static void weakHashMapTest() {
        Map<Integer, String> map = new WeakHashMap<>();
        Integer key = new Integer(1);
        String value = "WeakHashMap";
        map.put(key, value);
        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map);
    }

    private static void hashMapTest() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        Integer key = new Integer(1);
        String value = "hashMap";
        map.put(key, value);
        key = null;
        System.out.println(map);

    }
}
