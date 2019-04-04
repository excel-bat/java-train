/**
 * Copyright (C) 2008-2019 All Rights Reserved.
 */


package files;

import com.google.common.io.Files;
import org.junit.rules.Stopwatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

/**
 * 随机文件读写扩展
 *
 * @author shanyingbo
 * @version $Id RandomAccessFileEx.java, v 0.1 2019-02-27 2:24 PM shanyingbo Exp $$
 */
public class RandomAccessFileEx extends RandomAccessFile {


  public RandomAccessFileEx(File file, String mode) throws FileNotFoundException {
    super(file, mode);
  }

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < 50; i++) {


    File file = new File("hello"+i+".txt");
   // String mode = sync ? "rwd" : "rw";

    ByteBuffer byteBuffer = ByteBuffer.allocate(1000000000);
    for (int j = 0; j < 10000000; j++) {
      byteBuffer.putChar((char)j);
    }
    byteBuffer.flip();


    try (RandomAccessFile  f = new RandomAccessFile(file, "rw")) {
      f.getChannel().write(byteBuffer);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    }
    System.out.println((System.currentTimeMillis()-startTime));
  }
}