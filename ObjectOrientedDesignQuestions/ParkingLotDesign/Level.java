package ParkingLotDesign;

import java.util.ArrayList;
import java.util.List;

public class Level {
	// level and row form a primary key
	int level;
	char row;
	List<MotorCycleSpots> motorCycleSpots;
	List<CompactSpots> compactSpots;
	List<LargeSpots> largeSpots;
	int avaliablemotorCycleSpots;
	int avaliablecompactSpots;
	int avaliablelargeSpots;
	public Level(int level, char row) {
		this.level = level;
		this.row = row;
		this.motorCycleSpots = new  ArrayList<MotorCycleSpots>();
		this.compactSpots = new ArrayList<CompactSpots>();
		this.largeSpots = new ArrayList<LargeSpots>();
	}
	
	public void addMotorCycleSpots(MotorCycleSpots spot) {
		motorCycleSpots.add(spot);
		spot.Level = this;
		this.avaliablemotorCycleSpots++;
	}
	public void addCompactSpots(CompactSpots spot) {
		compactSpots.add(spot);
		spot.Level = this;
		this.avaliablecompactSpots++;
	}
	public void addLargeSpots(LargeSpots spot) {
		largeSpots.add(spot);
		spot.Level = this;
		this.avaliablelargeSpots++;
	}
	
}
