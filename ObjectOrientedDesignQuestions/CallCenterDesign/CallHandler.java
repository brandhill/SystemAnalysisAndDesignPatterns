package CallCenterDesign;

import java.util.LinkedList;
import java.util.Queue;

public class CallHandler {
	private static CallHandler manageCalls = null;
	private Queue<Respondent> respondents = new LinkedList<Respondent>();
	private Queue<Call> callWaitingList = new LinkedList<Call>();
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	private CallHandler() {
		
	}
	
	static CallHandler getInstance() {
		if(manageCalls==null) {
			manageCalls = new CallHandler();
		}
		return manageCalls;
	}
	
	void addRespondents(Respondent r) {
		synchronized (lock1) {
			respondents.add(r);
		}
	}
	
	Respondent getRespondent() {
		synchronized (lock1) {
			return respondents.poll();
		}
	}
	
	void addToCallWaitingList(Call call) {
		synchronized (lock2) {
			callWaitingList.add(call);
		}
	}
	
	Call getFromCallWaitingList() {
		synchronized (lock2) {
			return callWaitingList.poll();
		}
	}
	void dispatchCall(Call call) {
		addToCallWaitingList(call);
		call.status = "waiting";
		dispatchCall();
	}
	
	void dispatchCall() {
		if(!callWaitingList.isEmpty()) {
			if(respondents.isEmpty()) {
				System.out.println("All the representatives are busy please hold line.");
			}
			else {
				
				Employee respondent = getRespondent();
				while(!respondents.isEmpty() && !respondent.activeStatus)
					respondent = getRespondent();
					
				if(respondent.activeStatus) {
					respondent.activeStatus = false;
					Call call = getFromCallWaitingList();
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
		addRespondents((Respondent) respondent);
		dispatchCall();
	}
	
	void escalateCall(Call call) {
		Employee emp = call.assignTo.supervisor;
		while(!emp.activeStatus &&  !(emp instanceof Director)) {
			emp = emp.supervisor;
		}
		call.addCallDetails(emp);
	}
	
	
	
	
}
