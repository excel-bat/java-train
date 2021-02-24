package algorithm.normal;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * lfu cache
 *
 * @author shanyb
 */
public class MyLfuCache {
    /**
     * 存储缓存内容
     */
    Map<Integer, Node> cache;
    
    /**
     * 存储每个频次对应的双向链表
     */
    Map<Integer, LinkedHashSet<Node>> freqMap;
    
    int size;
    
    int capacity;
    /**
     * 存储当前最小频次
     */
    int min;
    
    public MyLfuCache(int capacity) {
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        //get 一次增加频度
        freqInc(node);
        
        return node.value;
    }
    
    /**
     * 增加频次
     */
    private void freqInc(Node node) {
        //从原freq链表里移除，并更新min
        int freq = node.freq;
        
        LinkedHashSet<Node> set = freqMap.get(freq);
        set.remove(node);
        
        //当freq map 为空，且freq 最小，否则freq 对应的map 中还有其他节点，不能直接加
        if (freq == min && set.size() == 0) {
            min = freq + 1;
        }
        
        node.freq++;
        //加入新freq 对应的链表
        LinkedHashSet<Node> newSet = freqMap.get(freq + 1);
        if (newSet == null) {
            newSet = new LinkedHashSet<>();
            freqMap.put(freq + 1, newSet);
        }
        newSet.add(node);
    }
    
    /**
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        
        Node node = cache.get(key);
        if (node != null) {
            //相同key，则进行覆盖
            node.value = value;
            freqInc(node);
        } else {
            if (size == capacity) {
                //当容量满，将元素移除
                Node deadNode = removeNode();
                cache.remove(deadNode.key);
                size--;
            }
            
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;
        }
    }
    
    
    /**
     * 将新节点加入freqMap
     *
     * @param newNode
     */
    private void addNode(Node newNode) {
        LinkedHashSet<Node> set = freqMap.get(1);
        if (set == null) {
            set = new LinkedHashSet<>();
            freqMap.put(1, set);
        }
        set.add(newNode);
        min = 1;
    }
    
    
    /**
     * 将节点移除freqMap
     *
     * @return
     */
    private Node removeNode() {
        LinkedHashSet<Node> set = freqMap.get(min);
        Node node = set.iterator().next();
        set.remove(node);
        return node;
    }
    
    
    /**
     * Node
     */
    class Node {
        int key;
        int value;
        int freq = 1;
        
        public Node() {
        }
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    
}
