package design;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 观察者模式
 *
 * @author shanyb
 */
public class ObserverPattern {
    
    
    public void test() {
        Feed f = new Feed();
        f.registerObserver(tweet -> {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("Breaking news in NY! " + tweet);
            }
        });
        
        f.registerObserver(tweet -> {
            if (tweet != null && tweet.contains("queue")) {
                System.out.println("Yet another news ! " + tweet);
            }
        });
        f.notifyObserver("queue");
    }
    
    interface Observer {
        void notify(String tw);
    }
    
    interface Subject {
        void registerObserver(Observer o);
        
        void notifyObserver(String s);
    }
    
    class Feed implements Subject {
        private List<Observer> observers = Lists.newArrayList();
        
        @Override
        public void registerObserver(Observer o) {
            observers.add(o);
        }
        
        @Override
        public void notifyObserver(String str) {
            observers.forEach(observer -> observer.notify(str));
        }
    }
}
