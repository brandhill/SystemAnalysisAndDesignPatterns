package ParkingLotDesign;

public abstract class Spot {
	Level Level;
	int number;
	boolean isAvaliable;
	public Spot(Level level, int number, boolean isAvaliable) {
		this.Level = level;
		this.number = number;
		this.isAvaliable = isAvaliable;
	}
	
}

class MotorCycleSpots extends Spot{
	public MotorCycleSpots(Level level, int number, boolean isAvaliable) {
		super(level, number, isAvaliable);
	}
	
}

class CompactSpots extends Spot{
	public CompactSpots(Level level, int number, boolean isAvaliable) {
		super(level, number, isAvaliable);
	}
}

class LargeSpots extends Spot{
	public LargeSpots(Level level, int number, boolean isAvaliable) {
		super(level, number, isAvaliable);
	}
}


