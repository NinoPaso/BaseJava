package basejava.thread;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * CAS实现线程安全的举例
 * atomic等实现原子性操作的类
 */
public class CASTest {
	private static AtomicInteger stock = new AtomicInteger(5);
	public static void main(String[] args) {
		for(int i=0;i<5;i++) {
			new Thread(()->{
				Integer left = stock.decrementAndGet();
				if(left<1) {
					System.out.println("抢完了。。。。。");
					return;
				}
				System.out.println(Thread.currentThread().getName()+"抢了一件商品,"+"还剩"+left);
				
			}).start();
		}
		
	}
}
