package org.training.jps;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
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
	String firstTag = "<br>";

	@RequestMapping(name = "selectEmployee", value = "/getEmployee", method = RequestMethod.GET, produces = "text/html")
	@ResponseBody
	public String getEmployeeById(@RequestParam("id") int id) {

		try (Session session = factory.openSession()) {

			String hql = "FROM Employee WHERE id = ?";
			Query query = session.createQuery(hql);
			query.setParameter(0, id);

			@SuppressWarnings("unchecked")
			List<Employee> employeeResults = query.getResultList();

			StringBuilder sbEmployee = new StringBuilder();
			employeeResults.forEach(employeeValue -> sbEmployee.append(employeeValue.getName()).append(firstTag));

			logger.debug("Getting Employee by using ID");

			return sbEmployee.toString();

		}

	}

	@RequestMapping(name = "selectAddress", value = "/getAddress", method = RequestMethod.GET, produces = "text/html")
	@ResponseBody
	public String getAddressById(@RequestParam("id") int id) {

		try (Session session = factory.openSession()) {

			String hql = "FROM Address where id = ?";
			Query query = session.createQuery(hql);
			query.setParameter(0, id);

			@SuppressWarnings("unchecked")
			List<Address> addressResults = query.getResultList();

			logger.debug("Getting Address by using ID");

			StringBuilder sbAddress = new StringBuilder();

			addressResults.forEach(addressType -> sbAddress.append(addressType.getDoorno()).append(firstTag)
					.append(addressType.getState()).append(firstTag).append(addressType.getStreetname())
					.append(firstTag).append(addressType.getState()));

			return sbAddress.toString();
		}

	}

	@RequestMapping(value = "/putemployee", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String setEmployeeDetails(@RequestBody Employee e)
	/*
	 * @RequestParam("employeeId") int employeeId, @RequestParam("bonus") int
	 * bonus,
	 * 
	 * @RequestParam("designation") String designation, @RequestParam("doj")
	 * String doj,
	 * 
	 * @RequestParam("emailid") String emailid, @RequestParam("grade") String
	 * grade,
	 * 
	 * @RequestParam("name") String name, @RequestParam("salary") int
	 * salary, @RequestParam("doorno") int doorno,
	 * 
	 * @RequestParam("streetname") String streetname, @RequestParam("state")
	 * String state
	 */

	{

		System.out.println("Setting employee Details");
		System.out.println(" EEE :: " + e.toString());

		/*
		 * try (Session session = factory.openSession()) {
		 * System.out.println("Session Created"); Transaction tx =
		 * session.beginTransaction();
		 * 
		 * Employee employeeInsert = new Employee();
		 * 
		 * employeeInsert.setName(name); employeeInsert.setemailid(emailid);
		 * employeeInsert.setBonus(bonus);
		 * employeeInsert.setDesignation(designation);
		 * employeeInsert.setDoj(doj); employeeInsert.setEmployeeId(employeeId);
		 * employeeInsert.setGrade(grade); employeeInsert.setSalary(salary);
		 * 
		 * Address addressInsert = new Address();
		 * 
		 * addressInsert.setDoorno(doorno); addressInsert.setState(state);
		 * addressInsert.setStreetname(streetname);
		 * 
		 * List<Address> addressInsertList = new ArrayList<>();
		 * employeeInsert.setAddress(addressInsertList);
		 * 
		 * session.persist(employeeInsert); tx.commit();
		 * System.out.println("Commited"); return
		 * "<h1>Inserted Employee Data Successfully......</h1>";
		 * 
		 * } catch (Exception e) { logger.error(e); return "Exception occured "
		 * + e; }
		 */
		return "SUCCUESS";

	}

}
