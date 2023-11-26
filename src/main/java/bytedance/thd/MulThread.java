package bytedance.thd;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/26 18:42
 */
public class MulThread extends Thread {

    private volatile int cnt = 0;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        Condition a = lock.newCondition();
        Condition b = lock.newCondition();
        Condition c = lock.newCondition();

        new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    if (cnt % 3 == 0) {
                        System.out.println("a");
                        cnt++;
                    }
                    b.signal();
                    a.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    if (cnt % 3 == 1) {
                        System.out.println("b");
                        cnt++;
                    }
                    c.signal();
                    b.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    if (cnt % 3 == 2) {
                        System.out.println("c");
                        cnt++;
                    }
                    a.signal();
                    c.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        MulThread mulThread = new MulThread();
        mulThread.start();
    }
}
