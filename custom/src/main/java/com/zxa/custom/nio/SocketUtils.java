package com.zxa.custom.nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * @Classname SocketUtils
 * @Date 2020/9/27 7:15 下午
 * @Created by zhangxinan
 */
public class SocketUtils {

    public static void main(String[] args) throws IOException {
        open("127.0.0.1", 80);
    }

    public static void open(String ip, Integer port) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(ip, port));
        while (socketChannel.isConnected()){
            ByteBuffer buf = ByteBuffer.allocate(1024);
            buf.clear();
            Scanner s = new Scanner(System.in);
            buf.put(s.next().getBytes());
            buf.flip();
            while(buf.hasRemaining()) {
                socketChannel.write(buf);
            };
        }
        socketChannel.close();
    }

}
