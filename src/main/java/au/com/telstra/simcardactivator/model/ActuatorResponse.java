package au.com.telstra.simcardactivator.model;

public class ActuatorResponse {
	private Boolean success;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "ActivateResponse [success=" + success + "]";
	}
	
	
}
