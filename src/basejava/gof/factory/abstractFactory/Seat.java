package basejava.gof.factory.abstractFactory;

public interface Seat {
	void massage();
}

class LuxurySeat implements Seat{
	@Override
	public void massage() {
		// TODO Auto-generated method stub
		System.out.println("自带按摩功能！");
	}
}

class LowSeat implements Seat{
	@Override
	public void massage() {
		// TODO Auto-generated method stub
		System.out.println("没有按摩功能！");
	}
}