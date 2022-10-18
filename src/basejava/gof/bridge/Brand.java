package basejava.gof.bridge;

public interface Brand {
	void sale();
}

class Lenovo implements Brand{

	@Override
	public void sale() {
		// TODO Auto-generated method stub
		System.out.println("销售联想电脑");
	}
	
}

class Dell implements Brand{

	@Override
	public void sale() {
		// TODO Auto-generated method stub
		System.out.println("销售Dell电脑");
	}
	
}