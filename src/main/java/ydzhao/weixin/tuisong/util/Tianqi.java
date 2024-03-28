// Source code is decompiled from a .class file using FernFlower decompiler.
package ydzhao.weixin.tuisong.util;

import com.alibaba.fastjson.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Tianqi {
    private static String ak = "30423efacd5019541496b51a4bd4a27e";
    private static String city = "Portland,US";

    public Tianqi() {
    }

    public static JSONObject getNanjiTianqi() {
        JSONObject today = new JSONObject();

        try {
            String url = "https://api.openweathermap.org/data/2.5/weather?lat=43.6591&lon=-70.2568&appid=" + ak + "&units=metric";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            System.out.println((String)response.body());
            JSONObject jsonObject = JSONObject.parseObject((String)response.body());
            if (jsonObject.getInteger("cod") == 200) {
                today = jsonObject;
            }
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        return today;
    }

    public static void main(String[] args) {
        System.out.println(getNanjiTianqi());
    }
}
