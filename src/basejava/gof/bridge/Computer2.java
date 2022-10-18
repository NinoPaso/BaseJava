package basejava.gof.bridge;

class Computer2 {
	protected Brand brand;
	
	public Computer2(Brand b) {
		this.brand = b;
	}
	
	public void sale() {
		brand.sale();
	}
}

class Desktop2 extends Computer2{

	public Desktop2(Brand b) {
		super(b);
		// TODO Auto-generated constructor stub
	}
	public void sale() {
		super.sale();
		System.out.println("销售台式机");
	}
}
