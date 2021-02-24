package threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shanyb
 */
public class ProducerAndConsumerByLock {
    
    private static int count = 0;
    ReentrantLock lock = new ReentrantLock();
    Condition producerCondition = lock.newCondition();
    Condition consumerCondition = lock.newCondition();
    private int maxNum = 3;
    
    public static void main(String[] args) {
        
        ProducerAndConsumerByLock foo = new ProducerAndConsumerByLock();
        
        new Thread(foo.new Producer()).start();
        new Thread(foo.new Producer()).start();
        
        new Thread(foo.new Consumer()).start();
        new Thread(foo.new Consumer()).start();
        
        
    }
    
    
    class Producer implements Runnable {
        
        @Override
        public void run() {
            
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                lock.lock();
                try {
                    while (count == maxNum) {
                        producerCondition.await();
                        System.out.println("生产能力达到上限，进入等待状态");
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                    consumerCondition.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                
            }
        }
    }
    
    class Consumer implements Runnable {
        
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                lock.lock();
                try {
                    while (count == 0) {
                        consumerCondition.await();
                        System.out.println("消费能力达到上限，进入等待状态");
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                    producerCondition.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                
            }
        }
    }
    
    
}
