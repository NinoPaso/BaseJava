package basejava.gof.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/*
 * 反序列化实现对象的深复制
 */
public class Client2 {
	public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
		Sheep s1 = new Sheep("羊1",new Date(9423048329041023L));
		System.out.println(s1.getBirthday());
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(s1);
		byte[] bytes = bos.toByteArray();
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bis);
		s1.setBirthday(new Date(10293812038120L));
		System.out.println(s1.getBirthday());
		Sheep s2 = (Sheep) ois.readObject();
		System.out.println(s2.getBirthday());
	}
}
