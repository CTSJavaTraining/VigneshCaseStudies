package org.training.jps;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class TestController {

	private static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	private static final Logger logger = Logger.getLogger(TestController.class);

	Employee emp2 = new Employee();

	@RequestMapping(name = "selectEmployee", path = "/getEmployee", method = org.springframework.web.bind.annotation.RequestMethod.GET, produces = "text/plain")
	@ResponseBody
	public List<Employee> getEmployeeById(@RequestParam("id") int id) {

		try (Session session = factory.openSession()) {

			String hql = "FROM Employee WHERE id = ?";
			Query query = session.createQuery(hql);
			query.setParameter(0, id);

			@SuppressWarnings("unchecked")
			List<Employee> employeeResults = query.getResultList();

			logger.debug("Getting Employee by using ID");
			// return "<h1>Enter ID: to fetch employee details</h1><h2>Employee
			// Details are/is </h2><hr>"
			return employeeResults;
		}

	}

	@RequestMapping(name = "selectAddress", path = "/getAddress", method = org.springframework.web.bind.annotation.RequestMethod.GET, produces = "text/plain")
	@ResponseBody
	public List<Address> getAddressById(@RequestParam("id") int id) {

		try (Session session = factory.openSession()) {

			String hql = "FROM Address where id = ?";
			Query query = session.createQuery(hql);
			query.setParameter(0, id);

			@SuppressWarnings("unchecked")
			List<Address> addressResults = query.getResultList();

			logger.debug("Getting Address by using ID");

			// return "<h1>Enter ID: to fetch address details</h1><h2>Address
			// Details are/is </h2><hr>"
			return addressResults;
		}

	}

	@RequestMapping(name = "insertEmployee", path = "/putEmployee", method = org.springframework.web.bind.annotation.RequestMethod.POST, produces = "text/html")
	@ResponseBody
	public String setEmployeeDetails(@RequestParam("employeeId") int employeeId, @RequestParam("bonus") int bonus,
			@RequestParam("designation") String designation, @RequestParam("doj") String doj,
			@RequestParam("emailid") String emailid, @RequestParam("grade") String grade,
			@RequestParam("name") String name, @RequestParam("salary") int salary, @RequestParam("doorno") int doorno,
			@RequestParam("streetname") String streetname, @RequestParam("state") String state)

	{

		try (Session session = factory.openSession()) {
			Transaction tx = session.beginTransaction();

			Employee employeeInsert = new Employee();

			employeeInsert.setName(name);
			employeeInsert.setemailid(emailid);
			employeeInsert.setBonus(bonus);
			employeeInsert.setDesignation(designation);
			employeeInsert.setDoj(doj);
			employeeInsert.setEmployeeId(employeeId);
			employeeInsert.setGrade(grade);
			employeeInsert.setSalary(salary);

			Address addressInsert = new Address();

			addressInsert.setDoorno(doorno);
			addressInsert.setState(state);
			addressInsert.setStreetname(streetname);

			List<Address> addressInsertList = new ArrayList<>();
			employeeInsert.setAddress(addressInsertList);

			session.persist(employeeInsert);
			tx.commit();

			return "<h1>Inserted Employee Data Successfully......</h1>";

		} catch (Exception e) {
			logger.error(e);
			return "Exception occured " + e;
		}

	}

}
