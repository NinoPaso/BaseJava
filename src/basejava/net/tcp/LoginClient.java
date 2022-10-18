package basejava.net.tcp;

import java.io.*;
import java.net.Socket;

/**
 * @ClassName Server
 * @Description TODO:
 * 模拟登录（单项）
 * 熟悉流程：创建客户端
 * 1.建立连接：使用Socket创建客户端+加上服务端的地址端口
 * 2.操作：输入输出流操作
 * 3.释放资源
 * @Author 86133
 * @Date 2020/3/12 22:49
 * @Version 1.0
 **/
public class LoginClient {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名称：");
        String userName = br.readLine();
        System.out.println("请输入密码：");
        String userPassword = br.readLine();

        //1.建立连接：使用Socket创建客户端+加上服务端的地址端口
        Socket client = new Socket("localhost",8888);
        // 2.操作：输入输出流操作
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("userName="+userName+"&"+"userPassword="+userPassword);
        dos.flush();
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String result = dis.readUTF();
        System.out.println(result);
        // 3.释放资源

        dos.close();
        client.close();
    }
}
