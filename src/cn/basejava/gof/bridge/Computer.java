package cn.basejava.gof.bridge;

public interface Computer {
	void sale();
}

class DeskTop implements Computer{
	@Override
	public void sale() {
		// TODO Auto-generated method stub
		System.out.println("销售台式机");
	}	
}

class LapTop implements Computer{
	@Override
	public void sale() {
		// TODO Auto-generated method stub
		System.out.println("销售笔记本");
	}	
}

class Pad implements Computer{
	@Override
	public void sale() {
		// TODO Auto-generated method stub
		System.out.println("销售平板电脑");
	}	
}

class LenovoDesktop extends DeskTop{
	@Override
	public void sale() {
		// TODO Auto-generated method stub
		System.out.println("销售联想台式机");
	}
}

class LenovoLapTop extends LapTop{
	@Override
	public void sale() {
		// TODO Auto-generated method stub
		System.out.println("销售联想笔记本");
	}
}

class LenovoPad extends Pad{
	@Override
	public void sale() {
		// TODO Auto-generated method stub
		System.out.println("销售联想平板电脑");
	}
}