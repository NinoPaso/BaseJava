package oop;

/**
 * @author Administrator
 *	��̬�ڲ���
 */
public class TestInnerClass {
	public static void main(String[] args) {
		//�����ڲ������
		Outer.Inner inner = new Outer().new Inner();
		inner.show();
		Outer outer = new Outer();
		outer.testOuter();
	}
}

class Outer {
	private int age = 10;
	
	public void testOuter() {
		System.out.println("testOuter");
//		System.out.println(new Inner().age);
	}
	//�Ǿ�̬�ڲ���
	class Inner {
//		private int age = 20;
		public void show() {
			System.out.println("�����ⲿ������ԣ�age:" + age);
		}
		
	}
	
}
