package threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author shanyb
 */
public class ProducerAndConsumerByQueue {
    
    private BlockingQueue<Toy> blockingQueue = new LinkedBlockingQueue<Toy>();
    
    public static void main(String[] args) {
        ProducerAndConsumerByQueue bar = new ProducerAndConsumerByQueue();
        new Thread(bar.new Prouducer()).start();
        new Thread(bar.new Consumer()).start();
        
    }
    
    class Prouducer implements Runnable {
        
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                Toy t = new Toy(i + "");
                try {
                    blockingQueue.put(t);
                    System.out.println(Thread.currentThread().getName() + "生产" + t.getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    class Consumer implements Runnable {
        
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                
                try {
                    Toy t = blockingQueue.take();
                    System.out.println(Thread.currentThread().getName() + "消费了" + t.getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    
    class Toy {
        private String name;
        
        private Toy(String name) {
            this.name = name;
        }
        
        public String getName() {
            return "toy" + name;
        }
        
    }
    
    
}
