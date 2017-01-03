package ParkingLotDesign;

public class ExecuteClass {
	
	public static void main(String[] args) {
		Level level = new Level(1,'A');
		MotorCycleSpots m1 = new MotorCycleSpots(level, 1, true);
		MotorCycleSpots m2 = new MotorCycleSpots(level, 2, true);
		MotorCycleSpots m3 = new MotorCycleSpots(level, 3, true);
		level.addMotorCycleSpots(m1);
		level.addMotorCycleSpots(m2);
		level.addMotorCycleSpots(m3);
		ParkingHandler handler = ParkingHandler.getInstance();
		handler.addMotorSpots(level.motorCycleSpots);
		Motorcycle vehicle = new Motorcycle(1, "ABC");
		System.out.println("Avaliable motorcycle spots in Level "+ level.level+" :" +level.avaliablemotorCycleSpots);
		handler.vehicleEnter(vehicle);
		System.out.println("Vehicle "+vehicle.vehlicleId+" is taken the slot in level "
				+vehicle.spotNumber.Level.level+" row "+vehicle.spotNumber.Level.row+" number "+vehicle.spotNumber.number);
		System.out.println("Avaliable motorcycle spots in Level "+ level.level+" :" +level.avaliablemotorCycleSpots);
		handler.vehicleExit(vehicle);
		System.out.println("Vehicle "+vehicle.vehlicleId+" left");
		System.out.println("Avaliable motorcycle spots in Level "+ level.level +" :"+level.avaliablemotorCycleSpots);
	}
}
