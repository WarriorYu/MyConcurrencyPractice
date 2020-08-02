package threadcoreknowledge.sixstates;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/8/2
 * Describe : 展示线程的NEW、RUNNABLE、Terminated状态。即使是正在运行，
 * 也是Runnbale状态，而不是Running.
 */
public class NewRunnableTerminated implements Runnable{
    public static void main(String[] args) {
        Thread thread = new Thread(new NewRunnableTerminated());
        // 打印出NEW的状态
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 打印出RUNNABLE的状态,即使正在运行，也是RUNNABlLE，而不是RUNNING
        System.out.println(thread.getState());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 打印出TERMINATED 状态
        System.out.println(thread.getState());

    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}
