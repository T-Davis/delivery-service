package com.trevor.deliveryservice.data.repository;

import com.trevor.deliveryservice.domain.CustomerContact;
import org.springframework.data.repository.CrudRepository;

public interface CustomerContactRepository extends CrudRepository<CustomerContact, Long> {

}
