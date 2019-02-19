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
public class ContactsManagementController {

    private ContactsManagementService contactsManagementService;

    @Autowired
    public ContactsManagementController(ContactsManagementService contactsManagementService) {
        this.contactsManagementService = contactsManagementService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processContactSubmit(@RequestBody CustomerContact customerContact) {

        if (customerContact.getFirstName() == null) {
            return "Failure";
        }

        return "Success";
    }
}
