package bytedance.sec;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/22 19:25
 */
public class ThreadPrint {

    private volatile AtomicInteger cnt = new AtomicInteger(0);

    public void run() {
        Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        Thread a = new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    if (cnt.getAndIncrement() % 3 == 0) {
                        System.out.println("A");
                    }
                    conditionB.signal();
                    conditionA.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread b = new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    if (cnt.getAndIncrement() % 3 == 1) {
                        System.out.println("B");
                    }
                    conditionC.signal();
                    conditionB.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread c = new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    if (cnt.getAndIncrement() % 3 == 2) {
                        System.out.println("C");
                    }
                    conditionA.signal();
                    conditionC.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        });

        a.start();
        b.start();
        c.start();
    }

    public static void main(String[] args) {
        ThreadPrint threadPrint = new ThreadPrint();
        threadPrint.run();

    }

}
