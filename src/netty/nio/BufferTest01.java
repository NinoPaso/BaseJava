package netty.nio;

import java.nio.IntBuffer;

/**
 * @ClassName BufferTest01
 * @Description TODO
 * @Author 86133
 * @Date 2020/9/21 13:42
 * @Version 1.0
 **/
public class BufferTest01 {
    public static void main(String[] args) {
        // 创建Buffer
        IntBuffer intBuffer = IntBuffer.allocate(5);

        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 2);
        }
        // 操作buffer的时候进行读写的切换
        intBuffer.flip();

        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}
