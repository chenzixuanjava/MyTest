package com.segi.shang.interview.JMM;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author chenzx
 * @date 2020-03-02 上午 11:35
 */
public class ContainerNotSafeTest {

    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<String, String>();
//        Map<String, String> map = new Hashtable<>();
//        Map<String, String> map = Collections.synchronizedMap(new Hashtable<>());
        Map<String, String> map = new ConcurrentHashMap<>();

        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }


    }

    private static void setNotSafe() {
        //        Set<String> sets = new HashSet<>();
//        Set<String> sets = Collections.synchronizedSet(new HashSet<>());
        Set<String> sets = new CopyOnWriteArraySet<>();

        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                sets.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(sets);
            }).start();
        }
    }

    private static void listNotSave() {
        //        List<String> list = new Vector<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }).start();
        }
    }
}
