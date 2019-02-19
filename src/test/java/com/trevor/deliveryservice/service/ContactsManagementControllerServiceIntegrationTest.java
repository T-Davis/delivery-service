package com.trevor.deliveryservice.service;

import com.trevor.deliveryservice.domain.CustomerContact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class ContactsManagementControllerServiceIntegrationTest {

    @Autowired
    private ContactsManagementService contactsManagementService;


    @Test
    public void testSaveContactHappyPath() {

        // Create a contact
        CustomerContact contact = new CustomerContact();
        contact.setFirstName("Jenifer");
        contact.setLastName("Smith");

        // Test saving the contact
        CustomerContact savedContact = contactsManagementService.save(contact);

        // Verify the save
        assertNotNull(savedContact);
        assertNotNull(savedContact.getId());
        assertEquals("Jenifer", savedContact.getFirstName());
    }
}