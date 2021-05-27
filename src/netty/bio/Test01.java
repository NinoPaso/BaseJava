package netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName Test01
 * @Description TODO：创建socket服务端
 *              1. 创建线程池 支持多客户端调用 2. 创建socket
 * @Author 86133
 * @Date 2020/9/21 10:50
 * @Version 1.0
 **/
public class Test01 {
    public static void main(String[] args) throws Exception{
        // 创建线程池
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        // 创建ServerSocket
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务端启动了...");
        // 循环监听连接
        while (true) {
            final Socket socket = serverSocket.accept();
            System.out.println("提示：创建了一个客户端连接...");
            // 处理socket程序
            newCachedThreadPool.execute(()->{
                handler(socket);
            });
        }
    }

    // 定义socket处理方法
    public static void handler(Socket socket) {
        // 创建读取流内容的缓存块
        byte[] bytes = new byte[1024];
        // 通过输入流进行流内容读取
        try {
            // 获取当前线程的信息  验证BIO模型的阻塞 同步
            System.out.println("线程信息为：" + Thread.currentThread().getId() + Thread.currentThread().getName());
            InputStream inputStream = socket.getInputStream();
            while (true) {
                System.out.println("线程信息为：" + Thread.currentThread().getId() + Thread.currentThread().getName());
                int read = inputStream.read(bytes);
                if (read != -1) {
                    System.out.println(new String(bytes, 0 , read));
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("关闭客户端的连接...");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
