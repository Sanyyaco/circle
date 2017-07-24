package ru.geekbrains.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 24.07.2017.
 */
public class Solution1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 3 ; i++) {
            list.add("a");
            list.add("b");
            list.add("c");
            list.add("d");
            list.add("e");
        }

        Map<String,Integer> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (map.get(str) == null) map.put(str,1);
            else map.put(str, map.get(str) + 1);
        }

        for(Map.Entry<String,Integer> e : map.entrySet()){
            System.out.println("Слово: "+ e.getKey() +", встречается в списке " + e.getValue() +" раз(а)" );
        }


    }
}
