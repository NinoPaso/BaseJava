package cn.basejava.gof.builder;

public class WyjAirShipDirector implements AirShipDirector{
	
	private AirShipBuilder builder;
	
	public WyjAirShipDirector(AirShipBuilder builder) {
		super();
		this.builder = builder;
	}

	@Override
	public AirShip directAirShip() {
		// TODO Auto-generated method stub
		Engine e = builder.builderEngine();
		EscapeTower t = builder.builderEscapeTower();
		OrbitalModule o = builder.builderOrbitalModule();
		AirShip a = new AirShip();
		a.setEngine(e);
		a.setEscapeTower(t);
		a.setOrbitalModule(o);
		return a;
	}
}
