package au.com.telstra.simcardactivator.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivateRequest {

	@NotNull
	private String iccid;
	
	@NotBlank(message = "Email is required")
	@Email(message = "Email is not valid")
	private String customerEmail;
	
	public String getIccid() {
		return iccid;
	}
	public ActivateRequest setIccid(String iccid) {
		this.iccid = iccid;
		return this;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public ActivateRequest setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
		return this;
	}
	
	@Override
	public String toString() {
		return "ActivateRequest [iccid=" + iccid + ", customerEmail=" + customerEmail + "]";
	}
	
	
}
