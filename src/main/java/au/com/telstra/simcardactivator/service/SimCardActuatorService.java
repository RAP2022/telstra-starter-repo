package au.com.telstra.simcardactivator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import au.com.telstra.simcardactivator.model.ActuatorRequest;
import au.com.telstra.simcardactivator.model.ActuatorResponse;

@Service
public class SimCardActuatorService {

	@Autowired
	RestTemplate restTemplate;

	@Value("${backend.server.url:http://localhost:8444/actuate}")
	String backendUrl;

	public Boolean activateSimCard(String iccid) {
		ActuatorRequest req = new ActuatorRequest();
		req.setIccid(iccid);
		
		ActuatorResponse rsp = restTemplate.postForObject(backendUrl, req, ActuatorResponse.class);

		return rsp.getSuccess();
	}

}
