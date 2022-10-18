package basejava.gof.factory.abstractFactory;

public interface Tyre {
	void revolve();
}

class LuxuryTyre implements Tyre{
	@Override
	public void revolve() {
		// TODO Auto-generated method stub
		System.out.println("轮胎旋转不磨损");
	}
}

class LowTyre implements Tyre{
	@Override
	public void revolve() {
		// TODO Auto-generated method stub
		System.out.println("轮胎旋转磨损快");
	}
}