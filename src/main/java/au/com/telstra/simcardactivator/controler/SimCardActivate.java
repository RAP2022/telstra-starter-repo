package au.com.telstra.simcardactivator.controler;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import au.com.telstra.simcardactivator.model.ActivateRequest;
import au.com.telstra.simcardactivator.model.ActivateResponse;
import au.com.telstra.simcardactivator.service.SimCardActuatorService;

@RestController
public class SimCardActivate {

	@Autowired
	SimCardActuatorService simCardActuatorService;

	@PostMapping({ "/activate" })
	public ActivateResponse handleActicvateRequest(@RequestBody @Valid ActivateRequest request) {

		Boolean result = simCardActuatorService.activateSimCard(request.getIccid());

		System.out.println(result);

		ActivateResponse response = new ActivateResponse(result);


		return response;

	}

}
