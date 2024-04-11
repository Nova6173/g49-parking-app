package se.lexicon.data.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerDaoImplTest {

    private CustomerDaoImpl testObject;

    @BeforeEach
    public void setUp() {
        testObject = new CustomerDaoImpl();
    }



    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer("Janne Jansson", "12345678");
        Customer actualValue = testObject.create(customer);
        Customer expectedValue = customer;
        assertEquals (expectedValue, actualValue);
        assertEquals(1001, customer.getId ());

    }


    @Test
    public void findById() {
        Customer customer = new Customer("Janne Jansson", "012345678" );
        testObject.create(customer);
        assertTrue(testObject.find(customer.getId ()).isPresent());
    }



    @Test
    public void testNonExistentCustomer() {
        Optional<Customer> foundCustomer = testObject.find(1);
        assertFalse(foundCustomer.isPresent());


    }

    @Test
    public void testRemoveCustomer() {
        Customer customer = new Customer("Janne Jansson", "012345678" );
        testObject.create(customer);
        assertTrue(testObject.remove(customer.getId ()));
        assertFalse(testObject.find(customer.getId ()).isPresent());
    }

    @Test
    public void testRemoveNonExistentCustomer() {
        boolean removed = testObject.remove(1002);
        assertFalse(removed);
    }

    @Test
    public void testFindAllCustomers() {
        Customer customer1 = new se.lexicon.model.Customer("Kalle Anka", "01234569" );
        Customer customer2 = new se.lexicon.model.Customer("Kajsa Anka", "01993450" );
        testObject.create (customer1);
        testObject.create (customer2);
        List<Customer> expectedValue = new ArrayList<> ();
        expectedValue.add(customer1);
        expectedValue.add(customer2);
        List<Customer> actualValue = testObject.findAll();
        assertEquals(expectedValue, actualValue);


    }

    @Test
    public void testFindAllCustomersEmptyList() {
        List<Customer> expectedValue = new ArrayList<> ();
        List<Customer> actualValue = testObject.findAll();
        assertEquals(expectedValue, actualValue);



    }

}
