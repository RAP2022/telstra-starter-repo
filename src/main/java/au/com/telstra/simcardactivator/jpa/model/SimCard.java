package au.com.telstra.simcardactivator.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SimCard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String iccid;
	private String customerEmail;
	private Boolean active;

	
	public SimCard(String iccid, String customerEmail) {
		super();
		this.iccid = iccid;
		this.customerEmail = customerEmail;
	}
	
	public SimCard() {
		super();
	}
	
	@JsonIgnore
	public long getId() {
		return id;
	}

	public String getIccid() {
		return iccid;
	}



	public void setIccid(String iccid) {
		this.iccid = iccid;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean activated) {
		this.active = activated;
	}

	@Override
	public String toString() {
		return "SimCard [id=" + id + ", iccid=" + iccid + ", customerEmail=" + customerEmail + ", active="
				+ active + "]";
	}

}
