package threadcoreknowledge.startthread;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/7/31
 * Describe : start() 和 run()方法比较
 */
public class StartAndRunThread {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        runnable.run();
        new Thread(runnable).start();
    }
}
