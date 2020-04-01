package cn.basejava.gof.singleton;
/*
 * 懒汉式实现
 */
public class Demo02 {
	//私有化构造器
	private Demo02() {
	}
	//静态引用接收.不会立即加载，使用的时候再加载，实现懒加载
	private static Demo02 instance;
	//对外接口进行实现（需要加锁，防止并发，导致多例）。但是每次同步会导致效率比较低
	public static synchronized Demo02 getInstance() {
		if(instance == null) {
			instance = new Demo02();
		}
		return instance;
	}
}
