package com.zxj.demo.Offer;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by upc on 2019/9/14.
 */
public class Offer54 {
    /**
     * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
     * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
     * 如果当前字符流没有存在出现一次的字符，返回#字符。
     */
    LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

    //    static int i=0;
    //Insert one char from stringstream
    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.replace(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            char key = iterator.next().getKey();
            int value = map.get(key);
            if (value == 1) {
                return key;
            }
        }
        return '#';
    }
}
