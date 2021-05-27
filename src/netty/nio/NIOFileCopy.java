package netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName NIOFileCopy
 * @Description TODO: 只通过一个Buffer实现文件的拷贝
 * 从文件中读取 通过Channel 写入缓冲区 从缓冲区读取 写入文件
 *
 * PS: 可以通过TransForm实现文件的快速拷贝
 * @Author 86133
 * @Date 2020/9/21 16:40
 * @Version 1.0
 **/
public class NIOFileCopy {
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("test.txt");
        FileChannel fileInputStreamChannel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("test1.txt");
        FileChannel outputStreamChannel = fileOutputStream.getChannel();

        // 定义缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        while (true) {
            byteBuffer.clear();
            int read = fileInputStreamChannel.read(byteBuffer);
            if (read == -1) {
                break;
            }
            byteBuffer.flip();
            outputStreamChannel.write(byteBuffer);
        }
        fileOutputStream.close();
        fileInputStream.close();
    }
}
