//package basejava.thread;
//
///**
// * @ClassName TDownloader
// * @Description 线程下载图片实现
// * @Author 86133
// * @Date 2020/2/20 14:51
// * @Version 1.0
// **/
//public class TDownloader extends Thread {
//    private String url;//远程的下载路径
//    private String name;//文件保存名称
//
//    public TDownloader(String url, String name) {
//        this.url = url;
//        this.name = name;
//    }
//
//    @Override
//    public void run() {
//        WebDownloader wd = new WebDownloader();
//        wd.downloader(url,name);
//    }
//}
