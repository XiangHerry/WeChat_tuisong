// Source code is decompiled from a .class file using FernFlower decompiler.
package ydzhao.weixin.tuisong.util;

import com.alibaba.fastjson.JSONObject;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

public class Pusher {
    private static String appId = "wxcab6eed2399be89a";
    private static String secret = "ba834d6e2dded1aaf3b2a153e9b7cc79";
    private static String templateId = "JZVLNXPznTa_tsBvGOrKYOkfnoAvr7pJJK54tep-YlU";

    public Pusher() {
    }

    public static void push(String openId) {
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId(appId);
        wxStorage.setSecret(secret);
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder().toUser(openId).templateId(templateId).build();
        templateMessage.addData(new WxMpTemplateData("name", "value", "#FF00FF"));
        templateMessage.addData(new WxMpTemplateData("nunu", "1", "#FF00FF"));
        JSONObject todayWeather = Tianqi.getNanjiTianqi();
        String weatherDescription = todayWeather.getJSONArray("weather").getJSONObject(0).getString("description");
        JSONObject main = todayWeather.getJSONObject("main");
        String tempMin = String.valueOf(main.getDouble("temp_min"));
        String tempMax = String.valueOf(main.getDouble("temp_max"));
        templateMessage.addData(new WxMpTemplateData("tianqi", weatherDescription, "#00FFFF"));
        templateMessage.addData(new WxMpTemplateData("low", tempMin, "#173177"));
        templateMessage.addData(new WxMpTemplateData("high", tempMax, "#FF6347"));
        templateMessage.addData(new WxMpTemplateData("caihongpi", CaiHongPi.getCaiHongPi(), "#FF69B4"));
        templateMessage.addData(new WxMpTemplateData("lianai", "" + JiNianRi.getLianAi(), "#FF1493"));
        templateMessage.addData(new WxMpTemplateData("shengri", "" + JiNianRi.getShengRi(), "#FFA500"));
        templateMessage.addData(new WxMpTemplateData("jinju", "" + CaiHongPi.getJinJu(), "#C71585"));
        String beizhu = "";
        if (JiNianRi.getLianAi() % 365 == 0) {
            beizhu = "\u4eca\u5929\u662f\u604b\u7231\u7eaa\u5ff5\u65e5\uff01";
        }

        templateMessage.addData(new WxMpTemplateData("beizhu", beizhu, "#FF0000"));

        try {
            System.out.println(templateMessage.toJson());
            System.out.println(wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage));
        } catch (Exception var11) {
            System.out.println("\u63a8\u9001\u5931\u8d25\uff1a" + var11.getMessage());
            var11.printStackTrace();
        }

    }
}
