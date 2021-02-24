package design;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 责任链模式
 * <p>
 * 实现类似于观察者模式
 *
 * @author shanyb
 */
public class FilterChainPattern {
    
    public static void main(String[] args) {
        FilterChainPattern filterChainPattern = new FilterChainPattern();
        filterChainPattern.test();
    }
    
    public void test() {
        FilterChainHandler filterChainHandler = new FilterChainHandler()
                .addHandler(str -> System.out.println(str + "敏感词处理"))
                .addHandler(str -> System.out.println(str + "版权处理"))
                .addHandler(str -> System.out.println(str + "头部处理"));
        
        filterChainHandler.process("zhangsan");
    }
    
    interface Handler {
        /**
         * 处理类
         *
         * @param str
         */
        void handle(String str);
    }
    
    class FilterChainHandler {
        
        List<Handler> handlers = Lists.newArrayList();
        
        public FilterChainHandler addHandler(Handler handler) {
            this.handlers.add(handler);
            return this;
        }
        
        public void process(String str) {
            for (Handler handler : handlers) {
                handler.handle(str);
            }
        }
    }
}
