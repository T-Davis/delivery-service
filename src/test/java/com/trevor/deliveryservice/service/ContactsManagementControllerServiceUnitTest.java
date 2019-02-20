package com.trevor.deliveryservice.service;

import com.trevor.deliveryservice.data.repository.CustomerContactRepository;
import com.trevor.deliveryservice.domain.CustomerContact;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ContactsManagementControllerServiceUnitTest {

    @Mock
    private CustomerContactRepository customerContactRepository;

    @InjectMocks
    private ContactsManagementService contactsManagementService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveContactHappyPath() {

        // Create a contact
        CustomerContact mockContact = new CustomerContact();
        mockContact.setFirstName("Jenny");
        mockContact.setLastName("Smith");

        when(customerContactRepository.save(any(CustomerContact.class))).thenReturn(mockContact);

        // Save the contact
        CustomerContact newContact = contactsManagementService.save(mockContact);

        // Verify the save
        verify(customerContactRepository, atLeastOnce()).save(mockContact);
        assertEquals("Jenny", newContact.getFirstName());
    }
}
