/**
 * Copyright (C) 2008-2019 All Rights Reserved.
 */


package system;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.ThreadMXBean;

/**
 * 进程cpu耗时
 *
 * @author shanyingbo
 * @version $Id CPUMonitorCalc.java, v 0.1 2019-02-13 2:50 PM shanyingbo Exp $$
 */
public class CPUMonitorCalc {

  private static CPUMonitorCalc instance = new CPUMonitorCalc();

  private OperatingSystemMXBean osMxBean;
  private ThreadMXBean threadBean;
  private long preTime = System.nanoTime();
  private long preUsedTime = 0;

  private CPUMonitorCalc() {
    osMxBean = ManagementFactory.getOperatingSystemMXBean();
    threadBean = ManagementFactory.getThreadMXBean();
  }

  public static CPUMonitorCalc getInstance() {
    return instance;
  }

  public double getProcessCpu() {
    long totalTime = 0;
    for (long id : threadBean.getAllThreadIds()) {
      totalTime += threadBean.getThreadCpuTime(id);
    }
    long curtime = System.nanoTime();
    long usedTime = totalTime - preUsedTime;
    long totalPassedTime = curtime - preTime;
    preTime = curtime;
    preUsedTime = totalTime;
    return (((double) usedTime) / totalPassedTime / osMxBean.getAvailableProcessors()) * 100;
  }
}