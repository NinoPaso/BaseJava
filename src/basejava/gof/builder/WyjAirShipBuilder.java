package basejava.gof.builder;

public class WyjAirShipBuilder implements AirShipBuilder{
	@Override
	public Engine builderEngine() {
		// TODO Auto-generated method stub
		System.out.println("构建王牌发动机");
		return new Engine("王牌发动机");
	}
	@Override
	public EscapeTower builderEscapeTower() {
		// TODO Auto-generated method stub
		System.out.println("构建王牌逃逸塔");
		return new EscapeTower("王牌逃逸塔");
	}
	@Override
	public OrbitalModule builderOrbitalModule() {
		// TODO Auto-generated method stub
		System.out.println("构建王牌轨道舱");
		return new OrbitalModule("王牌轨道舱");
	}
}
