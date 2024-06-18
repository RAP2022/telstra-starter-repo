package au.com.telstra.simcardactivator.controler;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import au.com.telstra.simcardactivator.jpa.model.SimCard;
import au.com.telstra.simcardactivator.jpa.repository.SimCardRepository;
import au.com.telstra.simcardactivator.model.ActivateRequest;
import au.com.telstra.simcardactivator.service.SimCardActuatorService;

@RestController
public class SimCardActivate {


	private SimCardActuatorService simCardActuatorService;
	private SimCardRepository simCardRepo;
	
	
	public SimCardActivate(SimCardActuatorService simCardActuatorService, SimCardRepository simCardRepo) {
		super();
		this.simCardActuatorService = simCardActuatorService;
		this.simCardRepo = simCardRepo;
	}

	@PostMapping({ "/activate" })
	public SimCard handleActicvateRequest(@RequestBody @Valid ActivateRequest request) {

	
		Boolean result = simCardActuatorService.activateSimCard(request.getIccid());
		SimCard simcard = new SimCard(request.getIccid(), request.getCustomerEmail());
		simcard.setActive(result);
		simcard = simCardRepo.save(simcard);

		return simcard;

	}

	@GetMapping("/")
	public SimCard handleGetRequest(@RequestParam(value = "simCardId") Long id) {
		
		Optional<SimCard> simcard = simCardRepo.findById(id);
		
		return simcard.orElse(null);
	}
}
