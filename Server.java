package Test.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("tcp服务端启动");
        ServerSocket serverSocket = new ServerSocket(8080);

        //客户端如果没有连接，阻塞这里
        Socket accept = serverSocket.accept();

        InputStream inputStream = accept.getInputStream();

        byte[]bytes = new byte[1024];

        int length = inputStream.read(bytes);
        
        String result = new String(bytes,0,length);

        System.out.println("服务端接受到客户端的消息："+result);


        OutputStream outputStream = accept.getOutputStream();

        PrintWriter printWriter = new PrintWriter(outputStream);

        printWriter.print("我是服务器，我收到你的消息，这是服务器自动反馈");

        printWriter.flush();

        accept.shutdownOutput();
    }
}
