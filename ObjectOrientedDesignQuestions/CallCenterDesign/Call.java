package CallCenterDesign;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Call {
	int callId;
	Employee assignTo;
	Customer customer;
	String status;
	List<CallDetails> callDetails = new ArrayList<CallDetails>();
	public Employee getAssignTo() {
		return assignTo;
	}
	public void setAssignTo(Employee assignTo) {
		this.assignTo = assignTo;
		addCallDetails(assignTo);
	}
	
	public void addCallDetails(Employee currentAssignTo) {
		callDetails.add(new CallDetails(this, currentAssignTo, new Date()));
	}
	
	
	
	
}
