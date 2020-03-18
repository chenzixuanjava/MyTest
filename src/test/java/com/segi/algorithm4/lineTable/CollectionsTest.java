package com.segi.algorithm4.lineTable;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenzx
 * @date 2018-10-21 下午 10:10
 */
public class CollectionsTest {

    /**
     * 去偶的三种实现
     */
    @Test
    public void removeEvenVar1Test() {
        List<Integer> arrayList = Lists.newArrayList(1, 3, 5, 6, 3);
        LinkedList<Integer> linkedList = Lists.newLinkedList(arrayList);
        removeEvenVar1(arrayList);
        removeEvenVar1(linkedList);
        System.out.println(arrayList);
        System.out.println(linkedList);

    }

    public void removeEvenVar1(List<Integer> coll) {
        int i = 0;
        while (i < coll.size()) {
            if (coll.get(i) % 2 == 0) {
                coll.remove(i);
            } else {
                i++;
            }
        }
    }

    @Test
    public void removeEvenVar2Test() {
        List<Integer> arrayList = Lists.newArrayList(1, 3, 5, 6, 3);
        LinkedList<Integer> linkedList = Lists.newLinkedList(arrayList);
        removeEvenVar2(arrayList);
        removeEvenVar1(linkedList);
        System.out.println(arrayList);
        System.out.println(linkedList);

    }

    public void removeEvenVar2(List<Integer> coll) {
        for (Integer e : coll) {
            if (e % 2 == 0) {
                coll.remove(e);
            }
        }
    }

    @Test
    public void removeEvenVar3Test() {
        List<Integer> arrayList = Lists.newArrayList(1, 3, 5, 6, 3);
        LinkedList<Integer> linkedList = Lists.newLinkedList(arrayList);
        removeEvenVar3(arrayList);
        removeEvenVar3(linkedList);
        System.out.println(arrayList);
        System.out.println(linkedList);

    }

    public void removeEvenVar3(List<Integer> coll) {
        Iterator<Integer> iterator = coll.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next % 2 == 0) {
                iterator.remove();
            }
        }
    }

    @Test
    public void test() {
        Integer[] a = {1, 3};
        //不能这样强转
        a = (Integer[]) new Object[5];
        System.out.println(a);
    }
}