package org.training.jps;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Test Controller
 * 
 * @author 447482
 *
 */
@ComponentScan
@RestController
@EnableAutoConfiguration
@RequestMapping("/home")
public class TestController {

	private static final Logger logger = Logger.getLogger(TestController.class);
	public static final SessionFactory factory = Application.factoryBuilder();

	@SuppressWarnings("unchecked")
	@RequestMapping(name = "selectEmployee", value = "/getEmployee", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Employee> getEmployeeById(@RequestParam("employeeid") int employeeid) {

		System.out.println("Inside getEmployeeId");
		try (Session session = factory.openSession()) {

			String hql = "FROM Employee WHERE employeeId = :eId";
			Query query = session.createQuery(hql);
			query.setParameter("eId", employeeid);

			logger.debug("Getting Address by using Employee ID: " + employeeid);

			return query.getResultList();

		}

	}

	@RequestMapping(name = "selectAddress", value = "/getAddress", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<?> getAddressById(@RequestParam("addressID") int addressID) {

		try (Session session = factory.openSession()) {

			String hql = "FROM Address where addressid = :aId";
			Query query = session.createQuery(hql);
			query.setParameter("aId", addressID);

			logger.debug("Getting Address by using ID: " + addressID);

			return query.getResultList();
		}

	}

	@RequestMapping(value = "/putemployee", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void setEmployeeDetails(@RequestBody Employee e) {
		try (Session session = factory.openSession()) {
			session.beginTransaction();
			List<Address> address = e.getAddress();
			for (Address address2 : address) {
				address2.setForeignId(e);
			}
			
			session.persist(e);			
			session.getTransaction().commit();
		}
	}
}
