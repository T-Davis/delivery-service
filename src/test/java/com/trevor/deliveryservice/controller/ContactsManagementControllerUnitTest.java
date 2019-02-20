package com.trevor.deliveryservice.controller;

import com.trevor.deliveryservice.domain.CustomerContact;
import com.trevor.deliveryservice.service.ContactsManagementService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactsManagementController.class)
public class ContactsManagementControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactsManagementService contactsManagementService;

    @InjectMocks
    private ContactsManagementController contactsManagementController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveContactHappyPath() throws Exception {

        // setup mock Contact
        CustomerContact customerContact = new CustomerContact();
        customerContact.setFirstName("Fred");

        // return mock contact
        when(contactsManagementService.save(any(CustomerContact.class)))
                .thenReturn(customerContact);

        // simulate POST data
        CustomerContact newContact = new CustomerContact();
        newContact.setFirstName("Fred");

        // simulate POST
        mockMvc.perform(post("/addContact", newContact))
                .andExpect(status().isOk())
                .andReturn();
    }

}