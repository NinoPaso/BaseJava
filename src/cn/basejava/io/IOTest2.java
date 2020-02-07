package cn.basejava.io;

import java.io.*;

public class IOTest2 {
    /* outputStream
    1.创建源
    2.选择流
     */
    public static void main(String[] args) {
        //此处文件相对路径和项目目录同级，否则使用绝对路径
        File dest = new File("testOut.txt");
        OutputStream os = null;
        try {
            os = new FileOutputStream(dest);
            String msg = "IO is so easy";
            byte[] datas = msg.getBytes();
            os.write(datas);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null!=os){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
