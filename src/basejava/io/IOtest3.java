package basejava.io;

import java.io.*;

/*
   通过字节数组流进行图片读写
 */
public class IOtest3 {
    public static void main(String[] args) {
        byte[] datas = fileToByteArray("E:\\idea\\idea+\\workspace\\BaseJava\\src\\images\\plane.png");
        System.out.println(datas.length);
    }
    /*
    从图片写入到字节数组:1.图片到程序字节输入流2.程序字节输入流到字节数组
     */
    public static byte[] fileToByteArray(String path){
        File src = new File(path);
        //选择流
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            is = new FileInputStream(src);
            baos = new ByteArrayOutputStream();
            //进行操作
            byte[] flush = new byte[1024*20];//定义字节缓冲区
            int len = -1;//定义接收长度
            while((len=is.read(flush))!=-1){
                baos.write(flush,0,len);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(null!=is){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
