/**
 * Copyright (C) 2008-2019 All Rights Reserved.
 */


package basic;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * concurrenthashmap 100% cpu问题
 *
 * @author shanyingbo
 * @version $Id ConcurrentHashMapError.java, v 0.1 2019-03-19 2:11 PM shanyingbo Exp $$
 */
public class ConcurrentHashMapError {
  static Map<Integer, Integer> concurrentMap = new ConcurrentHashMap<>();

  public static void main(String[] args) {
    System.out.println("Fibonacci result for 20 is" + fibonacci(20));
  }

  static int fibonacci(int i) {
    if (i == 0)
      return i;

    if (i == 1)
      return 1;

    return concurrentMap.computeIfAbsent(i, (key) -> {
      System.out.println("Value is " + key);
      return fibonacci(i - 2) + fibonacci(i - 1);
    });
  }
}