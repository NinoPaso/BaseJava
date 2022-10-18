package basejava.io;

import java.io.*;

/**
 * @ClassName IOTest4（对象流测试，即序列化对象测试）
 * @Description TODO
 * @Author 86133
 * @Date 2020/2/15 14:23
 * @Version 1.0
 **/
public class IOTest4{
    public static void main(String[] args) {
        ObjectOutputStream oos = null;
        {
            try {
                oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("a.ser")));
                oos.writeObject(new Person("王泱钧",20000.0));
                oos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

class Person implements Serializable{

    private String name;
    private double salary;

    public Person(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}
