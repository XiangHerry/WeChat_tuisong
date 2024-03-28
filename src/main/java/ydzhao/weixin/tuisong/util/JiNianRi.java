// Source code is decompiled from a .class file using FernFlower decompiler.
package ydzhao.weixin.tuisong.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JiNianRi {
    static String lianAi = "2023-09-04";
    static String shengRi = "1990-11-12";
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public JiNianRi() {
    }

    public static int before(String date) {
        int day = 0;

        try {
            long time = simpleDateFormat.parse(date).getTime() - System.currentTimeMillis();
            day = (int)(time / 86400000L);
        } catch (ParseException var4) {
            var4.printStackTrace();
        }

        return day;
    }

    public static int after(String date) {
        int day = 0;

        try {
            long time = System.currentTimeMillis() - simpleDateFormat.parse(date).getTime();
            day = (int)(time / 86400000L);
        } catch (ParseException var4) {
            var4.printStackTrace();
        }

        return day;
    }

    public static int getLianAi() {
        return after(lianAi);
    }

    public static int getShengRi() {
        return before(shengRi);
    }
}
