package util;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindow {

    void window(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;

        int valid = 0;

        while (right < s.length()) {
            // c是将要移入窗口的字符
            char c = s.charAt(right);
            // 将窗口右移
            right++;

            // TODO: 进行窗口内数据的更新
            System.out.printf("window: [%s, %s]\n", left, right);

            // TODO: 判断左窗口是否要收缩
            boolean shrink = false;

            while(shrink) {
                char d = s.charAt(left);
                left ++;
                // TODO: 进行窗口内数据的更新
            }
        }
    }

}