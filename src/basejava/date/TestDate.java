package basejava.date;

import java.util.*;

public class TestDate {
    public static void main(String[] args) throws Exception{
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");

        for(String str: stringList) {
            System.out.println(str);
            stringList.remove(stringList.get(3));
        }
    }
}
