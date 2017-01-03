package ParkingLotDesign;

import java.util.Date;

public class Vehicle {
	int id;
	String vehlicleId;
	Date entryTime;
	Date exitTime;
	float cost;
}

class Motorcycle extends Vehicle {
	
	Spot spotNumber;
}

class Car extends Vehicle {
	Spot spotNumber;
}

class Bus extends Vehicle {
	Spot[] spotNumbers = new Spot[5];
}