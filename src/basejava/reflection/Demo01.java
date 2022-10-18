package basejava.reflection;

/*
 * 测试java.lang.Class对象的获取方式
 */
public class Demo01 {
	public static void main(String[] args) {
		String path = "basejava.annotation.Student";
		try {
			Class<?> clazz = Class.forName(path);
			System.out.println(clazz.hashCode());
			Class<?> clazz2 = Class.forName(path);
			System.out.println(clazz2.hashCode());
			
			Class strClazz = String.class;
			Class strClazz2 = path.getClass();
			System.out.println(strClazz == strClazz2);
			
			int[] arr01 = new int[10];
			int[] arr02 = new int[30];
			int[][] arr03 = new int[10][10];
			System.out.println(arr01.getClass().hashCode());
			System.out.println(arr02.getClass().hashCode());
			System.out.println(arr03.getClass().hashCode());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
