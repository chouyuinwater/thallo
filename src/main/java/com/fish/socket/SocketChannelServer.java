package com.fish.socket;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;

/**
 * @author jiangbing
 * @date 2021/3/15 19:21
 * notes and tips:
 */
public class SocketChannelServer {
    private static final int DEFAULT_PORT = 8899;

    private static ServerSocketChannel server;
    private static Selector selector;
    private static final ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private static final ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
    private static final Charset charset = StandardCharsets.UTF_8;

    public static void main(String[] args) {
        SocketChannelServer socketChannelServer = new SocketChannelServer();
        socketChannelServer.start();
    }


    private void start() {
        try {
            // create open server
            server = ServerSocketChannel.open();
            // non blocking set
            server.configureBlocking(false);
            // server socket bind port
            server.socket().bind(new InetSocketAddress(DEFAULT_PORT));
            // create selector
            selector = Selector.open();
            // register and monitor server socket channel event accept
            server.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                // check trigger event
                selector.select();
                // get trigger event
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                for (SelectionKey key : selectionKeys) {
                    // deal event
                    handle(key);
                }
                // delete trigger event
                selectionKeys.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // close channel and selector
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handle(SelectionKey selectionKey) throws IOException {
        // create client connect
        if (selectionKey.isAcceptable()) {
            try {
                ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                System.out.println("server: " + serverSocketChannel.equals(this.server));
                SocketChannel client = serverSocketChannel.accept();
                client.configureBlocking(false);
                // register read event after accept event
                client.register(selector, SelectionKey.OP_READ);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (selectionKey.isReadable()) {
            SocketChannel client = (SocketChannel) selectionKey.channel();
            StringBuilder messageBuffer = new StringBuilder();
            readBuffer.clear();
            while (client.read(readBuffer) > 0)
            readBuffer.flip();
            messageBuffer.append(charset.decode(readBuffer));
            String message = messageBuffer.toString();
            System.out.println("message = " + message);

            if (StringUtils.isBlank(message)) {
                // client null error
                // cancel event
                selectionKey.cancel();
                // refresh register event
                selector.wakeup();
            } else {
                // write message
                Set<SelectionKey> selectionKeys = selector.keys();
                for (SelectionKey key : selectionKeys) {
                    Channel channel = key.channel();
                    if (channel instanceof ServerSocketChannel) {
                        continue;
                    }
                    if (!key.isValid() || key.equals(client)) {
                        continue;
                    }
                    writeBuffer.clear();
                    writeBuffer.put(charset.encode(message));
                    while (writeBuffer.hasRemaining()) {
                        client.write(writeBuffer);
                    }
                }
            }
        }
        // read
    }


}
