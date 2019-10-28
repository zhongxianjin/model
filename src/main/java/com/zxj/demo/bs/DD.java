package com.zxj.demo.bs;

import java.util.*;

/**
 * Created by upc on 2019/9/19.
 */
public class DD {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] temp = new int[2 * m];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            temp[i] = scan.nextInt();
            temp[i++] = scan.nextInt();
            if (map.containsKey(temp[i - 2])) {
                map.replace(temp[i - 2], map.get(temp[i - 2]) + 1);
            } else {
                map.put(temp[i - 2], 1);
            }

        }
        int count = 0;
//        Collections.sort(map, (Comparator<Map.Entry<Integer, Integer>>) (o1, o2) -> (o1.getValue() - o2.getValue()));
        for (int i = 0; i < 2 * m; i++) {
            if (map.get(temp[i]) > 1) {
                map.replace(temp[i], map.get(temp[i]) - 1);
                map.replace(temp[i + 1], map.get(temp[i + 1]) - 1);
                temp[i] = 0;
                temp[i + 1] = 0;
                i++;
            } else {
                if (map.get(temp[i + 1]) > 1) {
                    map.replace(temp[i], map.get(temp[i]) - 1);
                    map.replace(temp[i + 1], map.get(temp[i + 1]) - 1);
                    temp[i] = 0;
                    temp[i + 1] = 0;
                    i++;
                } else {
                    i++;
                }
            }
        }


    }
}
