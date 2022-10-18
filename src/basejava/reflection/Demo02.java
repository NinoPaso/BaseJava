package basejava.reflection;

import java.lang.reflect.*;

/*
 * 利用反射的API获取类的信息（类名，属性，构造器，方法）
 */
public class Demo02 {
	public static void main(String[] args) {
		String path = "basejava.annotation.Student";
		try {
			Class<?> clazz = Class.forName(path);
			//获取类名
			System.out.println(clazz.getName());//类的全新定列名
			System.out.println(clazz.getSimpleName());//类名
			//获取属性信息
			Field[] fields = clazz.getFields();//获取public修饰的属性
			System.out.println(fields.length);
			Field[] fieldAll = clazz.getDeclaredFields();//获取全部属性
			for(Field field:fieldAll) {
				System.out.println(field);
			}
			//获取方法信息
			Method[] ms = clazz.getDeclaredMethods();
			Method m1 = clazz.getDeclaredMethod("setName", String.class);
			//获取构造器信息
			Constructor[] cs = clazz.getDeclaredConstructors();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
