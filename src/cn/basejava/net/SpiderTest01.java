package cn.basejava.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @ClassName SpiderTest01
 * @Description TODO
 * @Author 86133
 * @Date 2020/3/8 22:42
 * @Version 1.0
 **/
public class SpiderTest01 {
    public static void main(String[] args) throws Exception {
        //获取URL
        URL url = new URL("https://www.jd.com");
        //下载资源
        InputStream is = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
        String msg = null;
        while(null != (msg=br.readLine())){
            System.out.println(msg);
        }
        //分析
        //处理
    }
}
