package ParkingLotDesign;

import java.util.ArrayList;
import java.util.List;

public class Level {
	int level;
	List<Row> rows;
	
	public Level(int level,List<Row> rows) {
		this.level = level;
		this.rows = rows;
	}
}
