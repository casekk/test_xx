package Test.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("tcp���������");
        ServerSocket serverSocket = new ServerSocket(8080);

        //�ͻ������û�����ӣ���������
        Socket accept = serverSocket.accept();

        InputStream inputStream = accept.getInputStream();

        byte[]bytes = new byte[1024];

        int length = inputStream.read(bytes);
        
        String result = new String(bytes,0,length);

        System.out.println("����˽��ܵ��ͻ��˵���Ϣ��"+result);


        OutputStream outputStream = accept.getOutputStream();

        PrintWriter printWriter = new PrintWriter(outputStream);

        printWriter.print("���Ƿ����������յ������Ϣ�����Ƿ������Զ�����");

        printWriter.flush();

        accept.shutdownOutput();
    }
}
