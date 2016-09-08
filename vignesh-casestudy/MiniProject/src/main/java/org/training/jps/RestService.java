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
 * Rest Service Controller for performing CRUD Operation using Hibernate
 * 
 * @author 447482
 *
 */
@ComponentScan
@RestController
@EnableAutoConfiguration
@RequestMapping("/home")
public class RestService {

	private static final Logger logger = Logger.getLogger(RestService.class);
	public static final SessionFactory factory = Application.factoryBuilder();

	/**
	 * In rest URI localhost:8080/home/getemployee we can give paramenter
	 * employeeid=<id> for fetching all the details of id from employee table in
	 * json format
	 * 
	 * @param employeeid
	 *            Pass parameter to REST URI ?employeeid=<id>
	 * @return All address details from address table depending on employeeid
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(name = "selectEmployee", value = "/getemployee", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Employee> getEmployeeById(@RequestParam("employeeid") int employeeid) {

		try (Session session = factory.openSession()) {
			
			logger.debug("Input employeeid is "+employeeid);
			
			String hql = "FROM Employee WHERE employeeId = :eId";
			Query query = session.createQuery(hql);
			query.setParameter("eId", employeeid);
			
			logger.debug("Getting Address by using Employee ID: " + employeeid);

			return query.getResultList();

		}

	}

	/**
	 * In rest URI localhost:8080/home/getaddress we can give paramenter
	 * employeeid=<id> for fetching all the details of id from address table in
	 * json format
	 * 
	 * 
	 * @param addressid
	 *            Pass parameter to REST URI ?addressid=<id>
	 * @return All address details from address table depending on addressid
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(name = "selectAddress", value = "/getaddress", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Address> getAddressById(@RequestParam("addressid") int addressid) {

		try (Session session = factory.openSession()) {

			String hql = "FROM Address where addressid = :aId";
			Query query = session.createQuery(hql);
			query.setParameter("aId", addressid);

			logger.debug("Getting Address by using ID: " + addressid);

			return query.getResultList();
		}

	}

	/**
	 * Method: to insert employee details into DB using JSON value
	 * 
	 * @param employeeData
	 *            is the request body. Give proper JSON body in REST Client to
	 *            insert data into DB
	 */
	@RequestMapping(value = "/createemployee", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void setEmployeeDetails(@RequestBody Employee employeeData) {
		try (Session session = factory.openSession()) {
			session.beginTransaction();

			List<Address> address = employeeData.getAddress();
			for (Address address2 : address) {
				address2.setForeignId(employeeData);
			}

			session.persist(employeeData);
			session.getTransaction().commit();
		}
	}

	/**
	 * 
	 * @param employeeData
	 *            is the request body. Give proper JSON body in REST Client to
	 *            update date in DB using employeeid in JSON body
	 */
	@RequestMapping(value = "/updateemployee", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void updateEmployeeDetails(@RequestBody Employee employeeData) {
		try (Session session = factory.openSession()) {

			session.beginTransaction();

			if (employeeData.getAddress() != null) {
				List<Address> address = employeeData.getAddress();
				for (Address address2 : address) {
					address2.setForeignId(employeeData);
				}
			}

			session.update(employeeData);
			session.getTransaction().commit();
		}
	}

	/**
	 * Delete Employee details using employeeid in JSON format. It also deletes
	 * its corresponding data from child table
	 * 
	 * @param employeeData
	 * @param employeeData
	 *            is the request body. Give proper JSON body in REST Client with
	 *            employeeid field to delete data from DB
	 */
	@RequestMapping(value = "/deleteemployee", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteEmployeeDetails(@RequestBody Employee employeeData) {

		try (Session session = factory.openSession()) {

			int deleteEmployeeId = employeeData.getEmployeeId();

			session.beginTransaction();

			String hql = "delete Employee WHERE employeeId = :eid";
			Query query = session.createQuery(hql);
			query.setParameter("eid", deleteEmployeeId);

			query.executeUpdate();

			session.getTransaction().commit();

			logger.debug("Deleting Employee by using ID: " + deleteEmployeeId);
		}

	}

}
