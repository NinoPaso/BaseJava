package basejava.thread;

/*
 * 可重入锁的模拟
 */

public class LockTest01 {
	ReLock lock = new ReLock();
	public void a() throws InterruptedException {
		lock.lock();
		System.out.println(lock.getCount());
		doSomething();
		System.out.println(lock.getCount());
		lock.unLock();
		System.out.println(lock.getCount());
	}
	
	public void doSomething() throws InterruptedException {
		lock.lock();
		System.out.println(lock.getCount());
		lock.unLock();
	}
	
	public static void main(String[] args) throws InterruptedException {
		LockTest01 lockTest01 = new LockTest01();
		lockTest01.a();
		
		System.out.println(lockTest01.lock.getCount());
		
	}

}

class ReLock{
	//是否被占用的标识
	private boolean isLocked = false;
	//添加线程变量，获取获得锁的线程
	Thread lockedBy = null;
	//添加可重入锁的计数器
	private int count = 0;
	public int getCount() {
		return count;
	}
	//使用锁
	public synchronized void lock() throws InterruptedException {
		Thread t = Thread.currentThread();//获取当前变量
		while(isLocked && lockedBy!=t ) {
			wait();
		}	
		lockedBy = t;
		isLocked = true;
		count++;
	}
	//释放锁(当当前线程等于自身的时候，并且计数器等于0)
	public synchronized void unLock() {
		if(Thread.currentThread() == lockedBy) {
			count--;
			if(0 == count) {
				isLocked = false;
				notify();
				lockedBy = null;
			}
		}	
	}
}
