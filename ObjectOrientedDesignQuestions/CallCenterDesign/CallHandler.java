package CallCenterDesign;

import java.util.LinkedList;
import java.util.Queue;

public class CallHandler {
	private static CallHandler manageCalls = null;
	private Queue<respondent> respondents = new LinkedList<respondent>();
	private Queue<Call> callWaitingList = new LinkedList<Call>();
	private CallHandler(){
		
	}
	
	static CallHandler getInstance() {
		if(manageCalls==null) {
			manageCalls = new CallHandler();
		}
		return manageCalls;
	}
	
	void addRespondents(respondent r) {
		respondents.add(r);
	}
	
	void dispatchCall(Call call) {
		callWaitingList.add(call);
		call.status = "waiting";
		dispatchCall();
	}
	
	void dispatchCall() {
		if(!callWaitingList.isEmpty()) {
			if(respondents.isEmpty()) {
				System.out.println("All the representatives are busy please hold line.");
			}
			else {
				
				Employee respondent = respondents.poll();
				while(!respondents.isEmpty() && !respondent.activeStatus)
					respondent = respondents.poll();
					
				if(respondent.activeStatus) {
					respondent.activeStatus = false;
					Call call = callWaitingList.poll();
					call.status = "Ongoing";
					call.setAssignTo(respondent);
				}
				else {
					System.out.println("All the representatives are busy please hold line.");
				}
				
			}
		}
	}
	
	void endCall(Call call) {
		call.status = "Ended";
		Employee respondent = call.assignTo;
		respondent.activeStatus = true;
		respondents.add((CallCenterDesign.respondent) respondent);
		dispatchCall();
	}
	
	void escalateCall(Call call) {
		Employee emp = call.assignTo.supervisor;
		while(!emp.activeStatus &&  !(emp instanceof director)) {
			emp = emp.supervisor;
		}
		call.addCallDetails(emp);
	}
	
	
	
	
}
