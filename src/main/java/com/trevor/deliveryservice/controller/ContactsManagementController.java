package com.trevor.deliveryservice.controller;

import com.trevor.deliveryservice.domain.CustomerContact;
import com.trevor.deliveryservice.service.ContactsManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactsManagementController {

    private ContactsManagementService contactsManagementService;

    @Autowired
    public ContactsManagementController(ContactsManagementService contactsManagementService) {
        this.contactsManagementService = contactsManagementService;
    }

    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public String processContactSubmit(@ModelAttribute CustomerContact customerContact) {

        if (customerContact.getFirstName() == null) {
            return "redirect:/showAddContact";
        }
        contactsManagementService.save(customerContact);

        return "/addContactForm";
    }

    @RequestMapping(value = "/showAddContact", method = RequestMethod.GET)
    public String showAddContact() {

        return "/addContactForm";
    }
}
