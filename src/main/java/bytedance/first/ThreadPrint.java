package bytedance.first;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author buku.ch
 * @Desc
 * @date 2023/11/19 19:01
 */
public class ThreadPrint {

    private int cnt = 0;

    private Lock lock = new ReentrantLock();

    public void print() {
        Condition a = lock.newCondition();
        Condition b = lock.newCondition();
        Condition c = lock.newCondition();
        new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    while (cnt % 3 != 0) {
                        a.await();
                    }
                    System.out.println("A");
                    cnt++;
                    b.signal();
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
                    while (cnt % 3 != 1) {
                        b.await();
                    }
                    cnt++;
                    System.out.println("B");
                    c.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }).start();;


        new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    while (cnt % 3 != 2) {
                        c.await();
                    }
                    cnt++;
                    System.out.println("C");
                    a.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }).start();;

    }

    public static void main(String[] args) {
        ThreadPrint threadPrint = new ThreadPrint();
        threadPrint.print();
    }

}
