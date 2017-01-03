package ParkingLotDesign;

import java.util.Date;

public class Vehicle {
	int id;
	String vehlicleId;
	Date entryTime;
	Date exitTime;
	float cost;
	public Vehicle(int id, String vehlicleId) {
		super();
		this.id = id;
		this.vehlicleId = vehlicleId;
	}
	
}

class Motorcycle extends Vehicle {
	Spot spotNumber;
	public Motorcycle(int id, String vehlicleId) {
		super(id, vehlicleId);
		// TODO Auto-generated constructor stub
	}

	
}

class Car extends Vehicle {
	Spot spotNumber;
	public Car(int id, String vehlicleId) {
		super(id, vehlicleId);
		// TODO Auto-generated constructor stub
	}
}

class Bus extends Vehicle {
	Spot[] spotNumbers = new Spot[5];
	public Bus(int id, String vehlicleId) {
		super(id, vehlicleId);
		// TODO Auto-generated constructor stub
	}
}