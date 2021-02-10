package algorithm.normal;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shanyb
 */
public class MyBlockingQueue<E> {
    
    /**
     * 固定长度
     */
    private Object[] elements;
    
    /**
     * 队列的头和尾
     */
    private int head = 0, tail = 0;
    
    /**
     * 队列目前长度
     */
    private int size;
    
    private ReentrantLock lock = new ReentrantLock();
    
    private Condition nonEmpty = lock.newCondition();
    
    private Condition nonFull = lock.newCondition();
    
    public MyBlockingQueue(int capacity) {
        this.elements = new Object[capacity];
    }
    
    public void put(E e) {
        lock.lock();
        try {
            while (size == elements.length) {
                nonFull.await();
            }
            elements[tail] = e;
            if (tail++ == elements.length) {
                tail = 0;
            }
            size++;
            nonEmpty.signal();
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            lock.unlock();
        }
        
    }
    
    public void take() {
        lock.lock();
        E e = null;
        try {
            while (size == 0) {
                nonEmpty.await();
            }
            e = (E) elements[head];
            if (++head == elements.length) {
                head = 0;
            }
            size--;
            nonFull.signal();
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    
    
}
