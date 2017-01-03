package CallCenterDesign;

import java.util.Date;

public class CallDetails {
	int id;
	Call call;
	Employee currentAssignTo;
	Date date;
	public CallDetails(Call call, Employee currentAssignTo, Date date) {
		this.call = call;
		this.currentAssignTo = currentAssignTo;
		this.date = date;
	}
	
	
}
