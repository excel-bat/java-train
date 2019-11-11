/**
 * Copyright (C) 2008-2019 All Rights Reserved.
 */


package io;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/**
 * NIO写类
 *
 * @author shanyingbo
 * @version $Id NIOWriter.java, v 0.1 2019-04-17 15:06 shanyingbo Exp $$
 */
public class NIOWriter {


    public static void main(String[] args) throws IOException {
      //  writeWithFileChannel();
        long startTime = System.nanoTime();

      //  writeBuffer();
       writeMapByteBuf2();
       //writeFileChannel();
        System.out.println("time:" + (System.nanoTime()-startTime));
    }

    static String fileName = "/Users/yingbo/tmp/writeFileDemo.txt";
    static String word2048 = "002434,353tlsjadfr,4355,asda1324asasfas,asdfas2348593u4kzc4598wtk slas024urjcmowJ Vknv njkm,dmwjfkv nJV KMMNjrvf dmnjRV Mnbj znjKJA C/ANVJ AFAJK NFkr navmf,mfjrka avmkr FAVNJ bkga GEAkefnmvfadvkr,fe,137863,353tlsjadfr,4355,asda1324asasfas,asdfas2348593u4kzc4598wtk slas024urjcmowJ Vknv njkm,dmwjfkv nJV KMMNjrvf dmnjRV Mnbj znjKJA C/ANVJ AFAJK NFkr navmf,mfjrka avmkr FAVNJ bkga GEA kefnmvfadvkr,fe,298754,353tlsjadfr,4355,asda1324asasfas,asdfas2348593u4kzc4598wtk slas024urjcmowJ Vknv njkm,dmwjfkv nJV KMMNjrvf dmnjRV Mnbj znjKJA C/ANVJ AFAJK NFkr navmf,mfjrka avmkr FAVNJ bkga GEA kefnmvfadvkr,fe,097845,353tlsjadfr,4355,asda1324asasfas,asdfas2348593u4kzc4598wtk slas024urjcmowJ Vknv njkm,dmwjfkv nJV KMMNjrvf dmnjRV Mnbj znjKJA C/ANVJ AFAJK NFkr navmf,mfjrka avmkr FAVNJ bkga GEA kefnmvfadvkr,fe,124853,353tlsjadfr,4355,asda1324asasfas,slas024urjcmowJ Vknv njkm,dmwjfkv nJV KMMNjrvf dmnjRV Mnbj znjKJA C/ANVJ AFAJK NFkr  kefnmvfadvkr,fe,908754,353tlsjadfr,4355,asda1324asasfas,asdfas2348593u4kzc4598wtk slas024urjcmowJ Vknv njkm,dmwjfkv nJV KMMNjrvf dmnjRV Mnbj znjKJA C/ANVJ AFAJK NFkr navmf,mfjrka avmkr FAVNJ bkga GEA kefnmvfadvkr,fe,098734,353tlsjadfr,4355,asda1324asasfas,asdfas2348593u4kzc4598wtk slas024urjcmowJ Vknv njkm,dmwjfkv nJV KMMNjrvf dmnjRV Mnbj znjKJA C/ANVJ AFAJK NFkrkefnmvfadvkr,fe,139087,353tlsjadfr,4355,asda1324asasfas,asdfas2348593u4kzc4598wtk slas024urjcmowJ Vknv njkm,dmwjfkv nJV KMMNjrvf dmnjRV Mnbj znjKJA C/ANVJ AFAJK NFkr  kefnmvfadvkr,fe,876532,353tlsjadfr,4355,asda1324asasfas,asdfas2348593u4kzc4598wtk slas024urjcmowJ Vknv njkm,dmwjfkv nJV KMMNjrvf dmnjRV Mnbj znjKJA C/ANVJ AFAJK NFkr navmf,mfjrka avmkr FAVNJ bkga GEA kefnmvfadvkr,fe,353213,353tlsjadfr,KMMNjrvf dmnjRV Mnbj znjKJA C/ANVJ AFAJK NFkr navmf,mfjrka avmkr FAVNJ bkga GEA kefnmvfadvkr,fe,096754,353tlsjadfr,4355,asda1324asasfas,asdfas2348593u4kzc4598wtk slas024urjcmowJ Vknv njkm,dmwjfkv nJV KMMNjrvf dmnjRV Mnbj znjKJA C/ANVJ AFAJK NFkr navmf,mfjrka avmkr FAVNJ bkga GEA kefnmvfadvkr,fe,aasl2l34353533424fvasvmelkwCNVJKLK2467898sdac ansfalfasfasdkk";
    static void writeFileWithBufferedWriter() throws IOException {
        Method[] methods = NIOWriter.class.getDeclaredMethods();
        String str = Arrays.toString(methods);
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(str);
        writer.close();
    }

    static void appendFileWithBufferedWriter() throws IOException {
        // FileWriter的第二个参数代表是否追加
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true));
        writer.append("追加信息");
        writer.close();
    }

    static void writeWithFileChannel() throws IOException {
        RandomAccessFile stream = new RandomAccessFile(fileName, "rw");
        FileChannel channel = stream.getChannel();

        String value = NIOWriter.class.getSimpleName();
        byte[] strBytes = value.getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
        buffer.put(strBytes);
        buffer.flip();
        channel.write(buffer);

        stream.close();
        channel.close();

    }

    static void writeBuffer() throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        int i = 1000000;
        while(i > 0) {
            //  word2048为字符串常量，刚好4800个字节
            writer.write(word2048);
            i --;
        }
        writer.close();
        fos.close();
    }


    static void writeMapByteBuf() throws IOException {
        //  必须采用RandomAccessFile，并且是rw模式
        RandomAccessFile acf = new RandomAccessFile(fileName, "rw");
        FileChannel fc = acf.getChannel();
        byte[] bs = word2048.getBytes();
        int len = bs.length ;
        int offset = 0;
        int totalNo =1000000;
        int i = 1000000;
        int buffSize = len*1024*500;
        MappedByteBuffer mbuf = fc.map(FileChannel.MapMode.READ_WRITE, offset, buffSize);
        int ScaleTimes = 0;
        int fisrtNo = 0;
        while(i > 0) {



               if(ScaleTimes == 0) {

                   fisrtNo = i;

                }
                if((totalNo/fisrtNo)<ScaleTimes) {

                    mbuf = fc.map(FileChannel.MapMode.READ_WRITE, offset, len * 1024 * 5);
                }else {
                    mbuf = fc.map(FileChannel.MapMode.READ_WRITE, offset, len );
                }

            mbuf.put(bs);
            offset = offset + len;

            i--;

        }
        fc.truncate(offset);
        fc.close() ;

    }

    static void writeMapByteBuf1() throws IOException {
        //  必须采用RandomAccessFile，并且是rw模式
        RandomAccessFile acf = new RandomAccessFile(fileName, "rw");
        FileChannel fc = acf.getChannel();
        byte[] bs = word2048.getBytes();
        int len = bs.length ;
        int offset = 0;

        int i = 5000000;
        int buffSize = len*1024*500;
        MappedByteBuffer mbuf = fc.map(FileChannel.MapMode.READ_WRITE, offset, buffSize);

        while(i > 0) {


            if(!mbuf.hasRemaining()) {

                mbuf = fc.map(FileChannel.MapMode.READ_WRITE, offset, len * 1024 * 5);
            }
            mbuf.put(bs);
            offset = offset + len;

            i--;
        }
        fc.truncate(offset);
        fc.close() ;

    }

    static void writeMapByteBuf2() throws IOException {
        //  必须采用RandomAccessFile，并且是rw模式
        BufferedRandomAccessFile bufferedRandomAccessFile = new BufferedRandomAccessFile(fileName, "rw");

        byte[] bs = word2048.getBytes();
        int i = 5000000;
        int offset = 0;
        int len = bs.length ;
        while(i > 0) {


          bufferedRandomAccessFile.write(bs,offset,len);
            offset = offset + len;

            i--;
        }


    }


}