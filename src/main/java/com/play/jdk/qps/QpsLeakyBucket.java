package com.play.jdk.qps;

/**
 * Created by fuzh2 on 2017/11/6.
 */
public class QpsLeakyBucket {
    //时间刻度
    private static long time = System.currentTimeMillis();
    //桶里面当前的水滴数
    private static int water = 0;
    //桶的大小
    private static int size = 10;
    //出水速度
    private static int rate = 3;

    public static boolean grant() {
        //计算出水的数量
        long now = System.currentTimeMillis();
        int out = (int) ((now - time) / 700 * rate);
        //漏水后的剩余
        water = Math.max(0, water - out);
        time = now;
        if (size > (water + 1)) {
            ++water;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 510; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if (grant()) {
                        System.out.println("执行业务逻辑");
                    } else {
                        System.out.println("限流....");
                    }
                }
            }).start();
        }
    }
}
