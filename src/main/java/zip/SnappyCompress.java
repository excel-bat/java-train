/**
 * Copyright (C) 2008-2019 All Rights Reserved.
 */


package zip;

import com.google.common.io.Files;
import org.xerial.snappy.Snappy;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Snappy 压缩
 *
 * @author shanyingbo
 * @version $Id SnappyCompress.java, v 0.1 2019-01-14 2:23 PM shanyingbo Exp $$
 */
public class SnappyCompress {

  public static void main(String[] args) throws IOException {
    String input =  Files.toString(new File("/Users/shanyingbo/IdeaProjects/java-train/src/main/java/zip/source.json"),Charset.defaultCharset());
//    String input = "Hello snappy-java! Snappy-java is a JNI-based wrapper of "
//            + "Snappy, a fast compresser/decompresser.";
    System.out.println(input.length());
    byte[] compressed = Snappy.compress(input.getBytes("UTF-8"));
    System.out.println(compressed.length);
    byte[] uncompressed = Snappy.uncompress(compressed);

    String result = new String(uncompressed, "UTF-8");
    System.out.println(result);
  }


}