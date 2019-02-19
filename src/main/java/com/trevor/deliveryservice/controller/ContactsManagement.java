package com.trevor.deliveryservice.controller;

import com.trevor.deliveryservice.domain.CustomerContact;
import com.trevor.deliveryservice.service.ContactsManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/addContact")
public class ContactsManagement {

    private ContactsManagementService contactsManagementService;

    @Autowired
    public ContactsManagement(ContactsManagementService contactsManagementService) {
        this.contactsManagementService = contactsManagementService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processContactSubmit(@RequestBody CustomerContact customerContact) {

        CustomerContact newContact = contactsManagementService.save(customerContact);

        if (newContact != null) {
            return "Success";
        }

        return "Failure";
    }
}
