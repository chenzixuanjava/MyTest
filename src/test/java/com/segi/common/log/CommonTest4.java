package com.segi.common.log;

import com.google.common.collect.Lists;
import com.segi.common.clone.Person;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.text.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenzx
 * @date 2018-11-26 下午 4:28
 */
public class CommonTest4 {

    @Test
    public void testClone() throws CloneNotSupportedException {
        Person p1 = new Person("chenzixuan", 24);
        Person clone = (Person)p1.clone();
        System.out.println(p1 == clone);
        System.out.println(p1.getName() == p1.getName());
        System.out.println(p1.getAge() == clone.getAge());
    }

    @Test
    public void testOrEq() {
        boolean flag = true;
//        flag |= false;
        flag &= true;
        System.out.println(flag);
        int a = 2;
        a |= 1;
        System.out.println(a);
    }

    @Test
    public void testMessageFormat1() {
        int num = 7;
        String event = "tow man beet";
        System.out.println(MessageFormat.format("date:{0, date}, time:{0, time}, event:{1}, num:{2, number, integer}", new Date(), event, num));
    }

    @Test
    public void testMessageFormat2() {
        Object[] objs = {3, "MC's disk"};
        Object[] objs2 = {4, "MC's disk"};
        MessageFormat format = new MessageFormat("the diskName：{1} has {0} disks");
        System.out.println(format.format(objs));
        System.out.println(format.format(objs2));
    }

    @Test
    public void testMessageFormat3() {
        double[] limits = {0, 1, 2};
        String[] formats = {"zero", "one", "{0, number, integer}"};
        ChoiceFormat choiceFormat = new ChoiceFormat(limits, formats);
        final MessageFormat format = new MessageFormat("the diskName：{1} has {0} disks");
        format.setFormatByArgumentIndex(0, choiceFormat);
        Object[] objs = {2, "MC's disk"};
        System.out.println(format.format(objs));
    }

    @Test
    public void testMessageFormat4() {
        final MessageFormat format = new MessageFormat("the diskName：{1} has {0} disks");
        format.applyPattern("");
        Object[] objs = {2, "MC's disk"};
        System.out.println(format.format(objs));
    }

    @Test
    public void testMessageFormat5() {
        final MessageFormat format = new MessageFormat("{0, number, #.##}, {0, number, #.#}");
        Object[] objs = {3.1415};
        String result = format.format(objs);
        System.out.println(result);
        objs = null;
        final Object[] parseResult = format.parse(result, new ParsePosition(0));
        System.out.println(Arrays.asList(parseResult));
        System.out.println(Arrays.asList(format.parse(" 3.14,  3.1", new ParsePosition(0))));
    }

    @Test
    public void testMessageFormat6() {
        System.out.println(MessageFormat.format("helloworld", new Object[0]));
    }

    @Test
    public void testDate() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date date = format.parse("20181217");
        System.out.println(date);
    }

    @Test
    public void testFilter() {
        List<Integer> integers = Arrays.asList(1, 3, 4, 5);
        List<Integer> collect = integers.stream()
                .filter(i -> i != 1)
                .filter(i -> i != 3)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void testReturn() {
        List<Integer> integers = Arrays.asList(1, 3, 4, 5);
        integers.forEach((i) -> {
            if (i.equals(3)) {
                return;
            }
            System.out.println(i);
        });
    }

    @Test
    public void testDateUtilOrg() throws ParseException {
        Date date = DateUtils.parseDate("20170227", "yyyyMMdd");
        System.out.println(date);
        System.out.println(DateUtils.addDays(date, 2));
    }

    @Test
    public void testStreamNullGet() {
        List<Integer> list = Lists.newArrayList(1, 2, 3);
        Integer integer = list.stream()
                .filter(i -> i > 5)
                .collect(Collectors.toList())
                .get(0);
        System.out.println(integer);
    }
}
