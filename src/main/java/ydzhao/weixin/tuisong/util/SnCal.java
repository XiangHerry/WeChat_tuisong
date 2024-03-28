// Source code is decompiled from a .class file using FernFlower decompiler.
package ydzhao.weixin.tuisong.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class SnCal {
    private static String ak = "";
    private static String sk = "";

    public SnCal() {
    }

    public static void main(String[] args) {
        try {
            System.out.println(HttpUtil.getUrl("https://api.map.baidu.com/weather/v1/?district_id=320111&data_type=all&ak=tvL7Dq4j9nrs5QmdWcpZNACflCmRcW7L"));
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }

    public static String getSn() throws UnsupportedEncodingException {
        SnCal snCal = new SnCal();
        Map paramsMap = new LinkedHashMap();
        paramsMap.put("district_id", "222405");
        paramsMap.put("data_type", "all");
        paramsMap.put("ak", ak);
        String paramsStr = snCal.toQueryString(paramsMap);
        String wholeStr = new String("/weather/v1/?" + paramsStr + sk);
        String tempStr = URLEncoder.encode(wholeStr, "UTF-8");
        System.out.println(snCal.MD5(tempStr));
        return snCal.MD5(tempStr);
    }

    public String toQueryString(Map<?, ?> data) throws UnsupportedEncodingException {
        StringBuffer queryString = new StringBuffer();
        Iterator var3 = data.entrySet().iterator();

        while(var3.hasNext()) {
            Map.Entry<?, ?> pair = (Map.Entry)var3.next();
            queryString.append(String.valueOf(pair.getKey()) + "=");
            String var10001 = (String)pair.getValue();
            queryString.append(URLEncoder.encode(var10001, "UTF-8") + "&");
        }

        if (queryString.length() > 0) {
            queryString.deleteCharAt(queryString.length() - 1);
        }

        return queryString.toString();
    }

    public String MD5(String md5) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();

            for(int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString(array[i] & 255 | 256).substring(1, 3));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException var6) {
            return null;
        }
    }
}
