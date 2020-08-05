package cn.basejava.thread.POOL;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestPool {

}

// 定义线程池
class ThreadPool {
	// 1.首先会获取任务队列对象
	private BlockingQueue<Runnable> queue;
	// 2.线程集合
	private HashSet<Worker> works = new HashSet<>();
	// 3.定义核心的线程数
	private int coreSize;
	// 4.定义获取任务的超时时间
	private long timeout;
	// 5.定义线程的获取时间的单位
	private TimeUnit unit;
	
	// 构造方法进行线程池定义
	public ThreadPool(int coreSize, long timeout, TimeUnit unit, int queueCapcity) {
		super();
		this.coreSize = coreSize;
		this.timeout = timeout;
		this.unit = unit;
		this.queue = new BlockingQueue<>(queueCapcity);
	}
	
	// 定义线程池开启任务执行的方法
	public void execute(Runnable task) {
		// 首先进行判断任务数量是否超过 coreSize 如果没有直接交给Worker进行执行
		// 如果超过   放入阻塞队列  等待执行
		synchronized (works) {
			if (works.size() < coreSize) {
				Worker work = new Worker(task);
				works.add(work);
				work.start();
			} else {
				queue.put(task);
			}
		}
	}
	
	class Worker extends Thread{
		private Runnable task;
		
		public Worker(Runnable task) {
			this.task = task;
		}
		
		@Override
		public void run() {
			// 进行任务判断  首先执行当前的任务  再去阻塞队列中进行获取执行
			while (null != task || (task = queue.take()) != null) {
				try {
					task.run();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					// TODO: handle finally clause
					task = null;
				}
			}
			
			synchronized (works) {
				works.remove(this);
			}
		}
		
	}
	
}

// 定义任务队列
class BlockingQueue<T> {
	// 1. 定义双向链表存储任务
	private Deque<T> deque = new ArrayDeque<>();
	// 2. 定义锁对象-- 保证任务消费的线程安全
	private ReentrantLock lock = new ReentrantLock();
	// 3. 定义生产者和消费者的阻塞变量  进行线程阻塞和唤醒
	private Condition fullWaitSet = lock.newCondition();
	private Condition emptyWaitSet = lock.newCondition();
	// 4. 定义队列的容量
	private int capcity;
	
	
	
	
	public BlockingQueue(int capcity) {
		super();
		this.capcity = capcity;
	}

	// 定义带超时时间的阻塞获取方法
	public T poll (long timeout, TimeUnit unit) {
		lock.lock();
		try {
			// 将等待时间进行统一
			long nanos = unit.toNanos(timeout);
			while (deque.isEmpty()) {
				try {
					if (nanos <= 0) {
						return null;
					}
					nanos = emptyWaitSet.awaitNanos(nanos);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
			}
			T t = deque.removeFirst();
			// 唤醒添加任务的线程
			fullWaitSet.signal();
			return t;
		} finally {
			lock.unlock();
			// TODO: handle finally clause
		}
	}
	
	// 定义获取任务的方法（阻塞获取）
	public T take() {
		lock.lock();
		try {
			while (deque.isEmpty()) {
				try {
					emptyWaitSet.await();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
			}
			T t = deque.removeFirst();
			// 唤醒添加任务的线程
			fullWaitSet.signal();
			return t;
		} finally {
			lock.unlock();
			// TODO: handle finally clause
		}
	}
	
	// 定义生产任务的方法(阻塞添加)
	public void put(T t) {
		lock.lock();
		try {
			while (deque.size() == capcity) {
				try {
					fullWaitSet.await();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
			}
			deque.addFirst(t);
			// 唤醒获取任务线程
			emptyWaitSet.signal();
		} finally {
			lock.unlock();
			// TODO: handle finally clause
		}
	}
	
	// 定义返回队列的大小
	public int size() {
		lock.lock();
		try {
			return deque.size();
		} finally {
			// TODO: handle exception
			lock.unlock();
		}
	}
}
