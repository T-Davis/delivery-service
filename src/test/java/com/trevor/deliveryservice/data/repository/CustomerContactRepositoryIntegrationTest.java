package com.trevor.deliveryservice.data.repository;

import com.trevor.deliveryservice.domain.CustomerContact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerContactRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerContactRepository customerContactRepository;

    @Test
    public void testFindByEmail() {

        // setup data scenario
        CustomerContact newContact = new CustomerContact();
        newContact.setEmail("fredj@myemail.com");

        // save test data
        entityManager.persist(newContact);

        // Find an inserted record
        CustomerContact foundContact = customerContactRepository.findByEmail("fredj@myemail.com");

        assertThat(foundContact.getEmail(), is(equalTo("fredj@myemail.com")));
    }

}