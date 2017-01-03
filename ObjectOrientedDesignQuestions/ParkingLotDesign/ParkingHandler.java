package ParkingLotDesign;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class ParkingHandler {
	private static ParkingHandler handler = null;
	private Stack<MotorCycleSpots> motorSpots = new Stack<MotorCycleSpots>();
	private Stack<CompactSpots> compactSpots = new Stack<CompactSpots>();
	private List<LargeSpots> largeSpots = new ArrayList<LargeSpots>();
	private ParkingHandler() {
		
	}
	
	void addMotorSpots(List<MotorCycleSpots> list) {
		for(MotorCycleSpots m: list)
			motorSpots.push(m);
	}
	void addCompactSpots(List<CompactSpots> list) {
		for(CompactSpots m: list)
			compactSpots.push(m);
	}
	void addLargeSpots(List<LargeSpots> list) {
		largeSpots.addAll(list);
	}
	
	static ParkingHandler getInstance() {
		if(handler==null) {
			handler = new ParkingHandler();
		}
		return handler;
	}
	
	boolean vehicleEnter(Vehicle vehicle) {
		
		if(vehicle instanceof Motorcycle) {
			Spot spot = getBestPossibleSpotforMotorCycle();
			if(spot==null)
				return false;
			else {
				Motorcycle m = (Motorcycle) vehicle;
				m.spotNumber = spot;
			}
		}
		else if(vehicle instanceof Car) {
			Spot spot = getBestPossibleSpotforCar();
			if(spot==null)
				return false;
			else {
				Car c = (Car) vehicle;
				c.spotNumber = spot;
			}
		}
		else {
			Spot[] spot = getBestPossibleSpotforBus();
			if(spot[0]==null)
				return false;
			else {
				Bus b = (Bus) vehicle;
				b.spotNumbers = spot;
			}
		}
		vehicle.entryTime = new Date();
		
		return true;
	}
	
	private Spot getBestPossibleSpotforMotorCycle() {
		
		Spot spot = null;
		if(!motorSpots.isEmpty()) {
			spot = motorSpots.pop();
			spot.Level.avaliablemotorCycleSpots--;
		}
		else if(!compactSpots.isEmpty()) {
			spot = compactSpots.pop();
			spot.Level.avaliablecompactSpots--;
		}
		else  {
			for(LargeSpots l: largeSpots) {
				if(l.isAvaliable) {
					spot = l;
					spot.Level.avaliablelargeSpots--;
					break;
				}
			}
			
		}
		spot.isAvaliable = false;
		return spot;
	}
	
	private Spot getBestPossibleSpotforCar() {
		
		Spot spot = null;
		if(!compactSpots.isEmpty()) {
			spot = compactSpots.pop();
			spot.Level.avaliablecompactSpots--;
		}
		else {
			for(LargeSpots l: largeSpots) {
				if(l.isAvaliable) {
					spot = l;
					spot.Level.avaliablelargeSpots--;
					break;
				}
			}
		}
		spot.isAvaliable = false;
		return spot;
	}

	private Spot[] getBestPossibleSpotforBus() {
	
		Spot[] spot = new Spot[5];
		// get 5 continuos 5 large spot for Bus from largeSpots and templargeSpots
		int start = 0;
		int levelId = -1;
		char row = 0;
		Stack<LargeSpots> stack = new Stack<LargeSpots>();
		for(int i = 0; i < largeSpots.size(); i++) {
			LargeSpots l = largeSpots.get(i);
			if(stack.size()==5) {
				int j = 0;
				while(!stack.isEmpty()) {
					stack.peek().isAvaliable = false;
					spot[j] = stack.pop();
				}
				spot[0].Level.avaliablelargeSpots -= 5;
			}	
			if(l.isAvaliable && (levelId==-1 || (l.Level.level == levelId && l.Level.row == row))) {
					if(levelId==-1) {
						levelId = l.Level.level;
						row = l.Level.row;
					}
					stack.push(l);
			}
			else {
				levelId = -1;
				stack.clear();
			}
		}
		
		return spot;
	}
	
	
	
	void vehicleExit(Vehicle vehicle) {
		vehicle.exitTime = new Date();
		vehicle.cost = calculateCost(vehicle.entryTime,vehicle.exitTime,vehicle);
		Spot spot = null;
		if(vehicle instanceof Motorcycle) {
			spot = ((Motorcycle) vehicle).spotNumber;
		}
		else if(vehicle instanceof Car) {
			spot = ((Car) vehicle).spotNumber;
		}
		else {
			Spot[] spots = new Spot[5];
			spots = ((Bus) vehicle).spotNumbers;
			int i = 0;
			while(i<5) {
				spots[i].isAvaliable = true;
				i++;
			}
			spots[0].Level.avaliablelargeSpots += 5;
			return;
		}
		
		if(spot instanceof MotorCycleSpots) {
			motorSpots.push((MotorCycleSpots) spot);
			spot.Level.avaliablemotorCycleSpots++;
		}
		else if(spot instanceof CompactSpots) {
			compactSpots.push((CompactSpots) spot);
			spot.Level.avaliablecompactSpots++;
		}
		spot.isAvaliable = true;
			
	}
	
	private float calculateCost(Date entry,Date exit,Vehicle vehicle) {
		float cost = 0;
		// calculate cost based on entry and exit times and type of vehicle and return
		return cost;
	}
	
}
