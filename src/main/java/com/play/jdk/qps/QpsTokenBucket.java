package com.play.jdk.qps;

/**
 * Created by fuzh2 on 2017/11/6.
 */
public class QpsTokenBucket {
    private static long time = System.currentTimeMillis();
    private static int createTokenrate = 3;
    private static int size = 10;
    //当前令牌数
    private static int tokens = 0;

    public static boolean grant() {
        long now = System.currentTimeMillis();
        //这段时间内需要产生的令牌数量
        int in = (int) ((now - time) / 50 * createTokenrate);
        tokens = Math.min(size, tokens + in);
        time = now;
        if (tokens > 0) {
            --tokens;
            return true;
        } else {
            return false;
        }
    }
}
