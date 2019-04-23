package com.jesper.controller;

import sun.util.resources.LocaleData;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @Author: YuanJinXiu
 * @Description: ${description}
 * @Date: 2019/4/22 18:38
 * @Version: 1.0
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("key1","1");
        map.put("key2","2");
        map.put("key3","3");
        //Entry 遍历 在容量大的时候推荐使用
        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        //key value的方式遍历 通过Map.keySet 遍历所有的value和key   元素比较小的情况下推荐使用
        for(String key:map.keySet()){
            String value = map.get(key);
            System.out.println(key+":"+value);
        }

        //Iterator 迭代器的方法 map.entrySet().iterator 方法遍历
        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,String> entry = iterator.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        Vector v = new Vector();

        //set
        //1.TreeSet
        Set<Integer> set  =  new TreeSet<>();
        set.add(1);
        set.add(3);
        set.add(2);
        for (Integer i:set){
            System.out.println(i);
        }
        Iterator<Integer> i = set.iterator();
        while(i.hasNext()){
            Integer in = i.next();
            System.out.println(in);
        }
        //end set

        //linkedList
        List<String> linkList = new LinkedList();
        linkList.add("1");
        linkList.add("3");
        linkList.add("2");
        System.out.println(linkList.size());
        Iterator iii = linkList.iterator();
        System.out.println("linkedlist 遍历");
        while (iii.hasNext()){
            System.out.println(iii.next());
        }

        System.out.println("----------分割线---------");
        List list =  new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(3);
        //移除某个元素
        System.out.println("List"+list);
        list.stream().distinct().forEach(n->{
            System.out.println("hi,"+n);
        });

        //创建List2集合
        List<String> list2 = new ArrayList<String>();
        //给集合中添加元素
        list2.add("abc1");
        list2.add("abc2");
        list2.add("abc3");
        list2.add("abc4");
        list2.forEach(n->{
            System.out.println("foreach 遍历"+n);
        });
        //迭代集合，当有元素为"abc2"时，集合加入新元素"itcast"
        for(String str:list2){
            if("abc2".equals(str)){
                list2.remove(str);//发生ConcurrentModificationException因为元素在使用的时候发生了并发的修改，导致异常抛出。但是删除完毕马上使用break跳出，则不会触发报错。
                break;//使用 跳出 则不会出发报错
            }
        }
        System.out.println(list2);
        ListIterator<String> it = list2.listIterator();
        while(it.hasNext()){
            String str = it.next();
            //判断取出的元素是否是"abc2"，是就添加一个新元素
            if("abc2".equals(str)){
                list2.add("itcast");// 该操作会导致程序出错
            }
          //  System.out.println(list2);
        }
        //在迭代过程中，使用了集合的方法对元素进行操作。导致迭代器并不知道集合中的变化，容易引发数据的不确定性。在迭代的时候不要不要使用集合操作
        //那么想要在迭代时对元素操作咋办？通过ListIterator迭代器操作元素是可以的，
        // ListIterator的出现，解决了使用Iterator迭代过程中可能会发生的错误情况。

        //map
        //TreeMap
        TreeMap<String, String> tmp = new TreeMap<String, String>();
        tmp.put("d", "ddd");
        tmp.put("b", "bbb");
        tmp.put("a", "aaa");
        tmp.put("c", "ccc");
        tmp.descendingMap();
        Iterator<String> iterator_2 = tmp.keySet().iterator();
        while (iterator_2.hasNext()) {
            Object key = iterator_2.next();
            System.out.println("tmp.get(key) is :" + tmp.get(key));
        }

        // 定义HashTable,用来测试
        Hashtable<String, String> tab = new Hashtable<String, String>();
        tab.put("d", "ddd");
        tab.put("b", "bbb");
        tab.put("a", "aaa");
        tab.put("c", "ccc");
        Iterator<String> iterator_1 = tab.keySet().iterator();
        while (iterator_1.hasNext()) {
            Object key = iterator_1.next();
            System.out.println("tab.get(key) is :" + tab.get(key));
        }
        //end map

        Object obj = new Object();

        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间: " + currentTime);


        //字符串的比较
        String str = "Hello World";
        String anotherString = "hello world";
        Object objStr = str;
        System.out.println( str.compareTo(anotherString) );
        System.out.println( str.compareToIgnoreCase(anotherString) );  //忽略大小写
        System.out.println( str.compareTo(objStr.toString()));
        System.out.println(str.equals(objStr.toString()));
    }



}
