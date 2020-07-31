package threadcoreknowledge.stopthreads;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/7/31
 * Describe : 错误的停止方法
 * <p>
 * 用stop来停止线程会导致线程运行一半突然停止，没办法完成一个基本单位的操作（一个连队），
 * 会造成脏数据（有的连队多领取少领取装备）
 *
 * 这个例子中，当停止线程后，停止前的那个连队9人中也许有2人还没领取就结束了。
 */
public class StopThread implements Runnable {

    @Override
    public void run() {
        // 模拟指挥连队: 一共有5个连队，每个连队10人，以连队为单位，
        // 发送武器弹药，叫到号的士兵前去领取
        for (int i = 0; i < 5; i++) {
            System.out.println("连队" + i + "开始领取武器");
            for (int j = 0; j < 10; j++) {
                System.out.println(j);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new StopThread());
        thread.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.stop();

    }
}
