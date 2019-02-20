package com.trevor.deliveryservice.controller;

import com.trevor.deliveryservice.domain.CustomerContact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactsManagementControllerIntegrationTest {

    @Autowired
    private ContactsManagementController contactsManagementController;

    @Test
    public void testSaveContactHappyPath() {

        CustomerContact contact = new CustomerContact();
        contact.setFirstName("Jenny");
        contact.setLastName("Johnson");

        // POST CustomerContact
        String outcome = contactsManagementController.processContactSubmit(contact);

        // Verify the outcome
        assertThat(outcome, is(equalTo("Success")));
    }

    @Test
    public void testSaveContactFirstNameMissing() {
        CustomerContact contact = new CustomerContact();

        // POST CustomerContact
        String outcome = contactsManagementController.processContactSubmit(contact);

        // Verify the outcome
        assertThat(outcome, is(equalTo("Failure")));

    }
}