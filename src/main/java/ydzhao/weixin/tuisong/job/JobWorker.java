package ydzhao.weixin.tuisong.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ydzhao.weixin.tuisong.util.Pusher;

/**
 *@ClassName JobWorker
 *@Description TODO
 *@Author ynw
 *@Date
 */
@Component
public class JobWorker {
    //要推送的用户openid
    private static String openId = "oZJbw6tuOUN3_LEZuhyGzaXOF1_s";

    private static String openId2 = "oZJbw6lapEQETehdrUMLEdEGeZvU";

    @Scheduled(cron = "00 00 13 * * ?")
    public void goodMorning(){
        Pusher.push(openId2);
    }
}
