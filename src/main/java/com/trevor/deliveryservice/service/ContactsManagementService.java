package com.trevor.deliveryservice.service;

import com.trevor.deliveryservice.data.repository.CustomerContactRepository;
import com.trevor.deliveryservice.domain.CustomerContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactsManagementService {

    private CustomerContactRepository customerContactRepository;

    @Autowired
    public ContactsManagementService(CustomerContactRepository customerContactRepository) {
        this.customerContactRepository = customerContactRepository;
    }

    public CustomerContact save(CustomerContact customerContact) {
        return customerContactRepository.save(customerContact);
    }

}
