package threadcoreknowledge.stopthreads;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/7/31
 * Describe :
 * 最佳实践2：在catch子语句中调用Thread.currentThread.interrupt()来恢复设置中断状态，
 * 以便在后续的执行中，依然能够检查到刚才发生了中断，回到刚才的RightWayStopThreadInProd补上中断，让它跳出
 */
public class RightWayStopThreadInProd2 implements Runnable {
    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("程序运行结束");
                break;
            }
            System.out.println("go");
            reInterrupt();
        }
    }

    private static void reInterrupt() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // 传递中断，使isInterrupted()有效判断
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
