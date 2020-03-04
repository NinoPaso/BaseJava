package collection;

/**
 * @author Administrator
 * 自定义实现arraylist体会底层原理
 */
public class WyjArrayList<E> {
	//步骤:1.定义Object[]2.定义数组长度 3.定义构造方法
	private Object[] elementData;
	private int size;
	
	//定义默认长度变量
	private static final int DEFAULT_CAPACITY = 10;
	//构造函数
	public WyjArrayList() {
		elementData = new Object[DEFAULT_CAPACITY];
	}
	public WyjArrayList(int capacity) {
		if(capacity<0) {
			throw new RuntimeException("集合长度不能小于0");
		}else if(capacity == 0) {
			elementData = new Object[DEFAULT_CAPACITY];			
		}else {
			elementData = new Object[capacity];
		}
	}
	//定义add方法
	public void add(E e) {
		//扩容实现
		if(elementData.length == size) {
			Object[] newArray = new Object[elementData.length+(elementData.length>>1)];
			//严肃拷贝
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			elementData = newArray;
		}
		elementData[size++] = e;
	}
	public E get(int index) {
		indexRange(index);
		return (E)elementData[index];
	}
	public void set(E e,int index) {
		indexRange(index);
		elementData[index] = e;
	}
	//重写toString方法
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i=0;i<size;i++) {
			sb.append(elementData[i]+",");
		}
		sb.setCharAt(sb.length()-1,']');
		return sb.toString();
	}
	//定义索引判断
	public void indexRange(int index) {
		if(index<0 || index>=size) {
			throw new RuntimeException("索引不合法");
		}
	}
	//定义remove方法
	public void remove(E e) {
		for(int i=0;i<size;i++) {
			if(elementData[i].equals(e)) {
				remove(i);
			}
		}
	}
	public void remove(int index) {
		//定义从index起的数组复制长度
		int length = elementData.length-index-1;
		if(length>0) {
			//复制数组
			System.arraycopy(elementData, index+1,elementData, index, length);
		}
		elementData[--size] = null;
		
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0?true:false;
	}
	public static void main(String[] args) {
		WyjArrayList<String> list = new WyjArrayList<String>();
		String a = "A";
		list.add(a);
		list.add(a);
		for(int i=0;i<100;i++) {
			list.add(a);
		}
		list.set("B", 2);
		System.out.println(list);
		list.remove(2);
		System.out.println(list);
		System.out.println(list.size);
		System.out.println(list.isEmpty());

	}
}