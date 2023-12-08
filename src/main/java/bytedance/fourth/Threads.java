package bytedance.fourth;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/12/7 10:54
 */
public class Threads {

    private Lock lock = new ReentrantLock();

    private volatile int cnt = 0;

    public void start() {

        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    if (cnt % 3 == 0) {
                        cnt++;
                        System.out.println("A");
                    }
                    conditionB.signal();
                    conditionA.await();
                } catch (Exception e) {} finally {
                    lock.unlock();
                }
            }

        }).start();

        new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    if (cnt % 3 == 1) {
                        cnt++;
                        System.out.println("B");
                    }
                    conditionC.signal();
                    conditionB.await();
                } catch (Exception e) {} finally {
                    lock.unlock();
                }
            }

        }).start();

        new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    if (cnt % 3 == 2) {
                        cnt++;
                        System.out.println("C");
                    }
                    conditionA.signal();
                    conditionC.await();
                } catch (Exception e) {} finally {
                    lock.unlock();
                }
            }

        }).start();
    }

    public static void main(String[] args) {

        new Threads().start();

    }

}
