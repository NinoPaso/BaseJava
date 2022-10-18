package basejava.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOTest {
    /*
    1.创建源
    2.选择流
     */
    public static void main(String[] args) {
        //此处文件相对路径和项目目录同级，否则使用绝对路径
        File src = new File("test.txt");
        InputStream is = null;
        try {
            is = new FileInputStream(src);
            int temp;
            while((temp=is.read())!=-1){
                System.out.println((char)temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(null!=is){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
