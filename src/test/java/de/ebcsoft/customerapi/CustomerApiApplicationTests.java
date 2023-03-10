package de.ebcsoft.customerapi;

import de.ebcsoft.customerapi.entity.Customer;
import de.ebcsoft.customerapi.repository.CustomerRepositoy;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class CustomerApiApplicationTests {

	@Autowired
	private CustomerRepositoy customerRepositoy;

	private static final String CustomerCity = "Hohenmölsen";

	@BeforeEach
	public void addCustomersToDb() {
		Customer customer = new Customer();
		customer.setBday(null);
		customer.setCity(CustomerCity);
		customer.setFirstName("Kiki");
		customer.setLastName("Walter");

		customerRepositoy.save(customer);
	}

	@AfterEach
	public void clearCustomerDb() {
		customerRepositoy.deleteAll();
	}

	@Test
	void testGetRequest() {
		TestRestTemplate restTemplate = new TestRestTemplate();

		ResponseEntity<Customer> customerEntity
			= restTemplate.getForEntity("http://localhost:8080/customer", Customer.class);

		Assert.assertEquals(customerEntity.getStatusCode(), HttpStatus.OK);
		Assert.assertNotNull(customerEntity.getBody());
		Assert.assertEquals(customerEntity.getBody().getCity(), CustomerCity);
	}

}
