/**
 * Copyright (C) 2008-2019 All Rights Reserved.
 */


package system;

/**
 * CPU监控
 *
 * @author shanyingbo
 * @version $Id CPUMonitorCalcTest.java, v 0.1 2019-02-13 2:52 PM shanyingbo Exp $$
 */

public class CPUMonitorCalcTest {
  
  @org.junit.Test
  public void shouldCpuUse() throws InterruptedException {
    for (int i = 0; i < 5; i++) {
      new Thread(() -> {
        while (true) {
          long bac = 1000000;
          bac = bac >> 1;
        }
      }).start();
    }
    while (true) {
      Thread.sleep(5000);
      System.out.println(CPUMonitorCalc.getInstance().getProcessCpu());
    }

  }
}