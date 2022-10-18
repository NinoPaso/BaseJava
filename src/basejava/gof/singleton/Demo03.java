package basejava.gof.singleton;
/*
 * 静态内部类的实现方式
 */
public class Demo03 {
	//私有构造器
	private Demo03() {
		
	}
	//公开入口
	public static Demo03 getInstance() {
		return SingletonClassinstance.instance;
	}
	public static class SingletonClassinstance{
		private static final Demo03 instance = new Demo03();
	}
}
