///**
// * Copyright (C) 2008-2019 All Rights Reserved.
// */
//
//
//package io;
//
//import java.io.*;
//import java.util.concurrent.TimeUnit;
//
//
//import org.openjdk.jmh.annotations.Benchmark;
//import org.openjdk.jmh.annotations.BenchmarkMode;
//import org.openjdk.jmh.annotations.Mode;
//import org.openjdk.jmh.annotations.OutputTimeUnit;
//import org.openjdk.jmh.runner.Runner;
//import org.openjdk.jmh.runner.options.Options;
//import org.openjdk.jmh.runner.options.OptionsBuilder;
//
///**
// * Filechannel 测试类
// *
// * @author shanyingbo
// * @version $Id FileChannelUtil.java, v 0.1 2019-04-17 11:38 shanyingbo Exp $$
// */
//public class FileChannelBenchmark {
//
//
//  static int writeCount = 1;
//  static String inputStr = "very woman is a" + " treasure but way too often we forget"
//          + " how precious they are. We get lost in daily "
//          + "chores and stinky diapers, in work deadlines and dirty dishes, in daily errands and occasional breakdowns.";
//
//  public static void main(String[] args) throws Exception {
//    Options opt = new OptionsBuilder().include(FileChannelBenchmark.class.getSimpleName()).forks(1).build();
//    new Runner(opt).run();
//
//  }
//
//  @Benchmark
//  @BenchmarkMode(Mode.SingleShotTime)
//  @OutputTimeUnit(TimeUnit.MILLISECONDS)
//  public void TestFileWriter() throws IOException {
//    File file = new File("/Users/shanyingbo/Desktop/fileWithWriter.txt");
//    FileWriter fileWriter = new FileWriter(file);
//    for (int i = 0; i < writeCount; i++) {
//      fileWriter.write("JAVA TEST");
//    }
//
//  }
//
//  @Benchmark
//  @BenchmarkMode(Mode.SingleShotTime)
//  @OutputTimeUnit(TimeUnit.MILLISECONDS)
//  public void TestBuffer() throws IOException {
//    File file = new File("/Users/shanyingbo/Desktop/buffer.txt");
//    BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(file));
//    for (int i = 0; i < writeCount; i++) {
//      buffer.write(inputStr.getBytes());
//    }
//    buffer.flush();
//    buffer.close();
//  }
//
//  @Benchmark
//  @BenchmarkMode(Mode.SingleShotTime)
//  @OutputTimeUnit(TimeUnit.MILLISECONDS)
//  public void TestNormal() throws IOException {
//    File file = new File("/Users/shanyingbo/Desktop/normal.txt");
//    FileOutputStream out = new FileOutputStream(file);
//    for (int i = 0; i < writeCount; i++) {
//      out.write(inputStr.getBytes());
//
//    }
//    out.close();
//
//  }
//
//  @Benchmark
//  @BenchmarkMode(Mode.SingleShotTime)
//  @OutputTimeUnit(TimeUnit.MILLISECONDS)
//  public void TestNIO() throws IOException {
//    File file = new File("/Users/shanyingbo/Desktop/nio.txt");
//    NIOWriter nioWriter = new NIOWriter(file, 2048);
//    for (int i = 0; i < writeCount; i++) {
//      nioWriter.write(inputStr);
//
//    }
//    nioWriter.close();
//
//  }
//}