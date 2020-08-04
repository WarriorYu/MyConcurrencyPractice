package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/8/4
 * Describe : 通过分析join原理，分析出join的代替写法
 */
public class JoinPrinciple {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"执行完毕");
            }
        });
        thread1.start();
        System.out.println("开始等待子线程运行完毕");
        // 主线程会等待子线程执行完毕
//        thread1.join();
        //这三行代码和thread1.join();的作用是一样的
        synchronized (thread1) {
            thread1.wait();
        }
        System.out.println("所有子线程执行完毕");
    }
}
