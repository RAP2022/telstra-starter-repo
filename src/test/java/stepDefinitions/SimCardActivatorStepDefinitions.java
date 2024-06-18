package stepDefinitions;

import au.com.telstra.simcardactivator.SimCardActivator;
import au.com.telstra.simcardactivator.jpa.model.SimCard;
import au.com.telstra.simcardactivator.model.ActivateRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = SimCardActivator.class, loader = SpringBootContextLoader.class)
public class SimCardActivatorStepDefinitions {
    @Autowired
    private TestRestTemplate restTemplate;

    private String simCardId;
    private String status;
    private static Long id=0L;
    
    private String backendUrl= "http://127.0.0.1:8080/";
    
    @Given("the SIM card ID {string}")
    public void sim_card_id_is(String simCardId) {
        this.simCardId = simCardId;
    	status = "";

    }
    
    @When("I activate it")
    public void i_activate_it() {
    	ActivateRequest req = new ActivateRequest();
    	req.setIccid(simCardId).setCustomerEmail("test@test.com");
    	restTemplate.postForObject(backendUrl+"activate", req, SimCard.class);
        SimCardActivatorStepDefinitions.id++;
    }
    
    @Then("The activate status should be {string}")
    public void i_should_be_told(String expectedStatus) {
    	System.out.println( SimCardActivatorStepDefinitions.id);
    	SimCard rsp = restTemplate.getForObject(backendUrl+"?simCardId=" + SimCardActivatorStepDefinitions.id, SimCard.class);
    	status = rsp.getActive().toString();

        assertEquals(expectedStatus, status);
    }
    
}