package cn.basejava.gof.proxy.dynamicProxy;

public class RealStar implements Star{

	@Override
	public void confer() {
		// TODO Auto-generated method stub
		System.out.println("RealStar.confer()");
	}

	@Override
	public void signContract() {
		// TODO Auto-generated method stub
		System.out.println("RealStar.signContract()");
	}

	@Override
	public void bookTicket() {
		// TODO Auto-generated method stub
		System.out.println("RealStar.bookTicket()");
	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub
		System.out.println("RealStar.sing()");
	}

	@Override
	public void collectMoney() {
		// TODO Auto-generated method stub
		System.out.println("RealStar(周杰伦本人).collectMoney()");
	}

}
