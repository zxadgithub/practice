package com.zxa.custom.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Classname ServerUtils
 * @Date 2020/9/27 7:25 下午
 * @Created by zhangxinan
 */
public class ServerUtils {

    public static void main(String[] args) throws IOException {
        accept();
    }

    private static void accept() throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress(80));

        while (true) {
            SocketChannel accept = socketChannel.accept();
            String msg = "";
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while(accept.read(buffer) > 0)
            {
                buffer.flip();
                while(buffer.hasRemaining())
                    msg += new String(buffer.get(new byte[buffer.limit()]).array());
                buffer.clear();
                System.err.println("收到客户端消息:"+msg);
                buffer.flip();
                buffer.put(("你也" + msg).getBytes());
                accept.write(buffer);
                msg = "";
            }



        }

    }

}
