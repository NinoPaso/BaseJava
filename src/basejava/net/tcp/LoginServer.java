package basejava.net.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName Server
 * @Description TODO:
 * 熟悉流程：创建服务器(模拟登录) 单向
 * 1.指定端口， 使用serverSocket创建服务器
 * 2.阻塞式等待连接：accept
 * 3.操作：输入输出流操作
 * 4.释放资源
 * @Author 86133
 * @Date 2020/3/12 22:49
 * @Version 1.0
 **/
public class LoginServer {
    public static void main(String[] args) throws IOException {
        //1.指定端口， 使用serverSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        // 2.阻塞式等待连接：accept
        Socket socket = server.accept();
        System.out.println("一个客户端建立了连接");
        String name = "";
        String pw = "";
        // 3.操作：输入输出流操作
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String data = dis.readUTF();
        String[] dataArray = data.split("&");
        for(String info:dataArray){
            String[] userInfo = info.split("=");
            if("userName".equals(userInfo[0])){
                System.out.println("你的用户名为："+userInfo[1]);
                name = userInfo[1];
            }else if("userPassword".equals(userInfo[0])){
                System.out.println("你的密码为："+userInfo[1]);
                pw = userInfo[1];
            }
        }
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        if("123".equals(name) && "123".equals((pw))){
            dos.writeUTF("登录成功");
        }else{
            dos.writeUTF("登录失败");
        }
        dos.flush();
        // 4.释放资
        dis.close();
        socket.close();

    }
}
