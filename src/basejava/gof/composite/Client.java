package basejava.gof.composite;

public class Client {
	public static void main(String[] args) {
		AbstractFile f1,f2;
		f1 = new ImageFile("wangyangjun.jpg");
		f2 = new ImageFile("wangyangjun1.jpg");
		Folder f3 = new Folder("文件夹1");
		f3.add(f2);
		f3.add(f1);
		f3.add(f3); 
		f3.killVirus();
	}
}
