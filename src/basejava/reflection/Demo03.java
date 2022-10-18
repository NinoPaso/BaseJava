package basejava.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import basejava.annotation.Student;

/*
 * 通过反射API调用构造方法，构造对象
 */
public class Demo03 {
	public static void main(String[] args) {
		String path = "basejava.annotation.Student";
		try {
			Class<Student> clazz = (Class<Student>) Class.forName(path);
			Student s = clazz.newInstance();
			//通过有参构造器进行调用
			Constructor<Student> c = clazz.getDeclaredConstructor(int.class,String.class,int.class);
			Student ss = c.newInstance(100,"wang",100);
			System.out.println(ss.getName());
			//通过发射的API动态的调用我们的普通方法
			Method method = clazz.getDeclaredMethod("setName", String.class);
			method.invoke(s, "wangs");//s.setName("wangs");
			System.out.println(s.getName());
			//通过反射API操作属性
			Field f = clazz.getDeclaredField("name");
			f.setAccessible(true);
			f.set(s, "wangyangjun");
			f.get(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
