package basejava.java8.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Test01
 * @Description TODO: Stream测试
 * @Author 86133
 * @Date 2020/9/22 14:52
 * @Version 1.0
 **/
public class Test01 {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        strList.add("123");
        strList.add("123");
        strList.add("123");
        strList.add("123");
        strList.stream().forEach(System.out::println);
    }
}
