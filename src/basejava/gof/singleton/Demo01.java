package basejava.gof.singleton;
/*
 * 饿汉单例模式
 */
public class Demo01 {
	//定义静态变量（final）:饿汉模式，不管是否需要，都是立即加载。
	private static  Demo01 instance = new Demo01(); 
	//私有构造器
	private Demo01() {
	}
	//公有化的入口
	public static Demo01 getInstance() {
		return instance;
	}
}
