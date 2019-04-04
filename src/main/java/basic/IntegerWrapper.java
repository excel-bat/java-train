/**
 * Copyright (C) 2008-2019 All Rights Reserved.
 */


package basic;

import java.net.Socket;

/**
 * Interger 的包装类
 *
 * @author shanyingbo
 * @version $Id IntegerWrapper.java, v 0.1 2019-02-12 5:52 PM shanyingbo Exp $$
 */
public class IntegerWrapper {

  Socket socket;



  public static void main(String[] args) {
    System.out.println(3240&1);
    //十进制转为二进制字符串
    System.out.println(Integer.toBinaryString(3240)  );
    System.out.println(Integer.parseInt("55555555",16));
  }
}