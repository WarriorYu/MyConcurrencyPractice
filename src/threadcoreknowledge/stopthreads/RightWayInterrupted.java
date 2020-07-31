package threadcoreknowledge.stopthreads;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/7/31
 * Describe : 注意Thread.interrupted()方法的目标对象是"当前线程"，而不管本方法来自于哪个对象
 */
public class RightWayInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {

                }
            }
        });

        threadOne.start();
        threadOne.interrupt();
        // 获取中断标志
        System.out.println("isInterrupted:" + threadOne.isInterrupted());
        // 获取中断标志并重置
        // 因为interrupted()是静态方法，不管是threadOne还是Thread，
        // 执行它的都是主函数main函数，main函数没有经过任何的中断，所以返回false。
        System.out.println("isInterrupted:" + threadOne.interrupted());
        // 获取中断标志并重置 原理同上
        System.out.println("isInterrupted:" + Thread.interrupted());
        // 获取中断标志
        System.out.println("isInterrupted:" + threadOne.isInterrupted());
        threadOne.join();
        System.out.println("Main thread is over");

        /**
         * 打印结果：
         *
         * isInterrupted:true
         * isInterrupted:false
         * isInterrupted:false
         * isInterrupted:true
         */
    }
}
