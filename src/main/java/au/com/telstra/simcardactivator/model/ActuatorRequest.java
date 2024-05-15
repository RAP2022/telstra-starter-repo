package au.com.telstra.simcardactivator.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActuatorRequest {

	private String iccid;

	public String getIccid() {
		return iccid;
	}

	public ActuatorRequest setIccid(String iccid) {
		this.iccid = iccid;
		return this;
	}

	@Override
	public String toString() {
		return "ActuatorRequest [iccid=" + iccid + "]";
	}
}
