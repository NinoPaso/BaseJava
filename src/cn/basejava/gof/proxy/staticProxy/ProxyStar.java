package cn.basejava.gof.proxy.staticProxy;

public class ProxyStar implements Star{
	//定义真实的对象
	private Star star;
	
	public ProxyStar(Star star) {
		super();
		this.star = star;
	}

	@Override
	public void confer() {
		// TODO Auto-generated method stub
		System.out.println("ProxyStar.confer()");
	}

	@Override
	public void signContract() {
		// TODO Auto-generated method stub
		System.out.println("ProxyStar.signContract()");
	}

	@Override
	public void bookTicket() {
		// TODO Auto-generated method stub
		System.out.println("ProxyStar.bookTicket()");
	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub
		star.sing();
	}

	@Override
	public void collectMoney() {
		// TODO Auto-generated method stub
		System.out.println("ProxyStar.collectMoney()");
	}

}
