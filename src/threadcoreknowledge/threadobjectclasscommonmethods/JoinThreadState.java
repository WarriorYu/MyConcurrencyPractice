package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/8/3
 * Describe :先join再mainThread.getState()
 *      通过debugger看线程join前后状态的对比
 */
public class JoinThreadState {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println(mainThread.getState());
                    System.out.println("Thread0---执行完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        System.out.println("等待子线程运行完毕");
        try {
            thread.join();
            System.out.println("子线程运行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
