package basejava.net.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName Server
 * @Description TODO:
 * 熟悉流程：创建服务器
 * 1.指定端口， 使用serverSocket创建服务器
 * 2.阻塞式等待连接：accept
 * 3.操作：输入输出流操作
 * 4.释放资源
 * @Author 86133
 * @Date 2020/3/12 22:49
 * @Version 1.0
 **/
public class Server {
    public static void main(String[] args) throws IOException {
        //1.指定端口， 使用serverSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        // 2.阻塞式等待连接：accept
        Socket socket = server.accept();
        System.out.println("一个客户端建立了连接");
        // 3.操作：输入输出流操作
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String data = dis.readUTF();
        System.out.println(data);
        // 4.释放资源
        dis.close();
        socket.close();

    }
}
