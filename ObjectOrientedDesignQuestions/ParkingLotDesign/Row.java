package ParkingLotDesign;

import java.util.ArrayList;
import java.util.List;

public class Row {
	char row;
	MotorCycleSpots[] motorCycleSpots;
	CompactSpots[] compactSpots;
	LargeSpots[] largeSpots;
	int avaliablemotorCycleSpots;
	int avaliablecompactSpots;
	int avaliablelargeSpots;
	public Row(char row, int motorCycleSpots, int compactSpots, int largeSpots) {
		this.row = row;
		this.motorCycleSpots = new  MotorCycleSpots[motorCycleSpots];
		this.compactSpots = new CompactSpots[compactSpots];
		this.largeSpots = new LargeSpots[largeSpots];
		this.avaliablemotorCycleSpots = motorCycleSpots;
		this.avaliablecompactSpots = compactSpots;
		this.avaliablelargeSpots = largeSpots;
	}
	
	
}
