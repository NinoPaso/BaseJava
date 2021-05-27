package netty.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName NIOFileChannelTest
 * @Description TODO : 测试Channel功能.
 * 定义字符串，写入文件
 * @Author 86133
 * @Date 2020/9/21 16:09
 * @Version 1.0
 **/
public class NIOFileChannelTest {
    public static void main(String[] args) throws Exception{
        String str = "你好,hello!";
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\file1.txt");
        // 获取输出流对应的Channel
        FileChannel channel = fileOutputStream.getChannel();
        // 定义缓冲区 读取文件内容
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(str.getBytes());
        byteBuffer.flip();
        channel.write(byteBuffer);
        fileOutputStream.close();
    }
}
