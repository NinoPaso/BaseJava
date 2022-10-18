package basejava.io;

import java.io.*;

/**
 * @ClassName FileUtils
 * @Description TODO
 * @Author 86133
 * @Date 2020/2/9 13:34
 * @Version 1.0
 **/
public class FileUtils {
    public static void main(String[] args) {
        copy("plane.png","plane_copy.png");
    }
    public static void copy(String srcPath,String destPath){
        File src = new File(srcPath);
        File dest = new File(destPath);
        InputStream is = null;
        OutputStream os = null;
        try{
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);
            byte[] flush = new byte[1024*10];
            int len = -1;
            while ((len = is.read(flush))!=-1){
                os.write(flush,0,len);
            }
        } catch(IOException e){
            e.printStackTrace();
        }finally {
            close(is,os);
        }
    }
    //可变参数的流关闭方法
    public static void close(Closeable... ios){
        for(Closeable io:ios){
            try {
                io.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
