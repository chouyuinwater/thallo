package com.fish.socket;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;

/**
 * @author jiangbing
 * @date 2021/3/15 19:21
 * notes and tips:
 */
public class SocketChannelClient {
    private static final int DEFAULT_PORT = 8899;
    private static final String DEFAULT_IP = "127.0.0.1";

    private static SocketChannel client;
    private static Selector selector;
    private static final ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private static final ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
    private static final Charset charset = StandardCharsets.UTF_8;

    public static void main(String[] args) {
        SocketChannelClient socketChannelClient = new SocketChannelClient();
        socketChannelClient.start();
    }


    private void start() {
        try {
            // create open server
            client = SocketChannel.open();
            // non blocking set
            client.configureBlocking(false);
            // create selector
            selector = Selector.open();
            client.register(selector, SelectionKey.OP_CONNECT);
            client.connect(new InetSocketAddress(DEFAULT_IP, DEFAULT_PORT));

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
        }
    }

    private void handle(SelectionKey key) throws IOException {
        if (key.isConnectable()) {
            SocketChannel client = (SocketChannel) key.channel();
            // if connecting finish connect
            if (client.isConnectionPending()) {
                client.finishConnect();
                new Thread(() -> {
                    while (true) {
                        try {
                            String inputMessage = new BufferedReader(new InputStreamReader(System.in)).readLine();
                            if (StringUtils.isBlank(inputMessage)) {
                                return;
                            }
                            writeBuffer.clear();
                            writeBuffer.put(charset.encode(inputMessage));
                            writeBuffer.flip();
                            while (writeBuffer.hasRemaining()) {
                                client.write(writeBuffer);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }).start();

            }
        }

        if (key.isReadable()) {
            SocketChannel client = (SocketChannel) key.channel();
            System.out.println("client: " + client.equals(this.client));
            StringBuilder messageBuffer = new StringBuilder();
            readBuffer.clear();
            while (client.read(readBuffer) > 0)
            readBuffer.flip();
            messageBuffer.append(charset.decode(readBuffer));
            String message = messageBuffer.toString();
            if (StringUtils.isBlank(message)) {
                selector.close();
            }
        }
    }
}
