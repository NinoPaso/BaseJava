//package basejava.thread;
//
//
//import org.apache.commons.io.FileUtils;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URL;
//
///**
// * @ClassName WebDownloader
// * @Description TODO图片下载
// * @Author 86133
// * @Date 2020/2/20 14:33
// * @Version 1.0
// **/
//public class WebDownloader {
//    public void downloader(String url,String name){
//        try {
//            FileUtils.copyURLToFile(new URL(url),new File(name));
//        } catch(MalformedURLException e){
//            e.printStackTrace();
//            System.out.println("URL不合法");
//        } catch(IOException e) {
//            e.printStackTrace();
//            System.out.println("图片下载失败！");
//        }
//    }
//
//}
