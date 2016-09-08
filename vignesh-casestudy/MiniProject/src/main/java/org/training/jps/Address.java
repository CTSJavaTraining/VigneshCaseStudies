package org.training.jps;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Address POJO class
 * 
 * @author 447482
 *
 */
@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 6)
	private int addressid;

	@ManyToOne
	@JoinColumn(name = "id", foreignKey = @ForeignKey(name = "CHILD_EMPLOYEE_FK"))
	@JsonIgnore
	private Employee foreignId;

	@Column(length = 4)
	private int doorno;

	@Column(length = 50)
	private String streetname;

	@Column(length = 25)
	private String state;

	/**
	 * @return the addressid
	 */
	public int getAddressid() {
		return addressid;
	}

	/**
	 * @param addressid
	 *            the addressid to set
	 */
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	/**
	 * @return the foreignId
	 */
	public Employee getForeignId() {
		return foreignId;
	}

	/**
	 * @param foreignId
	 *            the foreignId to set
	 */
	public void setForeignId(Employee foreignId) {
		this.foreignId = foreignId;
	}

	/**
	 * @return the doorno
	 */
	public int getDoorno() {
		return doorno;
	}

	/**
	 * @param doorno
	 *            the doorno to set
	 */
	public void setDoorno(int doorno) {
		this.doorno = doorno;
	}

	/**
	 * @return the streetname
	 */
	public String getStreetname() {
		return streetname;
	}

	/**
	 * @param streetname
	 *            the streetname to set
	 */
	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

}
