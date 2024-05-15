package au.com.telstra.simcardactivator.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import au.com.telstra.simcardactivator.jpa.model.SimCard;

public interface SimCardRepository extends CrudRepository<SimCard, Long> {

}
