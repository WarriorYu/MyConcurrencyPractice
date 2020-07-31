package threadcoreknowledge.stopthreads;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/7/31
 * Describe : 如果while里面放try/catch，会导致中断失效
 */
public class CantInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int num = 0;

                while (num <= 1000 && !Thread.currentThread().isInterrupted()) {
                    if (num % 100 == 0) {
                        System.out.println(num + "是100的倍数");
                    }
                    num++;

                    try {
                        // 这里sleep收到了中断，但是sleep的设计理念会导致intercept的
                        // 标记为被清除，所以while里的!Thread.currentThread().isInterrupted()无法正常判断-=-
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
