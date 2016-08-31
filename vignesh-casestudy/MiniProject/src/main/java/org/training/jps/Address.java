package org.training.jps;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int addressid;

	@Column(name = "id")
	private int foreignId;

	@Column(name = "doorno")
	private int doorno;

	@Column(name = "streetname")
	private String streetname;

	@Column(name = "state")
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
	public int getForeignId() {
		return foreignId;
	}

	/**
	 * @param foreignId
	 *            the foreignId to set
	 */
	public void setForeignId(int foreignId) {
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
